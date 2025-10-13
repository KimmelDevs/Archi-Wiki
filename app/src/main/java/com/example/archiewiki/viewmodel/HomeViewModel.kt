package com.example.archiewiki.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.archiewiki.data.model.BuildingCategory
import com.example.archiewiki.data.repository.BuildingRepository
import com.example.archiewiki.data.repository.BuildingRepositoryImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/**
 * ViewModel for the Home screen
 * Manages the list of building categories and their state
 */
class HomeViewModel(
    private val repository: BuildingRepository = BuildingRepositoryImpl()
) : ViewModel() {

    // UI State
    private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Loading)
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    // Categories list
    private val _categories = MutableStateFlow<List<BuildingCategory>>(emptyList())
    val categories: StateFlow<List<BuildingCategory>> = _categories.asStateFlow()

    init {
        loadCategories()
    }

    /**
     * Load all building categories
     */
    private fun loadCategories() {
        viewModelScope.launch {
            _uiState.value = HomeUiState.Loading

            try {
                val categories = repository.getAllCategories()

                _categories.value = categories
                _uiState.value = if (categories.isEmpty()) {
                    HomeUiState.Empty
                } else {
                    HomeUiState.Success
                }
            } catch (e: Exception) {
                _uiState.value = HomeUiState.Error(e.message ?: "Unknown error")
            }
        }
    }

    /**
     * Refresh categories
     */
    fun refresh() {
        loadCategories()
    }

    /**
     * Get category by ID
     */
    fun getCategoryById(categoryId: String): BuildingCategory? {
        return _categories.value.find { it.id == categoryId }
    }
}

/**
 * UI State for Home screen
 */
sealed class HomeUiState {
    object Loading : HomeUiState()
    object Success : HomeUiState()
    object Empty : HomeUiState()
    data class Error(val message: String) : HomeUiState()
}