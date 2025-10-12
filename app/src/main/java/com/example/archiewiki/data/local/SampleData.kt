package com.example.archiewiki.data.local


import com.example.archiewiki.data.model.*
import com.yourapp.buildingswiki.ui.theme.ColumnsColor
import com.yourapp.buildingswiki.ui.theme.FloorsColor
import com.yourapp.buildingswiki.ui.theme.RoofsColor
import com.yourapp.buildingswiki.ui.theme.StairsColor
import com.yourapp.buildingswiki.ui.theme.WallsColor
import com.yourapp.buildingswiki.ui.theme.WindowsDoorsColor

/**
 * Sample data for the Buildings Wiki app
 * Contains all categories, items, and detailed information
 */
object SampleData {

    // ==================== CATEGORIES ====================

    val categories = listOf(
        BuildingCategory(
            id = "walls",
            type = CategoryType.WALLS,
            name = "Walls",
            description = "Structural and non-structural wall systems",
            iconName = "walls",
            color = WallsColor,
            itemCount = 6,
            examples = listOf("Brick", "Concrete", "Glass Curtain", "Load-bearing", "Partition")
        ),
        BuildingCategory(
            id = "roofs",
            type = CategoryType.ROOFS,
            name = "Roofs",
            description = "Various roof types and structures",
            iconName = "roofs",
            color = RoofsColor,
            itemCount = 5,
            examples = listOf("Gable", "Hip", "Flat", "Dome", "Green Roof")
        ),
        BuildingCategory(
            id = "columns",
            type = CategoryType.COLUMNS,
            name = "Columns",
            description = "Classical and modern column styles",
            iconName = "columns",
            color = ColumnsColor,
            itemCount = 5,
            examples = listOf("Doric", "Ionic", "Corinthian", "Steel", "Reinforced Concrete")
        ),
        BuildingCategory(
            id = "floors",
            type = CategoryType.FLOORS,
            name = "Floors",
            description = "Floor systems and materials",
            iconName = "floors",
            color = FloorsColor,
            itemCount = 5,
            examples = listOf("Wood", "Tile", "Concrete", "Raised Floor", "Mezzanine")
        ),
        BuildingCategory(
            id = "windows_doors",
            type = CategoryType.WINDOWS_DOORS,
            name = "Windows & Doors",
            description = "Opening systems and designs",
            iconName = "windows_doors",
            color = WindowsDoorsColor,
            itemCount = 7,
            examples = listOf("Arch", "Bay Window", "Sliding", "French", "Pivot")
        ),
        BuildingCategory(
            id = "stairs",
            type = CategoryType.STAIRS,
            name = "Stairs",
            description = "Staircase types and configurations",
            iconName = "stairs",
            color = StairsColor,
            itemCount = 5,
            examples = listOf("Spiral", "Straight", "L-Shape", "Floating", "U-Shape")
        )
    )

    // ==================== WALLS ITEMS ====================

    private val wallsItems = listOf(
        BuildingItem(
            id = "brick_wall",
            name = "Brick Walls",
            category = CategoryType.WALLS,
            shortDescription = "Traditional masonry construction using clay or concrete bricks",
            tags = listOf("masonry", "traditional", "load-bearing", "durable"),
            isPopular = true,
            relatedItemIds = listOf("concrete_wall", "load_bearing_wall")
        ),
        BuildingItem(
            id = "concrete_wall",
            name = "Concrete Walls",
            category = CategoryType.WALLS,
            shortDescription = "Strong structural walls made from poured or precast concrete",
            tags = listOf("structural", "modern", "durable", "fire-resistant"),
            isPopular = true,
            relatedItemIds = listOf("brick_wall", "load_bearing_wall")
        ),
        BuildingItem(
            id = "glass_curtain_wall",
            name = "Glass Curtain Walls",
            category = CategoryType.WALLS,
            shortDescription = "Non-structural exterior walls made primarily of glass",
            tags = listOf("modern", "non-structural", "transparent", "architectural"),
            isPopular = true,
            relatedItemIds = listOf("partition_wall")
        ),
        BuildingItem(
            id = "load_bearing_wall",
            name = "Load-Bearing Walls",
            category = CategoryType.WALLS,
            shortDescription = "Structural walls that support weight from above",
            tags = listOf("structural", "load-bearing", "foundation", "support"),
            isPopular = false,
            relatedItemIds = listOf("brick_wall", "concrete_wall")
        ),
        BuildingItem(
            id = "curtain_wall",
            name = "Curtain Walls",
            category = CategoryType.WALLS,
            shortDescription = "Non-load bearing exterior wall systems",
            tags = listOf("non-structural", "exterior", "cladding", "weather-protection"),
            isPopular = false,
            relatedItemIds = listOf("glass_curtain_wall")
        ),
        BuildingItem(
            id = "partition_wall",
            name = "Partition Walls",
            category = CategoryType.WALLS,
            shortDescription = "Interior non-structural walls dividing spaces",
            tags = listOf("interior", "non-structural", "drywall", "flexible"),
            isPopular = false,
            relatedItemIds = listOf("curtain_wall")
        )
    )

    // ==================== ROOFS ITEMS ====================

    private val roofsItems = listOf(
        BuildingItem(
            id = "gable_roof",
            name = "Gable Roof",
            category = CategoryType.ROOFS,
            shortDescription = "Traditional triangular roof with two sloping sides",
            tags = listOf("pitched", "traditional", "triangular", "residential"),
            isPopular = true,
            relatedItemIds = listOf("hip_roof")
        ),
        BuildingItem(
            id = "hip_roof",
            name = "Hip Roof",
            category = CategoryType.ROOFS,
            shortDescription = "Roof with slopes on all four sides meeting at a ridge",
            tags = listOf("pitched", "four-sided", "stable", "wind-resistant"),
            isPopular = true,
            relatedItemIds = listOf("gable_roof")
        ),
        BuildingItem(
            id = "flat_roof",
            name = "Flat Roof",
            category = CategoryType.ROOFS,
            shortDescription = "Nearly level roof with minimal slope for drainage",
            tags = listOf("modern", "commercial", "accessible", "minimalist"),
            isPopular = true,
            relatedItemIds = listOf("green_roof")
        ),
        BuildingItem(
            id = "dome_roof",
            name = "Dome Roof",
            category = CategoryType.ROOFS,
            shortDescription = "Hemispherical roof structure for grand spaces",
            tags = listOf("curved", "monumental", "structural", "iconic"),
            isPopular = false,
            relatedItemIds = listOf()
        ),
        BuildingItem(
            id = "green_roof",
            name = "Green Roof",
            category = CategoryType.ROOFS,
            shortDescription = "Roof covered with vegetation for environmental benefits",
            tags = listOf("sustainable", "ecological", "insulation", "modern"),
            isPopular = false,
            relatedItemIds = listOf("flat_roof")
        )
    )

    // ==================== COLUMNS ITEMS ====================

    private val columnsItems = listOf(
        BuildingItem(
            id = "doric_column",
            name = "Doric Column",
            category = CategoryType.COLUMNS,
            shortDescription = "Simple classical column with plain capital",
            tags = listOf("classical", "greek", "simple", "sturdy"),
            isPopular = true,
            relatedItemIds = listOf("ionic_column", "corinthian_column")
        ),
        BuildingItem(
            id = "ionic_column",
            name = "Ionic Column",
            category = CategoryType.COLUMNS,
            shortDescription = "Classical column with scroll-shaped volutes",
            tags = listOf("classical", "greek", "elegant", "decorative"),
            isPopular = true,
            relatedItemIds = listOf("doric_column", "corinthian_column")
        ),
        BuildingItem(
            id = "corinthian_column",
            name = "Corinthian Column",
            category = CategoryType.COLUMNS,
            shortDescription = "Ornate classical column with acanthus leaf capital",
            tags = listOf("classical", "ornate", "decorative", "elaborate"),
            isPopular = true,
            relatedItemIds = listOf("doric_column", "ionic_column")
        ),
        BuildingItem(
            id = "steel_column",
            name = "Steel Column",
            category = CategoryType.COLUMNS,
            shortDescription = "Modern structural column made of steel",
            tags = listOf("modern", "structural", "industrial", "strong"),
            isPopular = false,
            relatedItemIds = listOf("reinforced_column")
        ),
        BuildingItem(
            id = "reinforced_column",
            name = "Reinforced Concrete Column",
            category = CategoryType.COLUMNS,
            shortDescription = "Concrete column with internal steel reinforcement",
            tags = listOf("modern", "structural", "durable", "fire-resistant"),
            isPopular = false,
            relatedItemIds = listOf("steel_column")
        )
    )

    // ==================== FLOORS ITEMS ====================

    private val floorsItems = listOf(
        BuildingItem(
            id = "wood_floor",
            name = "Wood Floors",
            category = CategoryType.FLOORS,
            shortDescription = "Traditional flooring made from timber planks",
            tags = listOf("natural", "warm", "traditional", "residential"),
            isPopular = true,
            relatedItemIds = listOf("tile_floor")
        ),
        BuildingItem(
            id = "tile_floor",
            name = "Tile Floors",
            category = CategoryType.FLOORS,
            shortDescription = "Durable flooring using ceramic or porcelain tiles",
            tags = listOf("durable", "waterproof", "versatile", "easy-maintenance"),
            isPopular = true,
            relatedItemIds = listOf("concrete_floor", "wood_floor")
        ),
        BuildingItem(
            id = "concrete_floor",
            name = "Concrete Floors",
            category = CategoryType.FLOORS,
            shortDescription = "Industrial-style polished or exposed concrete",
            tags = listOf("modern", "industrial", "durable", "low-maintenance"),
            isPopular = true,
            relatedItemIds = listOf("tile_floor")
        ),
        BuildingItem(
            id = "raised_floor",
            name = "Raised Floors",
            category = CategoryType.FLOORS,
            shortDescription = "Elevated floor system for cable management",
            tags = listOf("technical", "commercial", "accessible", "flexible"),
            isPopular = false,
            relatedItemIds = listOf("mezzanine_floor")
        ),
        BuildingItem(
            id = "mezzanine_floor",
            name = "Mezzanine Floors",
            category = CategoryType.FLOORS,
            shortDescription = "Intermediate floor between main floors",
            tags = listOf("partial", "space-saving", "commercial", "flexible"),
            isPopular = false,
            relatedItemIds = listOf("raised_floor")
        )
    )

    // ==================== WINDOWS & DOORS ITEMS ====================

    private val windowsDoorsItems = listOf(
        BuildingItem(
            id = "arch_window",
            name = "Arch Windows",
            category = CategoryType.WINDOWS_DOORS,
            shortDescription = "Curved window with arched top",
            tags = listOf("classical", "curved", "elegant", "decorative"),
            isPopular = false,
            relatedItemIds = listOf("bay_window")
        ),
        BuildingItem(
            id = "bay_window",
            name = "Bay Windows",
            category = CategoryType.WINDOWS_DOORS,
            shortDescription = "Protruding window creating additional interior space",
            tags = listOf("projecting", "spacious", "traditional", "light"),
            isPopular = true,
            relatedItemIds = listOf("arch_window")
        ),
        BuildingItem(
            id = "sliding_door",
            name = "Sliding Doors",
            category = CategoryType.WINDOWS_DOORS,
            shortDescription = "Door that slides horizontally on tracks",
            tags = listOf("modern", "space-saving", "accessible", "glass"),
            isPopular = true,
            relatedItemIds = listOf("pivot_door")
        ),
        BuildingItem(
            id = "french_door",
            name = "French Doors",
            category = CategoryType.WINDOWS_DOORS,
            shortDescription = "Double doors with glass panes throughout",
            tags = listOf("elegant", "traditional", "double", "glass"),
            isPopular = true,
            relatedItemIds = listOf("sliding_door")
        ),
        BuildingItem(
            id = "pivot_door",
            name = "Pivot Doors",
            category = CategoryType.WINDOWS_DOORS,
            shortDescription = "Door rotating on central pivot mechanism",
            tags = listOf("modern", "dramatic", "architectural", "grand"),
            isPopular = false,
            relatedItemIds = listOf("sliding_door")
        ),
        BuildingItem(
            id = "casement_window",
            name = "Casement Windows",
            category = CategoryType.WINDOWS_DOORS,
            shortDescription = "Side-hinged window that opens outward",
            tags = listOf("traditional", "ventilation", "hinged", "versatile"),
            isPopular = false,
            relatedItemIds = listOf("bay_window")
        ),
        BuildingItem(
            id = "skylight",
            name = "Skylights",
            category = CategoryType.WINDOWS_DOORS,
            shortDescription = "Roof window providing natural overhead light",
            tags = listOf("roof", "natural-light", "modern", "energy-efficient"),
            isPopular = false,
            relatedItemIds = listOf()
        )
    )

    // ==================== STAIRS ITEMS ====================

    private val stairsItems = listOf(
        BuildingItem(
            id = "spiral_stairs",
            name = "Spiral Stairs",
            category = CategoryType.STAIRS,
            shortDescription = "Circular staircase rotating around central pole",
            tags = listOf("compact", "circular", "space-saving", "dramatic"),
            isPopular = true,
            relatedItemIds = listOf("floating_stairs")
        ),
        BuildingItem(
            id = "straight_stairs",
            name = "Straight Stairs",
            category = CategoryType.STAIRS,
            shortDescription = "Simple linear staircase without turns",
            tags = listOf("simple", "linear", "economical", "traditional"),
            isPopular = true,
            relatedItemIds = listOf("l_shape_stairs")
        ),
        BuildingItem(
            id = "l_shape_stairs",
            name = "L-Shape Stairs",
            category = CategoryType.STAIRS,
            shortDescription = "Staircase with 90-degree landing turn",
            tags = listOf("compact", "landing", "versatile", "common"),
            isPopular = true,
            relatedItemIds = listOf("straight_stairs", "u_shape_stairs")
        ),
        BuildingItem(
            id = "floating_stairs",
            name = "Floating Stairs",
            category = CategoryType.STAIRS,
            shortDescription = "Modern cantilevered stairs without visible support",
            tags = listOf("modern", "minimalist", "cantilevered", "dramatic"),
            isPopular = false,
            relatedItemIds = listOf("spiral_stairs")
        ),
        BuildingItem(
            id = "u_shape_stairs",
            name = "U-Shape Stairs",
            category = CategoryType.STAIRS,
            shortDescription = "Staircase with 180-degree turn at landing",
            tags = listOf("compact", "switchback", "space-efficient", "common"),
            isPopular = false,
            relatedItemIds = listOf("l_shape_stairs")
        )
    )

    // ==================== ALL ITEMS COMBINED ====================

    val allItems = wallsItems + roofsItems + columnsItems + floorsItems + windowsDoorsItems + stairsItems

    // ==================== ITEM DETAILS ====================

    val itemDetails = mapOf(
        // Brick Walls Detail
        "brick_wall" to ItemDetail(
            itemId = "brick_wall",
            fullDescription = "Brick walls are one of the oldest and most reliable construction methods, using individual clay or concrete units bonded with mortar. They provide excellent thermal mass, durability, and aesthetic appeal with various bonding patterns available.",
            specifications = listOf(
                Specification("Material", "Clay or Concrete Brick", category = SpecCategory.MATERIAL),
                Specification("Standard Size", "215 x 102.5 x 65", "mm", SpecCategory.DIMENSIONAL),
                Specification("Compressive Strength", "10-100", "N/mm²", SpecCategory.STRUCTURAL),
                Specification("Thermal Conductivity", "0.6-1.0", "W/mK", SpecCategory.PERFORMANCE),
                Specification("Fire Rating", "4 hours", category = SpecCategory.PERFORMANCE),
                Specification("Lifespan", "100+", "years", SpecCategory.MAINTENANCE)
            ),
            materials = listOf("Clay bricks", "Concrete bricks", "Mortar", "Wall ties", "DPC (Damp Proof Course)"),
            advantages = listOf(
                "Excellent durability and longevity",
                "Good thermal mass for temperature regulation",
                "Fire resistant",
                "Low maintenance requirements",
                "Aesthetic versatility with various patterns",
                "Good sound insulation"
            ),
            disadvantages = listOf(
                "Labor intensive construction",
                "Higher initial cost",
                "Requires skilled masons",
                "Heavy weight requires strong foundations",
                "Susceptible to moisture without proper treatment"
            ),
            commonUses = listOf(
                "Residential building construction",
                "Commercial facades",
                "Garden walls and boundaries",
                "Interior feature walls",
                "Load-bearing structural walls"
            ),
            historicalInfo = "Brick construction dates back over 10,000 years, with ancient civilizations using sun-dried mud bricks. Fired clay bricks were developed around 3500 BCE in Mesopotamia and have been a fundamental building material throughout history.",
            installationNotes = "Requires proper foundation, correct mortar mix, and skilled laying techniques. Must include expansion joints every 10-12 meters. Ensure proper damp proofing and cavity wall construction in wet climates.",
            maintenanceNotes = "Inspect mortar joints every 5 years. Repoint deteriorated mortar. Check for efflorescence. Clean with appropriate methods based on brick type. Ensure adequate drainage to prevent water damage."
        ),

        // Gable Roof Detail
        "gable_roof" to ItemDetail(
            itemId = "gable_roof",
            fullDescription = "A gable roof features two sloping sides that meet at a ridge, forming a triangular shape. This classic design is one of the most popular roof styles due to its simplicity, effectiveness, and excellent water drainage capabilities.",
            specifications = listOf(
                Specification("Pitch Range", "15-45", "degrees", SpecCategory.DIMENSIONAL),
                Specification("Span Capability", "Up to 12", "meters", SpecCategory.STRUCTURAL),
                Specification("Weight", "Varies by material", category = SpecCategory.STRUCTURAL),
                Specification("Lifespan", "50-100", "years", SpecCategory.MAINTENANCE)
            ),
            materials = listOf("Timber trusses", "Roofing felt", "Tiles or shingles", "Ridge tiles", "Fascia boards", "Guttering"),
            advantages = listOf(
                "Excellent water and snow shedding",
                "Simple and cost-effective design",
                "Provides attic space",
                "Easy to construct and repair",
                "Versatile - suits many architectural styles",
                "Good ventilation potential"
            ),
            disadvantages = listOf(
                "Vulnerable to wind damage in extreme conditions",
                "Requires proper bracing in high-wind areas",
                "Limited headroom at roof edges",
                "May require additional framing for dormers"
            ),
            commonUses = listOf(
                "Residential homes",
                "Suburban housing",
                "Small commercial buildings",
                "Sheds and outbuildings",
                "Traditional architecture"
            ),
            historicalInfo = "Gable roofs have been used since ancient times, appearing in Greek temples and medieval European buildings. The design has remained popular due to its practical benefits and timeless aesthetic appeal.",
            installationNotes = "Requires proper truss or rafter design calculations. Must include adequate bracing and ensure proper ventilation. Install waterproofing membranes before roofing material. Consider local wind and snow loads.",
            maintenanceNotes = "Inspect annually for damaged tiles or shingles. Check for moss growth and remove if present. Ensure gutters are clear. Inspect flashing around chimneys and vents. Check attic for leaks after storms."
        ),

        // Doric Column Detail
        "doric_column" to ItemDetail(
            itemId = "doric_column",
            fullDescription = "The Doric order is the earliest and simplest of the three classical Greek architectural orders. Characterized by its sturdy proportions and plain capital, the Doric column embodies strength and simplicity in classical architecture.",
            specifications = listOf(
                Specification("Height to Diameter Ratio", "6:1 to 8:1", category = SpecCategory.DIMENSIONAL),
                Specification("Number of Flutes", "20", category = SpecCategory.AESTHETIC),
                Specification("Capital Style", "Plain abacus and echinus", category = SpecCategory.AESTHETIC),
                Specification("Base", "None (sits directly on stylobate)", category = SpecCategory.STRUCTURAL)
            ),
            materials = listOf("Stone (traditionally marble or limestone)", "Modern concrete", "Cast stone", "Decorative plaster (for non-structural use)"),
            advantages = listOf(
                "Strong and sturdy appearance",
                "Simple and elegant design",
                "Timeless classical aesthetic",
                "Structurally efficient proportions",
                "Works well in various scales"
            ),
            disadvantages = listOf(
                "Can appear heavy or masculine",
                "Less ornate than other orders",
                "Traditional stone versions are expensive",
                "Requires skilled craftsmanship"
            ),
            commonUses = listOf(
                "Government buildings",
                "Museums and cultural institutions",
                "Commemorative structures",
                "Neoclassical architecture",
                "Monumental entrances"
            ),
            historicalInfo = "Developed in the 7th century BCE in mainland Greece and Magna Graecia. The Parthenon in Athens (447-432 BCE) is the most famous example of Doric architecture, showcasing the order's refined proportions and subtle optical refinements.",
            installationNotes = "Requires precise measurements and alignment. Traditional stone columns need careful foundation design for weight distribution. Modern reproductions should maintain classical proportions for authenticity.",
            maintenanceNotes = "Stone columns: protect from water penetration, clean periodically with appropriate methods. Check for structural cracks. Concrete versions: seal against moisture, repair any spalling promptly."
        ),

        // Add more detailed entries for other popular items as needed
        // For brevity, adding a few more key items

        "wood_floor" to ItemDetail(
            itemId = "wood_floor",
            fullDescription = "Wood flooring provides natural warmth, beauty, and durability to interior spaces. Available in solid hardwood or engineered options, wood floors can be refinished multiple times and age gracefully over decades.",
            specifications = listOf(
                Specification("Thickness", "15-22", "mm", SpecCategory.DIMENSIONAL),
                Specification("Width", "60-200", "mm", SpecCategory.DIMENSIONAL),
                Specification("Janka Hardness", "Varies by species", category = SpecCategory.PERFORMANCE),
                Specification("Moisture Content", "6-9", "%", SpecCategory.INSTALLATION)
            ),
            materials = listOf("Hardwood (oak, maple, walnut)", "Softwood (pine, fir)", "Engineered wood layers", "Finish (polyurethane, oil, wax)"),
            advantages = listOf(
                "Natural and warm aesthetic",
                "Can be refinished multiple times",
                "Increases property value",
                "Durable with proper care",
                "Good for allergies (no carpet fibers)",
                "Timeless appeal"
            ),
            disadvantages = listOf(
                "Susceptible to water damage",
                "Can scratch and dent",
                "Requires acclimation before installation",
                "Higher initial cost",
                "Regular maintenance needed"
            ),
            commonUses = listOf(
                "Residential living spaces",
                "Bedrooms",
                "Dining rooms",
                "Offices",
                "Hallways"
            ),
            installationNotes = "Must acclimate wood to room for 48-72 hours. Ensure subfloor is level and dry. Install moisture barrier if needed. Maintain expansion gaps around perimeter. Use appropriate adhesive or nailing method.",
            maintenanceNotes = "Sweep or vacuum regularly. Use appropriate wood floor cleaner. Avoid excess water. Refinish every 7-10 years as needed. Use felt pads under furniture. Control humidity levels."
        ),

        "sliding_door" to ItemDetail(
            itemId = "sliding_door",
            fullDescription = "Sliding doors operate on horizontal tracks, offering space-saving functionality and seamless indoor-outdoor transitions. Modern systems feature large glass panels that maximize natural light and views.",
            specifications = listOf(
                Specification("Panel Width", "800-1500", "mm", SpecCategory.DIMENSIONAL),
                Specification("Maximum Height", "2700", "mm", SpecCategory.DIMENSIONAL),
                Specification("Glass Thickness", "6-12", "mm", SpecCategory.MATERIAL),
                Specification("U-Value", "1.2-2.0", "W/m²K", SpecCategory.PERFORMANCE)
            ),
            materials = listOf("Aluminum frame", "uPVC frame", "Timber frame", "Tempered safety glass", "Double/triple glazing", "Stainless steel tracks"),
            advantages = listOf(
                "Space-saving - no swing clearance needed",
                "Large glass areas for light and views",
                "Easy operation",
                "Modern aesthetic",
                "Good for accessibility",
                "Seamless indoor-outdoor connection"
            ),
            disadvantages = listOf(
                "Track requires regular cleaning",
                "Less secure than hinged doors",
                "Can be drafty if not properly sealed",
                "Limited ventilation when partially open",
                "Expensive for high-quality systems"
            ),
            commonUses = listOf(
                "Patio access",
                "Garden doors",
                "Balcony access",
                "Room dividers",
                "Closet doors"
            ),
            installationNotes = "Ensure level track installation. Use proper weatherproofing and seals. Consider structural support for large spans. Install quality rolling mechanisms. Provide adequate drainage for exterior installations.",
            maintenanceNotes = "Clean tracks regularly to prevent jamming. Lubricate rollers annually. Check weatherstripping and replace if damaged. Clean glass with appropriate products. Inspect and adjust roller height as needed."
        ),

        "spiral_stairs" to ItemDetail(
            itemId = "spiral_stairs",
            fullDescription = "Spiral stairs wind around a central pole, providing vertical circulation in a compact footprint. These dramatic staircases are both functional space-savers and striking architectural features.",
            specifications = listOf(
                Specification("Typical Diameter", "1200-1800", "mm", SpecCategory.DIMENSIONAL),
                Specification("Tread Depth", "200-250", "mm", SpecCategory.DIMENSIONAL),
                Specification("Rise per Step", "180-220", "mm", SpecCategory.DIMENSIONAL),
                Specification("Central Pole Diameter", "100-200", "mm", SpecCategory.STRUCTURAL)
            ),
            materials = listOf("Steel (most common)", "Wood treads", "Cast iron", "Stainless steel", "Aluminum", "Glass treads"),
            advantages = listOf(
                "Minimal floor space required",
                "Dramatic visual impact",
                "Cost-effective for tight spaces",
                "Can be prefabricated",
                "Suits various interior styles",
                "Easy to install"
            ),
            disadvantages = listOf(
                "Difficult to move furniture",
                "Can be challenging for some users",
                "Limited capacity (single file)",
                "May not meet building codes for primary stairs",
                "Less comfortable than straight stairs"
            ),
            commonUses = listOf(
                "Secondary access stairs",
                "Loft access",
                "Space-constrained interiors",
                "Feature staircases",
                "Lighthouse stairs",
                "Compact homes"
            ),
            installationNotes = "Ensure solid floor fixing for central pole. Check local building codes for minimum width and handrail requirements. Consider direction of rotation for user flow. Adequate headroom clearance essential.",
            maintenanceNotes = "Check central pole stability annually. Tighten all connections. Inspect treads for wear. Maintain anti-slip surface on treads. Clean regularly. Check handrail security."
        )
    )

    // ==================== HELPER FUNCTIONS ====================

    /**
     * Get all items for a specific category
     */
    fun getItemsByCategory(categoryType: CategoryType): List<BuildingItem> {
        return allItems.filter { it.category == categoryType }
    }

    /**
     * Get item by ID
     */
    fun getItemById(itemId: String): BuildingItem? {
        return allItems.find { it.id == itemId }
    }

    /**
     * Get category by ID
     */
    fun getCategoryById(categoryId: String): BuildingCategory? {
        return categories.find { it.id == categoryId }
    }

    /**
     * Get category by type
     */
    fun getCategoryByType(type: CategoryType): BuildingCategory? {
        return categories.find { it.type == type }
    }

    /**
     * Search items by query
     */
    fun searchItems(query: String): List<BuildingItem> {
        return allItems.filter { it.matchesSearch(query) }
    }

    /**
     * Get popular items
     */
    fun getPopularItems(): List<BuildingItem> {
        return allItems.filter { it.isPopular }
    }

    /**
     * Get related items for an item
     */
    fun getRelatedItems(itemId: String): List<BuildingItem> {
        val item = getItemById(itemId) ?: return emptyList()
        return item.relatedItemIds.mapNotNull { getItemById(it) }
    }
}