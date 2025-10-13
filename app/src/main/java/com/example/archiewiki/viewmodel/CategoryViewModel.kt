package com.example.archiewiki.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.archiewiki.data.model.BuildingCategory
import com.example.archiewiki.data.model.BuildingItem
import com.example.archiewiki.data.model.CategoryType
import com.example.archiewiki.data.repository.BuildingRepository
import com.example.archiewiki.data.repository.BuildingRepositoryImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/**
 * ViewModel for the Category Detail screen
 * Manages a specific category and its items
 */
class CategoryViewModel(
    private val repository: BuildingRepository = BuildingRepositoryImpl()
) : ViewModel() {

    // Current category
    private val _category = MutableStateFlow<BuildingCategory?>(null)
    val category: StateFlow<BuildingCategory?> = _category.asStateFlow()

    // Items in this category
    private val _items = MutableStateFlow<List<BuildingItem>>(emptyList())
    val items: StateFlow<List<BuildingItem>> = _items.asStateFlow()

    // UI State
    private val _uiState = MutableStateFlow<CategoryUiState>(CategoryUiState.Loading)
    val uiState: StateFlow<CategoryUiState> = _uiState.asStateFlow()

    // Filter: show popular only
    private val _showPopularOnly = MutableStateFlow(false)
    val showPopularOnly: StateFlow<Boolean> = _showPopularOnly.asStateFlow()

    // Filtered items
    private val _filteredItems = MutableStateFlow<List<BuildingItem>>(emptyList())
    val filteredItems: StateFlow<List<BuildingItem>> = _filteredItems.asStateFlow()

    /**
     * Load category and its items
     */
    fun loadCategory(categoryId: String) {
        viewModelScope.launch {
            _uiState.value = CategoryUiState.Loading

            try {
                val category = repository.getCategoryById(categoryId)

                if (category != null) {
                    val items = repository.getItemsByCategory(category.type)

                    _category.value = category
                    _items.value = items
                    applyFilters()

                    _uiState.value = if (items.isEmpty()) {
                        CategoryUiState.Empty
                    } else {
                        CategoryUiState.Success
                    }
                } else {
                    _uiState.value = CategoryUiState.Error("Category not found")
                }
            } catch (e: Exception) {
                _uiState.value = CategoryUiState.Error(e.message ?: "Failed to load category")
            }
        }
    }

    /**
     * Toggle popular filter
     */
    fun togglePopularFilter() {
        _showPopularOnly.value = !_showPopularOnly.value
        applyFilters()
    }

    /**
     * Apply filters
     */
    private fun applyFilters() {
        val filtered = if (_showPopularOnly.value) {
            _items.value.filter { it.isPopular }
        } else {
            _items.value
        }

        _filteredItems.value = filtered.sortedBy { it.name }
    }

    /**
     * Get item count
     */
    fun getItemCount(): Int = _items.value.size

    /**
     * Get popular items count
     */
    fun getPopularCount(): Int = _items.value.count { it.isPopular }

    /**
     * Refresh category
     */
    fun refresh() {
        _category.value?.id?.let { loadCategory(it) }
    }
}

/**
 * UI State for Category Detail screen
 */
sealed class CategoryUiState {
    object Loading : CategoryUiState()
    object Success : CategoryUiState()
    object Empty : CategoryUiState()
    data class Error(val message: String) : CategoryUiState()
}