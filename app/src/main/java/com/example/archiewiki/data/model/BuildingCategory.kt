package com.example.archiewiki.data.model

import androidx.compose.ui.graphics.Color

/**
 * Data class representing a building component category
 * Used for displaying categories on the Home screen
 *
 * @param id Unique identifier for the category
 * @param type The CategoryType enum value
 * @param name Display name of the category
 * @param description Brief description of what this category includes
 * @param iconName Name of the icon to use (for icon mapping)
 * @param color Primary color for this category
 * @param itemCount Number of items in this category
 * @param examples Sample examples of items in this category
 */
data class BuildingCategory(
    val id: String,
    val type: CategoryType,
    val name: String,
    val description: String,
    val iconName: String,
    val color: Color,
    val itemCount: Int = 0,
    val examples: List<String> = emptyList()
) {
    /**
     * Get a short summary for display
     */
    fun getSummary(): String {
        return if (examples.isNotEmpty()) {
            examples.take(3).joinToString(", ")
        } else {
            description
        }
    }
}