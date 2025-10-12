package com.example.archiewiki.ui.components.common

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.FolderOpen
import androidx.compose.material.icons.filled.ErrorOutline
import androidx.compose.material.icons.filled.SearchOff
import androidx.compose.material3.*

import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

/**
 * Generic empty state component
 * Shows icon, title, description, and optional action button
 */
@Composable
fun EmptyState(
    icon: ImageVector,
    title: String,
    description: String,
    modifier: Modifier = Modifier,
    actionButton: (@Composable () -> Unit)? = null
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Icon
            Icon(
                imageVector = icon,
                contentDescription = null,
                modifier = Modifier.size(80.dp),
                tint = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.5f)
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Title
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Description
            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center
            )

            // Optional action button
            if (actionButton != null) {
                Spacer(modifier = Modifier.height(24.dp))
                actionButton()
            }
        }
    }
}

/**
 * Empty search results state
 */
@Composable
fun EmptySearchState(
    searchQuery: String,
    onClearSearch: () -> Unit,
    modifier: Modifier = Modifier
) {
    EmptyState(
        icon = Icons.Filled.SearchOff,
        title = "No results found",
        description = "We couldn't find any items matching \"$searchQuery\". Try a different search term.",
        modifier = modifier,
        actionButton = {
            OutlinedButton(onClick = onClearSearch) {
                Text("Clear Search")
            }
        }
    )
}

/**
 * Empty category state
 * When a category has no items
 */
@Composable
fun EmptyCategoryState(
    categoryName: String,
    modifier: Modifier = Modifier
) {
    EmptyState(
        icon = Icons.Filled.FolderOpen,
        title = "No items yet",
        description = "The $categoryName category doesn't have any items at the moment.",
        modifier = modifier
    )
}

/**
 * Empty favorites state
 */
@Composable
fun EmptyFavoritesState(
    onBrowseClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    EmptyState(
        icon = Icons.Filled.FavoriteBorder,
        title = "No favorites yet",
        description = "Start exploring and add your favorite building elements to see them here.",
        modifier = modifier,
        actionButton = {
            Button(onClick = onBrowseClick) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null,
                    modifier = Modifier.size(18.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text("Browse Items")
            }
        }
    )
}

/**
 * Generic error state
 */
@Composable
fun ErrorState(
    title: String = "Something went wrong",
    description: String = "We encountered an error. Please try again.",
    onRetry: (() -> Unit)? = null,
    modifier: Modifier = Modifier
) {
    EmptyState(
        icon = Icons.Filled.ErrorOutline,
        title = title,
        description = description,
        modifier = modifier,
        actionButton = if (onRetry != null) {
            {
                Button(onClick = onRetry) {
                    Text("Retry")
                }
            }
        } else null
    )
}

// Missing imports