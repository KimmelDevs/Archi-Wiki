package com.example.archiewiki.ui.screens.category

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.archiewiki.ui.components.common.AppTopBarWithBack
import com.example.archiewiki.ui.components.common.EmptyState
import com.example.archiewiki.ui.components.common.LoadingIndicator
import com.example.archiewiki.ui.screens.category.components.CategoryHeader
import com.example.archiewiki.ui.screens.category.components.ItemListCard
import com.example.archiewiki.util.AppIcons
import com.example.archiewiki.viewmodel.CategoryViewModel
import com.example.archiewiki.viewmodel.CategoryUiState

/**
 * Category Detail Screen
 * Displays all items within a specific building category
 */
@Composable
fun CategoryDetailScreen(
    categoryId: String,
    onItemClick: (String) -> Unit,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: CategoryViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    val category by viewModel.category.collectAsState()
    val filteredItems by viewModel.filteredItems.collectAsState()
    val showPopularOnly by viewModel.showPopularOnly.collectAsState()

    // Load category when screen opens
    LaunchedEffect(categoryId) {
        viewModel.loadCategory(categoryId)
    }

    Scaffold(
        topBar = {
            AppTopBarWithBack(
                title = category?.name ?: "Category",
                onBackClick = onBackClick,
                actions = {
                    // Filter button
                    IconButton(
                        onClick = { viewModel.togglePopularFilter() }
                    ) {
                        Icon(
                            imageVector = Icons.Default.FilterList,
                            contentDescription = "Filter",
                            tint = if (showPopularOnly) {
                                MaterialTheme.colorScheme.primary
                            } else {
                                MaterialTheme.colorScheme.onSurface
                            }
                        )
                    }
                }
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
                is CategoryUiState.Loading -> {
                    LoadingIndicator()
                }

                is CategoryUiState.Success -> {
                    if (category != null) {
                        CategoryDetailContent(
                            category = category!!,
                            items = filteredItems,
                            showPopularOnly = showPopularOnly,
                            onItemClick = onItemClick
                        )
                    }
                }

                is CategoryUiState.Empty -> {
                    category?.let {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp)
                        ) {
                            CategoryHeader(category = it)
                            Spacer(modifier = Modifier.height(16.dp))
                            EmptyState(
                                icon = AppIcons.FolderOpen,
                                title = "No Items",
                                description = "This category doesn't have any items yet."
                            )
                        }
                    }
                }

                is CategoryUiState.Error -> {
                    val errorMessage = (uiState as CategoryUiState.Error).message
                    EmptyState(
                        icon = AppIcons.Error,
                        title = "Error Loading Category",
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

@Composable
private fun CategoryDetailContent(
    category: com.example.archiewiki.data.model.BuildingCategory,
    items: List<com.example.archiewiki.data.model.BuildingItem>,
    showPopularOnly: Boolean,
    onItemClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        // Category Header
        CategoryHeader(category = category)

        // Filter indicator
        if (showPopularOnly) {
            Surface(
                color = MaterialTheme.colorScheme.primaryContainer,
                shape = MaterialTheme.shapes.small
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.FilterList,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Showing popular items only",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
            }
        }

        // Section header
        Text(
            text = if (showPopularOnly) "Popular Items" else "All Items",
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier.padding(top = 8.dp, bottom = 4.dp)
        )

        // Items list
        items.forEach { item ->
            ItemListCard(
                item = item,
                onClick = { onItemClick(item.id) }
            )
        }

        // Empty state when filtered
        if (items.isEmpty() && showPopularOnly) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp)
                ) {
                    Text(
                        text = "No popular items",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Remove the filter to see all items",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
    }
}