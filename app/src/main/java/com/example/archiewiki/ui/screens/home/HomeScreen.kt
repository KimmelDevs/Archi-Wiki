package com.example.archiewiki.ui.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.archiewiki.ui.components.common.AppTopBar
import com.example.archiewiki.ui.components.common.EmptyState
import com.example.archiewiki.ui.components.common.LoadingIndicator
import com.example.archiewiki.ui.screens.home.components.CategoryCard
import com.example.archiewiki.util.AppIcons
import com.example.archiewiki.viewmodel.HomeViewModel
import com.example.archiewiki.viewmodel.HomeUiState

/**
 * Home Screen - Main dashboard with category cards
 * Displays all building categories in a grid layout
 */
@Composable
fun HomeScreen(
    onCategoryClick: (String) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    val categories by viewModel.categories.collectAsState()

    Scaffold(
        topBar = {
            AppTopBar(
                title = "Buildings Wiki"
            )
        },
        modifier = modifier
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            when (uiState) {
                is HomeUiState.Loading -> {
                    LoadingIndicator()
                }

                is HomeUiState.Success -> {
                    HomeContent(
                        categories = categories,
                        onCategoryClick = onCategoryClick
                    )
                }

                is HomeUiState.Empty -> {
                    EmptyState(
                        icon = AppIcons.Category,
                        title = "No Categories",
                        description = "No building categories available at the moment."
                    )
                }

                is HomeUiState.Error -> {
                    val errorMessage = (uiState as HomeUiState.Error).message
                    EmptyState(
                        icon = AppIcons.Error,
                        title = "Error Loading Categories",
                        description = errorMessage,
                        actionButton = {
                            Button(onClick = { viewModel.refresh() }) {
                                Text("Retry")
                            }
                        }
                    )
                }
            }
        }
    }
}

/**
 * Home content displaying welcome header and category grid
 */
@Composable
private fun HomeContent(
    categories: List<com.example.archiewiki.data.model.BuildingCategory>,
    onCategoryClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        // Welcome Header Component
        Column(
            modifier = modifier.fillMaxWidth()
        ) {
            Text(
                text = "Explore Building Elements",
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.onBackground
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Discover materials, styles, and architectural components",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        // Categories Grid
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(categories, key = { it.id }) { category ->
                CategoryCard(category = category, onClick = { onCategoryClick(category.id) })
            }

        }
    }
}