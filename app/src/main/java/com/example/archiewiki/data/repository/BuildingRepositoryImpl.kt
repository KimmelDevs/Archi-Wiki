package com.example.archiewiki.data.repository

import com.example.archiewiki.data.local.SampleData
import com.example.archiewiki.data.model.BuildingCategory
import com.example.archiewiki.data.model.BuildingItem
import com.example.archiewiki.data.model.CategoryType
import com.example.archiewiki.data.model.ItemDetail
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.delay

/**
 * Implementation of BuildingRepository using local sample data
 * In a real app, this would fetch from database or network
 */
class BuildingRepositoryImpl : BuildingRepository {

    // State flows for reactive data
    private val _categories = MutableStateFlow(SampleData.categories)
    private val _items = MutableStateFlow(SampleData.allItems)
    private val _favorites = MutableStateFlow<Set<String>>(emptySet())
    private val _recentSearches = MutableStateFlow<List<String>>(emptyList())

    // Simulated network delay (remove in production with real API)
    private val simulatedDelay = 300L

    // ==================== CATEGORIES ====================

    override suspend fun getAllCategories(): List<BuildingCategory> {
        delay(simulatedDelay) // Simulate network delay
        return SampleData.categories
    }

    override suspend fun getCategoryById(categoryId: String): BuildingCategory? {
        delay(simulatedDelay)
        return SampleData.getCategoryById(categoryId)
    }

    override suspend fun getCategoryByType(type: CategoryType): BuildingCategory? {
        delay(simulatedDelay)
        return SampleData.getCategoryByType(type)
    }

    override fun observeCategories(): Flow<List<BuildingCategory>> {
        return _categories.asStateFlow()
    }

    // ==================== ITEMS ====================

    override suspend fun getAllItems(): List<BuildingItem> {
        delay(simulatedDelay)
        return SampleData.allItems
    }

    override suspend fun getItemById(itemId: String): BuildingItem? {
        delay(simulatedDelay)
        return SampleData.getItemById(itemId)
    }

    override suspend fun getItemsByCategory(categoryType: CategoryType): List<BuildingItem> {
        delay(simulatedDelay)
        return SampleData.getItemsByCategory(categoryType)
    }

    override suspend fun getPopularItems(): List<BuildingItem> {
        delay(simulatedDelay)
        return SampleData.getPopularItems()
    }

    override suspend fun searchItems(query: String, categoryFilter: CategoryType?): List<BuildingItem> {
        delay(simulatedDelay)

        var results = SampleData.searchItems(query)

        // Apply category filter if provided
        if (categoryFilter != null) {
            results = results.filter { it.category == categoryFilter }
        }

        return results
    }

    override suspend fun getRelatedItems(itemId: String): List<BuildingItem> {
        delay(simulatedDelay)
        return SampleData.getRelatedItems(itemId)
    }

    override fun observeItems(): Flow<List<BuildingItem>> {
        return _items.asStateFlow()
    }

    // ==================== ITEM DETAILS ====================

    override suspend fun getItemDetail(itemId: String): ItemDetail? {
        delay(simulatedDelay)
        return SampleData.itemDetails[itemId]
    }

    // ==================== FAVORITES ====================

    override suspend fun addToFavorites(itemId: String): Boolean {
        return try {
            val currentFavorites = _favorites.value.toMutableSet()
            currentFavorites.add(itemId)
            _favorites.value = currentFavorites

            // TODO: In real app, persist to database or preferences
            // preferences.saveFavorites(currentFavorites)

            true
        } catch (e: Exception) {
            false
        }
    }

    override suspend fun removeFromFavorites(itemId: String): Boolean {
        return try {
            val currentFavorites = _favorites.value.toMutableSet()
            currentFavorites.remove(itemId)
            _favorites.value = currentFavorites

            // TODO: In real app, persist to database or preferences
            // preferences.saveFavorites(currentFavorites)

            true
        } catch (e: Exception) {
            false
        }
    }

    override suspend fun isFavorite(itemId: String): Boolean {
        return _favorites.value.contains(itemId)
    }

    override suspend fun getFavoriteItems(): List<BuildingItem> {
        delay(simulatedDelay)
        val favoriteIds = _favorites.value
        return SampleData.allItems.filter { it.id in favoriteIds }
    }

    override fun observeFavorites(): Flow<List<BuildingItem>> {
        // Map favorite IDs to actual items
        return MutableStateFlow(
            SampleData.allItems.filter { it.id in _favorites.value }
        ).asStateFlow()
    }

    // ==================== RECENT SEARCHES ====================

    override suspend fun addRecentSearch(query: String) {
        val current = _recentSearches.value.toMutableList()

        // Remove if already exists
        current.remove(query)

        // Add to beginning
        current.add(0, query)

        // Keep only last 10
        _recentSearches.value = current.take(10)

        // TODO: In real app, persist to preferences
        // preferences.saveRecentSearches(current)
    }

    override suspend fun getRecentSearches(): List<String> {
        return _recentSearches.value
    }

    override suspend fun clearRecentSearches() {
        _recentSearches.value = emptyList()

        // TODO: In real app, clear from preferences
        // preferences.clearRecentSearches()
    }

    // ==================== HELPER METHODS ====================

    /**
     * Load favorites from storage (call on init in real app)
     */
    private suspend fun loadFavoritesFromStorage() {
        // TODO: Load from SharedPreferences or Database
        // val savedFavorites = preferences.getFavorites()
        // _favorites.value = savedFavorites
    }

    /**
     * Load recent searches from storage (call on init in real app)
     */
    private suspend fun loadRecentSearchesFromStorage() {
        // TODO: Load from SharedPreferences
        // val savedSearches = preferences.getRecentSearches()
        // _recentSearches.value = savedSearches
    }
}