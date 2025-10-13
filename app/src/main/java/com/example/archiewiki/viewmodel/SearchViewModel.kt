package com.example.archiewiki.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.archiewiki.data.model.BuildingItem
import com.example.archiewiki.data.model.CategoryType
import com.example.archiewiki.data.repository.BuildingRepository
import com.example.archiewiki.data.repository.BuildingRepositoryImpl
import com.example.archiewiki.util.Constants
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay

/**
 * ViewModel for the Search screen
 * Manages search query, filters, and search results
 */
class SearchViewModel(
    private val repository: BuildingRepository = BuildingRepositoryImpl()
) : ViewModel() {

    // Search query
    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    // Search results
    private val _searchResults = MutableStateFlow<List<BuildingItem>>(emptyList())
    val searchResults: StateFlow<List<BuildingItem>> = _searchResults.asStateFlow()

    // UI State
    private val _uiState = MutableStateFlow<SearchUiState>(SearchUiState.Initial)
    val uiState: StateFlow<SearchUiState> = _uiState.asStateFlow()

    // Selected category filter
    private val _selectedCategory = MutableStateFlow<CategoryType?>(null)
    val selectedCategory: StateFlow<CategoryType?> = _selectedCategory.asStateFlow()

    // Recent searches
    private val _recentSearches = MutableStateFlow<List<String>>(emptyList())
    val recentSearches: StateFlow<List<String>> = _recentSearches.asStateFlow()

    private var searchJob: Job? = null

    init {
        loadRecentSearches()
    }

    /**
     * Update search query
     */
    fun onSearchQueryChange(query: String) {
        _searchQuery.value = query

        // Cancel previous search job
        searchJob?.cancel()

        if (query.isBlank()) {
            _searchResults.value = emptyList()
            _uiState.value = SearchUiState.Initial
            return
        }

        // Debounce search
        searchJob = viewModelScope.launch {
            delay(Constants.Search.DEBOUNCE_DELAY)
            performSearch(query)
        }
    }

    /**
     * Perform search
     */
    private fun performSearch(query: String) {
        viewModelScope.launch {
            _uiState.value = SearchUiState.Searching

            try {
                val results = repository.searchItems(query, _selectedCategory.value)

                _searchResults.value = results
                _uiState.value = if (results.isEmpty()) {
                    SearchUiState.NoResults(query)
                } else {
                    SearchUiState.Success
                }

                // Add to recent searches
                addToRecentSearches(query)

            } catch (e: Exception) {
                _uiState.value = SearchUiState.Error(e.message ?: "Search failed")
            }
        }
    }

    /**
     * Set category filter
     */
    fun setCategory(category: CategoryType?) {
        _selectedCategory.value = category
        if (_searchQuery.value.isNotBlank()) {
            performSearch(_searchQuery.value)
        }
    }

    /**
     * Clear search
     */
    fun clearSearch() {
        _searchQuery.value = ""
        _searchResults.value = emptyList()
        _selectedCategory.value = null
        _uiState.value = SearchUiState.Initial
    }

    /**
     * Add query to recent searches
     */
    private fun addToRecentSearches(query: String) {
        viewModelScope.launch {
            repository.addRecentSearch(query)
            loadRecentSearches()
        }
    }

    /**
     * Load recent searches from repository
     */
    private fun loadRecentSearches() {
        viewModelScope.launch {
            try {
                val searches = repository.getRecentSearches()
                _recentSearches.value = searches
            } catch (e: Exception) {
                // Ignore errors loading recent searches
            }
        }
    }

    /**
     * Clear recent searches
     */
    fun clearRecentSearches() {
        viewModelScope.launch {
            repository.clearRecentSearches()
            _recentSearches.value = emptyList()
        }
    }
}

/**
 * UI State for Search screen
 */
sealed class SearchUiState {
    object Initial : SearchUiState()
    object Searching : SearchUiState()
    object Success : SearchUiState()
    data class NoResults(val query: String) : SearchUiState()
    data class Error(val message: String) : SearchUiState()
}