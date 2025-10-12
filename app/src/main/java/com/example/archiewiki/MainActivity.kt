package com.example.archiewiki

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.List
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.archiewiki.ui.navigation.Screen

/**
 * Data class representing a bottom navigation item
 * @param title The label shown in the bottom navigation
 * @param selectedIcon Icon displayed when this item is selected
 * @param unselectedIcon Icon displayed when this item is not selected
 * @param screen The navigation screen associated with this item
 */
data class BottomNavItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val screen: Screen
)

/**
 * List of all bottom navigation items
 */
val bottomNavItems = listOf(
    BottomNavItem(
        title = "Home",
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home,
        screen = Screen.Home
    ),
    BottomNavItem(
        title = "Search",
        selectedIcon = Icons.Filled.Search,
        unselectedIcon = Icons.Outlined.Search,
        screen = Screen.Search
    ),
    BottomNavItem(
        title = "Browse",
        selectedIcon = Icons.Filled.List,
        unselectedIcon = Icons.Outlined.List,
        screen = Screen.Browse
    ),
    BottomNavItem(
        title = "More",
        selectedIcon = Icons.Filled.MoreVert,
        unselectedIcon = Icons.Outlined.MoreVert,
        screen = Screen.More
    )
)

// Note: Icons are now using List icons for Browse
// All icons are from the standard Material Icons library