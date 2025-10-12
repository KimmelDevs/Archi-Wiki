package com.example.archiewiki.data.model

/**
 * Enum representing the main building component categories
 * Each category has an ID and display name
 */
enum class CategoryType(val id: String, val displayName: String) {
    WALLS("walls", "Walls"),
    ROOFS("roofs", "Roofs"),
    COLUMNS("columns", "Columns"),
    FLOORS("floors", "Floors"),
    WINDOWS_DOORS("windows_doors", "Windows & Doors"),
    STAIRS("stairs", "Stairs");

    companion object {
        /**
         * Get CategoryType from its ID string
         */
        fun fromId(id: String): CategoryType? {
            return values().find { it.id == id }
        }

        /**
         * Get all categories as a list
         */
        fun getAllCategories(): List<CategoryType> {
            return values().toList()
        }
    }
}