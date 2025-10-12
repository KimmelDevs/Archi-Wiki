package com.example.archiewiki.ui.navigation

/**
 * Sealed class representing all possible navigation destinations in the app
 */
sealed class Screen(val route: String) {

    // Bottom Navigation Screens
    data object Home : Screen("home")
    data object Search : Screen("search")
    data object Browse : Screen("browse")
    data object More : Screen("more")

    // Detail Screens (with arguments)
    data object CategoryDetail : Screen("category/{categoryId}") {
        fun createRoute(categoryId: String) = "category/$categoryId"
    }

    data object ItemDetail : Screen("item/{itemId}") {
        fun createRoute(itemId: String) = "item/$itemId"
    }

    // More Screen sub-sections
    data object Favorites : Screen("favorites")
    data object Settings : Screen("settings")
    data object About : Screen("about")

    companion object {
        // Helper function to get all bottom nav screens
        fun getBottomNavScreens() = listOf(Home, Search, Browse, More)
    }
}