package com.example.archiewiki.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LightbulbCircle
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.LightbulbCircle
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material.icons.outlined.Search
import androidx.compose.ui.graphics.vector.ImageVector

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
        title = "Eras",
        selectedIcon = Icons.Filled.LightbulbCircle,
        unselectedIcon = Icons.Outlined.LightbulbCircle,
        screen = Screen.Eras
    ),
    BottomNavItem(
        title = "Browse",
        selectedIcon = Icons.Filled.Menu,
        unselectedIcon = Icons.Outlined.Menu,
        screen = Screen.Browse
    ),
    BottomNavItem(
        title = "More",
        selectedIcon = Icons.Filled.MoreVert,
        unselectedIcon = Icons.Outlined.MoreVert,
        screen = Screen.More
    )
)

// Note: You'll need to import these for Menu icons:
// import androidx.compose.material.icons.filled.Menu
// import androidx.compose.material.icons.outlined.Menu
// Or use alternative icons like:
// - ViewList / ViewListOutlined
// - GridView / GridViewOutlined
// - Apps / AppsOutlined