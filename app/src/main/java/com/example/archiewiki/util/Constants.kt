package com.example.archiewiki.util


/**
 * Constants used throughout the Buildings Wiki app
 */
object Constants {

    // ==================== APP INFO ====================

    const val APP_NAME = "Buildings Wiki"
    const val APP_VERSION = "1.0.0"
    const val APP_DESCRIPTION = "Your comprehensive guide to building components and architecture"

    // ==================== NAVIGATION ====================

    const val ANIMATION_DURATION = 300
    const val BOTTOM_NAV_HEIGHT = 80

    // ==================== UI DIMENSIONS ====================

    object Dimensions {
        const val PADDING_EXTRA_SMALL = 4
        const val PADDING_SMALL = 8
        const val PADDING_MEDIUM = 16
        const val PADDING_LARGE = 24
        const val PADDING_EXTRA_LARGE = 32

        const val CARD_ELEVATION = 2
        const val CARD_CORNER_RADIUS = 12
        const val ICON_CARD_CORNER_RADIUS = 16

        const val ICON_SIZE_SMALL = 20
        const val ICON_SIZE_MEDIUM = 24
        const val ICON_SIZE_LARGE = 32
        const val ICON_SIZE_EXTRA_LARGE = 48
        const val CATEGORY_ICON_SIZE = 64

        const val CATEGORY_CARD_HEIGHT = 160
        const val INFO_CARD_IMAGE_SIZE = 80
        const val COMPACT_CARD_SIZE = 100
    }

    // ==================== SEARCH ====================

    object Search {
        const val DEBOUNCE_DELAY = 300L
        const val MIN_SEARCH_LENGTH = 2
        const val MAX_RECENT_SEARCHES = 10
        const val SEARCH_HINT = "Search building elements..."
    }

    // ==================== GRID LAYOUT ====================

    object Grid {
        const val HOME_COLUMNS = 2
        const val BROWSE_COLUMNS = 1
        const val RELATED_ITEMS_COLUMNS = 2
        const val HORIZONTAL_SPACING = 12
        const val VERTICAL_SPACING = 12
    }

    // ==================== REPOSITORY ====================

    object Repository {
        const val SIMULATED_NETWORK_DELAY = 300L
        const val CACHE_DURATION = 5 * 60 * 1000L // 5 minutes
    }

    // ==================== PREFERENCES KEYS ====================

    object PreferenceKeys {
        const val FAVORITES = "favorites"
        const val RECENT_SEARCHES = "recent_searches"
        const val THEME_MODE = "theme_mode"
        const val FIRST_LAUNCH = "first_launch"
    }

    // ==================== ERROR MESSAGES ====================

    object ErrorMessages {
        const val GENERIC_ERROR = "Something went wrong. Please try again."
        const val NETWORK_ERROR = "Network connection failed. Check your internet."
        const val NOT_FOUND = "Item not found."
        const val LOAD_FAILED = "Failed to load data."
        const val SEARCH_FAILED = "Search failed. Please try again."
    }

    // ==================== SUCCESS MESSAGES ====================

    object SuccessMessages {
        const val ADDED_TO_FAVORITES = "Added to favorites"
        const val REMOVED_FROM_FAVORITES = "Removed from favorites"
        const val SEARCH_CLEARED = "Search cleared"
    }

    // ==================== CATEGORY IDS ====================

    object CategoryIds {
        const val WALLS = "walls"
        const val ROOFS = "roofs"
        const val COLUMNS = "columns"
        const val FLOORS = "floors"
        const val WINDOWS_DOORS = "windows_doors"
        const val STAIRS = "stairs"
    }

    // ==================== URLS & LINKS ====================

    object Links {
        const val GITHUB_REPO = "https://github.com/yourusername/buildingswiki"
        const val PRIVACY_POLICY = "https://yourwebsite.com/privacy"
        const val TERMS_OF_SERVICE = "https://yourwebsite.com/terms"
        const val SUPPORT_EMAIL = "support@buildingswiki.com"
        const val WEBSITE = "https://buildingswiki.com"
    }

    // ==================== IMAGE GALLERY ====================

    object Gallery {
        const val MAX_IMAGES = 10
        const val THUMBNAIL_SIZE = 100
        const val FULL_IMAGE_QUALITY = 90
    }

    // ==================== SHARE ====================

    object Share {
        const val SHARE_SUBJECT = "Check out this building element"
        const val SHARE_TEXT_PREFIX = "I found this on Buildings Wiki: "
    }

    // ==================== TAGS ====================

    const val LOG_TAG = "BuildingsWiki"

    // ==================== ANIMATION ====================

    object Animation {
        const val FADE_DURATION = 200
        const val SLIDE_DURATION = 300
        const val SCALE_DURATION = 150
    }
}