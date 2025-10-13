package com.example.archiewiki.ui.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    // Main container
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("ArchieWiki") }
            )
        }
    ) { paddingValues ->
        // Main content
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Welcome to ArchieWiki!",
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}
