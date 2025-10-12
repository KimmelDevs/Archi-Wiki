package com.example.archiewiki.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.archiewiki.data.model.BuildingItem
import com.example.archiewiki.data.model.CategoryType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/**
 * ViewModel for the Browse screen
 * Manages alphabetical listing and filtering of all building items
 */
class BrowseViewModel : ViewModel() {

    // All items
    private val _allItems = MutableStateFlow<List<BuildingItem>>(emptyList())
    val allItems: StateFlow<List<BuildingItem>> = _allItems.asStateFlow()

    // Filtered items
    private val _filteredItems = MutableStateFlow<List<BuildingItem>>(emptyList())
    val filteredItems: StateFlow<List<BuildingItem>> = _filteredItems.asStateFlow()

    // UI State
    private val _uiState = MutableStateFlow<BrowseUiState>(BrowseUiState.Loading)
    val uiState: StateFlow<BrowseUiState> = _uiState.asStateFlow()

    // Selected category filter
    private val _selectedCategory = MutableStateFlow<CategoryType?>(null)
    val selectedCategory: StateFlow<CategoryType?> = _selectedCategory.asStateFlow()

    // Sort order
    private val _sortOrder = MutableStateFlow(SortOrder.ALPHABETICAL)
    val sortOrder: StateFlow<SortOrder> = _sortOrder.asStateFlow()

    init {
        loadAllItems()
    }

    /**
     * Load all building items
     */
    private fun loadAllItems() {
        viewModelScope.launch {
            _uiState.value = BrowseUiState.Loading

            try {
                // TODO: Replace with repository call
                // val items = repository.getAllItems()

                val items = emptyList<BuildingItem>() // Placeholder

                _allItems.value = items
                applyFilters()

                _uiState.value = if (items.isEmpty()) {
                    BrowseUiState.Empty
                } else {
                    BrowseUiState.Success
                }
            } catch (e: Exception) {
                _uiState.value = BrowseUiState.Error(e.message ?: "Failed to load items")
            }
        }
    }

    /**
     * Set category filter
     */
    fun setCategory(category: CategoryType?) {
        _selectedCategory.value = category
        applyFilters()
    }

    /**
     * Set sort order
     */
    fun setSortOrder(order: SortOrder) {
        _sortOrder.value = order
        applyFilters()
    }

    /**
     * Apply filters and sorting
     */
    private fun applyFilters() {
        var filtered = _allItems.value

        // Apply category filter
        _selectedCategory.value?.let { category ->
            filtered = filtered.filter { it.category == category }
        }

        // Apply sorting
        filtered = when (_sortOrder.value) {
            SortOrder.ALPHABETICAL -> filtered.sortedBy { it.name }
            SortOrder.CATEGORY -> filtered.sortedBy { it.category.displayName }
            SortOrder.POPULAR -> filtered.sortedByDescending { it.isPopular }
        }

        _filteredItems.value = filtered
    }

    /**
     * Clear all filters
     */
    fun clearFilters() {
        _selectedCategory.value = null
        _sortOrder.value = SortOrder.ALPHABETICAL
        applyFilters()
    }

    /**
     * Refresh items
     */
    fun refresh() {
        loadAllItems()
    }

    /**
     * Get items grouped by first letter
     */
    fun getItemsGroupedByLetter(): Map<Char, List<BuildingItem>> {
        return _filteredItems.value
            .groupBy { it.name.first().uppercaseChar() }
            .toSortedMap()
    }
}

/**
 * UI State for Browse screen
 */
sealed class BrowseUiState {
    object Loading : BrowseUiState()
    object Success : BrowseUiState()
    object Empty : BrowseUiState()
    data class Error(val message: String) : BrowseUiState()
}

/**
 * Sort order options
 */
enum class SortOrder {
    ALPHABETICAL,
    CATEGORY,
    POPULAR
}