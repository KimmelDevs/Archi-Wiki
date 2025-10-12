package com.example.archiewiki.ui.components.common

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * Standard back button icon button
 * Used in top bars and navigation
 */
@Composable
fun BackButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    contentDescription: String = "Navigate back"
) {
    IconButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = contentDescription,
            tint = MaterialTheme.colorScheme.onSurface
        )
    }
}

/**
 * Outlined back button
 * More prominent, good for floating or standalone placement
 */
@Composable
fun OutlinedBackButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    text: String = "Back"
) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = null,
            modifier = Modifier
                .size(18.dp)
                .padding(end = 4.dp)
        )
        Text(text = text)
    }
}

/**
 * Filled back button
 * Most prominent, use sparingly
 */
@Composable
fun FilledBackButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    text: String = "Back"
) {
    Button(
        onClick = onClick,
        modifier = modifier
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = null,
            modifier = Modifier
                .size(18.dp)
                .padding(end = 4.dp)
        )
        Text(text = text)
    }
}

/**
 * Text back button
 * Minimal style, good for less important back actions
 */
@Composable
fun TextBackButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    text: String = "Back"
) {
    TextButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = null,
            modifier = Modifier
                .size(18.dp)
                .padding(end = 4.dp)
        )
        Text(text = text)
    }
}