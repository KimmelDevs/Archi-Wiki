package com.example.archiewiki.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.archiewiki.data.model.BuildingItem
import com.example.archiewiki.data.model.ItemDetail
import com.example.archiewiki.data.model.Specification
import com.example.archiewiki.data.repository.BuildingRepository
import com.example.archiewiki.data.repository.BuildingRepositoryImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/**
 * ViewModel for the Item Detail screen
 * Manages detailed information about a specific building item
 */
class DetailViewModel(
    private val repository: BuildingRepository = BuildingRepositoryImpl()
) : ViewModel() {

    // Current item
    private val _item = MutableStateFlow<BuildingItem?>(null)
    val item: StateFlow<BuildingItem?> = _item.asStateFlow()

    // Item details
    private val _itemDetail = MutableStateFlow<ItemDetail?>(null)
    val itemDetail: StateFlow<ItemDetail?> = _itemDetail.asStateFlow()

    // Related items
    private val _relatedItems = MutableStateFlow<List<BuildingItem>>(emptyList())
    val relatedItems: StateFlow<List<BuildingItem>> = _relatedItems.asStateFlow()

    // UI State
    private val _uiState = MutableStateFlow<DetailUiState>(DetailUiState.Loading)
    val uiState: StateFlow<DetailUiState> = _uiState.asStateFlow()

    // Favorite state
    private val _isFavorite = MutableStateFlow(false)
    val isFavorite: StateFlow<Boolean> = _isFavorite.asStateFlow()

    // Current image index for gallery
    private val _currentImageIndex = MutableStateFlow(0)
    val currentImageIndex: StateFlow<Int> = _currentImageIndex.asStateFlow()

    /**
     * Load item details
     */
    fun loadItemDetail(itemId: String) {
        viewModelScope.launch {
            _uiState.value = DetailUiState.Loading

            try {
                val item = repository.getItemById(itemId)
                val detail = repository.getItemDetail(itemId)
                val relatedItems = repository.getRelatedItems(itemId)
                val isFav = repository.isFavorite(itemId)

                if (item != null) {
                    _item.value = item
                    _itemDetail.value = detail
                    _relatedItems.value = relatedItems
                    _isFavorite.value = isFav

                    _uiState.value = DetailUiState.Success
                } else {
                    _uiState.value = DetailUiState.Error("Item not found")
                }
            } catch (e: Exception) {
                _uiState.value = DetailUiState.Error(e.message ?: "Failed to load details")
            }
        }
    }

    /**
     * Toggle favorite status
     */
    fun toggleFavorite() {
        viewModelScope.launch {
            try {
                val itemId = _item.value?.id ?: return@launch
                val newState = !_isFavorite.value

                val success = if (newState) {
                    repository.addToFavorites(itemId)
                } else {
                    repository.removeFromFavorites(itemId)
                }

                if (success) {
                    _isFavorite.value = newState
                }
            } catch (e: Exception) {
                // Handle error - could show snackbar
            }
        }
    }

    /**
     * Update current image index
     */
    fun setImageIndex(index: Int) {
        val maxIndex = (_itemDetail.value?.imageUrls?.size ?: 1) - 1
        _currentImageIndex.value = index.coerceIn(0, maxIndex)
    }

    /**
     * Get specifications grouped by category
     */
    fun getGroupedSpecifications(): Map<String, List<Specification>> {
        return _itemDetail.value?.getSpecsByCategory() ?: emptyMap()
    }

    /**
     * Check if item has images
     */
    fun hasImages(): Boolean {
        return _itemDetail.value?.hasImages() ?: false
    }

    /**
     * Check if item has specifications
     */
    fun hasSpecifications(): Boolean {
        return _itemDetail.value?.hasSpecs() ?: false
    }

    /**
     * Get image count
     */
    fun getImageCount(): Int {
        return _itemDetail.value?.imageUrls?.size ?: 0
    }

    /**
     * Share item
     */
    fun shareItem() {
        // TODO: Implement share functionality
        // Create share intent with item details
    }

    /**
     * Refresh details
     */
    fun refresh() {
        _item.value?.id?.let { loadItemDetail(it) }
    }
}

/**
 * UI State for Item Detail screen
 */
sealed class DetailUiState {
    object Loading : DetailUiState()
    object Success : DetailUiState()
    data class Error(val message: String) : DetailUiState()
}