package com.example.archiewiki.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.archiewiki.data.model.BuildingItem
import com.example.archiewiki.data.model.CategoryType
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
class SearchViewModel : ViewModel() {

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
            delay(300) // Wait 300ms before searching
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
                // TODO: Replace with repository call
                // val results = repository.searchItems(query, _selectedCategory.value)

                val results = emptyList<BuildingItem>() // Placeholder

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
        val current = _recentSearches.value.toMutableList()
        current.remove(query) // Remove if exists
        current.add(0, query) // Add to beginning
        _recentSearches.value = current.take(10) // Keep last 10
    }

    /**
     * Clear recent searches
     */
    fun clearRecentSearches() {
        _recentSearches.value = emptyList()
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