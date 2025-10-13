package com.example.archiewiki

import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.archiewiki.ui.navigation.NavGraph
import com.example.archiewiki.ui.navigation.bottomNavItems
import com.example.archiewiki.ui.theme.BuildingsWikiTheme

/**
 * Main Activity - Entry point of the Archie Wiki app
 * Sets up navigation and bottom navigation bar
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BuildingsWikiTheme {
                ArchieWikiApp()
            }
        }
    }
}

@Composable
fun ArchieWikiApp() {
    val navController = rememberNavController()


    val view = LocalView.current
    val statusBarColor = MaterialTheme.colorScheme.background

    SideEffect {
        val window = (view.context as ComponentActivity).window

        window.statusBarColor = statusBarColor.toArgb()
        window.setBackgroundDrawable(ColorDrawable(statusBarColor.toArgb()))

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val lightStatusIcons = statusBarColor.luminance() > 0.5f
            window.decorView.systemUiVisibility =
                if (lightStatusIcons) {
                    window.decorView.systemUiVisibility or
                            android.view.View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
                } else {
                    window.decorView.systemUiVisibility and
                            android.view.View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR.inv()
                }
        }
    }

    Scaffold(
        bottomBar = {
            NavigationBar {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination

                bottomNavItems.forEach { item ->
                    NavigationBarItem(
                        icon = {
                            Icon(
                                imageVector = if (currentDestination?.hierarchy?.any {
                                        it.route == item.screen.route
                                    } == true) {
                                    item.selectedIcon
                                } else {
                                    item.unselectedIcon
                                },
                                contentDescription = item.title
                            )
                        },
                        label = { Text(item.title) },
                        selected = currentDestination?.hierarchy?.any {
                            it.route == item.screen.route
                        } == true,
                        onClick = {
                            navController.navigate(item.screen.route) {
                                // Pop up to the start destination of the graph to
                                // avoid building up a large stack of destinations
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                // Avoid multiple copies of the same destination
                                launchSingleTop = true
                                // Restore state when reselecting a previously selected item
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavGraph(
            navController = navController,
            modifier = Modifier.padding(innerPadding),
        )
    }
}