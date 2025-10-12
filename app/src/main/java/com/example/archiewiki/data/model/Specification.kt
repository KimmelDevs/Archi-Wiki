package com.example.archiewiki.data.model

/**
 * Data class representing a specification or property of a building item
 * Used to display technical details, materials, dimensions, etc.
 *
 * @param label The specification label (e.g., "Material", "Load Capacity", "Dimensions")
 * @param value The specification value (e.g., "Clay Brick", "500 kg/m²", "200x100x50 mm")
 * @param unit Optional unit of measurement
 * @param category Optional category for grouping specs (e.g., "Physical", "Structural", "Aesthetic")
 */
data class Specification(
    val label: String,
    val value: String,
    val unit: String? = null,
    val category: String? = null
) {
    /**
     * Get formatted display text with unit if available
     */
    fun getDisplayValue(): String {
        return if (unit != null) {
            "$value $unit"
        } else {
            value
        }
    }
}

/**
 * Common specification categories
 */
object SpecCategory {
    const val MATERIAL = "Material"
    const val STRUCTURAL = "Structural"
    const val DIMENSIONAL = "Dimensional"
    const val AESTHETIC = "Aesthetic"
    const val PERFORMANCE = "Performance"
    const val INSTALLATION = "Installation"
    const val MAINTENANCE = "Maintenance"
}