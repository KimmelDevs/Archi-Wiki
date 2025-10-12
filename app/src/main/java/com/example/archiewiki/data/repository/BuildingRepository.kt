package com.example.archiewiki.data.repository

import com.example.archiewiki.data.model.BuildingCategory
import com.example.archiewiki.data.model.BuildingItem
import com.example.archiewiki.data.model.CategoryType
import com.example.archiewiki.data.model.ItemDetail
import kotlinx.coroutines.flow.Flow

/**
 * Repository interface for building-related data operations
 * Provides abstraction layer between data sources and ViewModels
 */
interface BuildingRepository {

    // ==================== CATEGORIES ====================

    /**
     * Get all building categories
     */
    suspend fun getAllCategories(): List<BuildingCategory>

    /**
     * Get category by ID
     */
    suspend fun getCategoryById(categoryId: String): BuildingCategory?

    /**
     * Get category by type
     */
    suspend fun getCategoryByType(type: CategoryType): BuildingCategory?

    /**
     * Observe all categories as Flow
     */
    fun observeCategories(): Flow<List<BuildingCategory>>

    // ==================== ITEMS ====================

    /**
     * Get all building items
     */
    suspend fun getAllItems(): List<BuildingItem>

    /**
     * Get item by ID
     */
    suspend fun getItemById(itemId: String): BuildingItem?

    /**
     * Get items by category type
     */
    suspend fun getItemsByCategory(categoryType: CategoryType): List<BuildingItem>

    /**
     * Get popular/featured items
     */
    suspend fun getPopularItems(): List<BuildingItem>

    /**
     * Search items by query
     */
    suspend fun searchItems(query: String, categoryFilter: CategoryType? = null): List<BuildingItem>

    /**
     * Get related items for a specific item
     */
    suspend fun getRelatedItems(itemId: String): List<BuildingItem>

    /**
     * Observe all items as Flow
     */
    fun observeItems(): Flow<List<BuildingItem>>

    // ==================== ITEM DETAILS ====================

    /**
     * Get detailed information for an item
     */
    suspend fun getItemDetail(itemId: String): ItemDetail?

    // ==================== FAVORITES ====================

    /**
     * Add item to favorites
     */
    suspend fun addToFavorites(itemId: String): Boolean

    /**
     * Remove item from favorites
     */
    suspend fun removeFromFavorites(itemId: String): Boolean

    /**
     * Check if item is favorited
     */
    suspend fun isFavorite(itemId: String): Boolean

    /**
     * Get all favorite items
     */
    suspend fun getFavoriteItems(): List<BuildingItem>

    /**
     * Observe favorites as Flow
     */
    fun observeFavorites(): Flow<List<BuildingItem>>

    // ==================== RECENT SEARCHES ====================

    /**
     * Add search query to recent searches
     */
    suspend fun addRecentSearch(query: String)

    /**
     * Get recent search queries
     */
    suspend fun getRecentSearches(): List<String>

    /**
     * Clear all recent searches
     */
    suspend fun clearRecentSearches()
}