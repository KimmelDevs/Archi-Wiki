package com.example.archiewiki.ui.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

/**
 * Main navigation graph for the Buildings Wiki app
 *
 * @param navController The navigation controller to handle navigation
 * @param startDestination The initial screen to display (defaults to Home)
 */
@Composable
fun NavGraph(
    navController: NavHostController,
    startDestination: String = Screen.Home.route,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
        enterTransition = { fadeIn(animationSpec = tween(100)) },
        exitTransition = { fadeOut(animationSpec = tween(100)) }
    ) {

        // Home Screen - Main dashboard with category cards
        composable(route = Screen.Home.route) {
            // HomeScreen(
            //     onCategoryClick = { categoryId ->
            //         navController.navigate(Screen.CategoryDetail.createRoute(categoryId))
            //     }
            // )

            // Placeholder for now
            androidx.compose.material3.Text("Home Screen - Coming Soon")
        }

        // Search Screen - Search functionality
        composable(route = Screen.Search.route) {
            // SearchScreen(
            //     onItemClick = { itemId ->
            //         navController.navigate(Screen.ItemDetail.createRoute(itemId))
            //     }
            // )

            // Placeholder for now
            androidx.compose.material3.Text("Search Screen - Coming Soon")
        }

        // Browse Screen - Alphabetical listing
        composable(route = Screen.Browse.route) {
            // BrowseScreen(
            //     onItemClick = { itemId ->
            //         navController.navigate(Screen.ItemDetail.createRoute(itemId))
            //     }
            // )

            // Placeholder for now
            androidx.compose.material3.Text("Browse Screen - Coming Soon")
        }

        // More Screen - Settings, favorites, about
        composable(route = Screen.More.route) {
            // MoreScreen(
            //     onFavoritesClick = {
            //         navController.navigate(Screen.Favorites.route)
            //     },
            //     onSettingsClick = {
            //         navController.navigate(Screen.Settings.route)
            //     },
            //     onAboutClick = {
            //         navController.navigate(Screen.About.route)
            //     }
            // )

            // Placeholder for now
            androidx.compose.material3.Text("More Screen - Coming Soon")
        }

        // Category Detail Screen - Shows all items in a category
        composable(
            route = Screen.CategoryDetail.route,
            arguments = listOf(
                navArgument("categoryId") {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            val categoryId = backStackEntry.arguments?.getString("categoryId")

            // CategoryDetailScreen(
            //     categoryId = categoryId ?: "",
            //     onItemClick = { itemId ->
            //         navController.navigate(Screen.ItemDetail.createRoute(itemId))
            //     },
            //     onBackClick = {
            //         navController.navigateUp()
            //     }
            // )

            // Placeholder for now
            androidx.compose.material3.Text("Category Detail: $categoryId - Coming Soon")
        }

        // Item Detail Screen - Shows detailed information about a specific item
        composable(
            route = Screen.ItemDetail.route,
            arguments = listOf(
                navArgument("itemId") {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            val itemId = backStackEntry.arguments?.getString("itemId")

            // ItemDetailScreen(
            //     itemId = itemId ?: "",
            //     onBackClick = {
            //         navController.navigateUp()
            //     },
            //     onRelatedItemClick = { relatedItemId ->
            //         navController.navigate(Screen.ItemDetail.createRoute(relatedItemId))
            //     }
            // )

            // Placeholder for now
            androidx.compose.material3.Text("Item Detail: $itemId - Coming Soon")
        }

        // Favorites Screen
        composable(route = Screen.Favorites.route) {
            // FavoritesScreen(
            //     onItemClick = { itemId ->
            //         navController.navigate(Screen.ItemDetail.createRoute(itemId))
            //     },
            //     onBackClick = {
            //         navController.navigateUp()
            //     }
            // )

            // Placeholder for now
            androidx.compose.material3.Text("Favorites Screen - Coming Soon")
        }

        // Settings Screen
        composable(route = Screen.Settings.route) {
            // SettingsScreen(
            //     onBackClick = {
            //         navController.navigateUp()
            //     }
            // )

            // Placeholder for now
            androidx.compose.material3.Text("Settings Screen - Coming Soon")
        }

        // About Screen
        composable(route = Screen.About.route) {
            // AboutScreen(
            //     onBackClick = {
            //         navController.navigateUp()
            //     }
            // )

            // Placeholder for now
            androidx.compose.material3.Text("About Screen - Coming Soon")
        }
    }
}