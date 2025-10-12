package com.example.archiewiki.data.model

/**
 * Data class representing detailed information about a building item
 * Contains full description, specifications, images, uses, and examples
 *
 * @param itemId Reference to the BuildingItem ID
 * @param fullDescription Comprehensive description of the item
 * @param specifications List of technical specifications
 * @param materials List of materials used
 * @param advantages List of advantages/benefits
 * @param disadvantages List of disadvantages/limitations
 * @param commonUses List of common applications
 * @param historicalInfo Optional historical context
 * @param imageUrls List of image URLs for gallery
 * @param exampleProjects Optional list of example projects using this item
 * @param installationNotes Optional installation guidelines
 * @param maintenanceNotes Optional maintenance information
 */
data class ItemDetail(
    val itemId: String,
    val fullDescription: String,
    val specifications: List<Specification> = emptyList(),
    val materials: List<String> = emptyList(),
    val advantages: List<String> = emptyList(),
    val disadvantages: List<String> = emptyList(),
    val commonUses: List<String> = emptyList(),
    val historicalInfo: String? = null,
    val imageUrls: List<String> = emptyList(),
    val exampleProjects: List<ExampleProject> = emptyList(),
    val installationNotes: String? = null,
    val maintenanceNotes: String? = null
) {
    /**
     * Get specifications grouped by category
     */
    fun getSpecsByCategory(): Map<String, List<Specification>> {
        return specifications.groupBy { it.category ?: "General" }
    }

    /**
     * Check if item has images
     */
    fun hasImages(): Boolean = imageUrls.isNotEmpty()

    /**
     * Check if item has detailed specs
     */
    fun hasSpecs(): Boolean = specifications.isNotEmpty()
}

/**
 * Data class for example projects/buildings
 */
data class ExampleProject(
    val name: String,
    val location: String? = null,
    val architect: String? = null,
    val year: Int? = null,
    val description: String? = null,
    val imageUrl: String? = null
)