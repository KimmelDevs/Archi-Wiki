package com.example.archiewiki.data.model

/**
 * Data class representing a specific building item/element
 * Examples: Brick Walls, Gable Roof, Doric Column, etc.
 *
 * @param id Unique identifier for the item
 * @param name Display name of the item
 * @param category The category this item belongs to
 * @param shortDescription Brief one-line description
 * @param thumbnailUrl Optional URL for thumbnail image
 * @param tags Search tags for this item
 * @param isPopular Whether this is a commonly used item
 * @param relatedItemIds IDs of related items
 */
data class BuildingItem(
    val id: String,
    val name: String,
    val category: CategoryType,
    val shortDescription: String,
    val thumbnailUrl: String? = null,
    val tags: List<String> = emptyList(),
    val isPopular: Boolean = false,
    val relatedItemIds: List<String> = emptyList()
) {
    /**
     * Check if this item matches a search query
     */
    fun matchesSearch(query: String): Boolean {
        val searchQuery = query.lowercase()
        return name.lowercase().contains(searchQuery) ||
                shortDescription.lowercase().contains(searchQuery) ||
                tags.any { it.lowercase().contains(searchQuery) }
    }

    /**
     * Get display category name
     */
    fun getCategoryName(): String {
        return category.displayName
    }
}