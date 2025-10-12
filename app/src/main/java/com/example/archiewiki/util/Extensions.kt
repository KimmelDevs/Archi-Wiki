package com.example.archiewiki.util


import android.content.Context
import android.content.Intent
import androidx.compose.ui.graphics.Color

/**
 * Useful extension functions for the Buildings Wiki app
 */

// ==================== STRING EXTENSIONS ====================

/**
 * Capitalize first letter of each word
 */
fun String.capitalizeWords(): String {
    return this.split(" ").joinToString(" ") { word ->
        word.replaceFirstChar { it.uppercase() }
    }
}

/**
 * Truncate string to specified length with ellipsis
 */
fun String.truncate(maxLength: Int): String {
    return if (this.length > maxLength) {
        "${this.substring(0, maxLength)}..."
    } else {
        this
    }
}

/**
 * Remove extra whitespaces
 */
fun String.cleanWhitespace(): String {
    return this.trim().replace("\\s+".toRegex(), " ")
}

/**
 * Check if string is a valid search query
 */
fun String.isValidSearchQuery(): Boolean {
    return this.trim().length >= Constants.Search.MIN_SEARCH_LENGTH
}

/**
 * Convert string to search-friendly format
 */
fun String.toSearchFormat(): String {
    return this.lowercase().trim()
}

// ==================== LIST EXTENSIONS ====================

/**
 * Get a random item from list or null if empty
 */
fun <T> List<T>.randomOrNull(): T? {
    return if (this.isEmpty()) null else this.random()
}

/**
 * Split list into chunks of specified size
 */
fun <T> List<T>.chunked(size: Int): List<List<T>> {
    return this.windowed(size, size, partialWindows = true)
}

/**
 * Get items excluding a specific item by ID
 */
fun <T> List<T>.excludingItem(predicate: (T) -> Boolean): List<T> {
    return this.filterNot(predicate)
}

// ==================== COLOR EXTENSIONS ====================

/**
 * Lighten a color by a percentage (0.0 to 1.0)
 */
fun Color.lighten(fraction: Float): Color {
    val hsv = FloatArray(3)
    android.graphics.Color.colorToHSV(this.hashCode(), hsv)
    hsv[2] = (hsv[2] + fraction).coerceIn(0f, 1f)
    return Color(android.graphics.Color.HSVToColor(hsv))
}

/**
 * Darken a color by a percentage (0.0 to 1.0)
 */
fun Color.darken(fraction: Float): Color {
    val hsv = FloatArray(3)
    android.graphics.Color.colorToHSV(this.hashCode(), hsv)
    hsv[2] = (hsv[2] - fraction).coerceIn(0f, 1f)
    return Color(android.graphics.Color.HSVToColor(hsv))
}

/**
 * Get contrasting text color (black or white) for background
 */
fun Color.contrastingTextColor(): Color {
    val luminance = (0.299 * this.red + 0.587 * this.green + 0.114 * this.blue)
    return if (luminance > 0.5) Color.Black else Color.White
}

// ==================== CONTEXT EXTENSIONS ====================

/**
 * Share text content
 */
fun Context.shareText(text: String, subject: String = Constants.Share.SHARE_SUBJECT) {
    val intent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_SUBJECT, subject)
        putExtra(Intent.EXTRA_TEXT, text)
    }
    startActivity(Intent.createChooser(intent, "Share via"))
}

/**
 * Open email client
 */
fun Context.sendEmail(
    email: String,
    subject: String = "",
    body: String = ""
) {
    val intent = Intent(Intent.ACTION_SEND).apply {
        type = "message/rfc822"
        putExtra(Intent.EXTRA_EMAIL, arrayOf(email))
        putExtra(Intent.EXTRA_SUBJECT, subject)
        putExtra(Intent.EXTRA_TEXT, body)
    }
    try {
        startActivity(Intent.createChooser(intent, "Send email"))
    } catch (e: Exception) {
        // Handle no email app installed
    }
}

// ==================== NUMBER EXTENSIONS ====================

/**
 * Format number with suffix (K, M, B)
 */
fun Int.formatWithSuffix(): String {
    return when {
        this >= 1_000_000_000 -> String.format("%.1fB", this / 1_000_000_000.0)
        this >= 1_000_000 -> String.format("%.1fM", this / 1_000_000.0)
        this >= 1_000 -> String.format("%.1fK", this / 1_000.0)
        else -> this.toString()
    }
}

/**
 * Convert to ordinal string (1st, 2nd, 3rd, etc.)
 */
fun Int.toOrdinal(): String {
    return when {
        this % 100 in 11..13 -> "${this}th"
        this % 10 == 1 -> "${this}st"
        this % 10 == 2 -> "${this}nd"
        this % 10 == 3 -> "${this}rd"
        else -> "${this}th"
    }
}

// ==================== BOOLEAN EXTENSIONS ====================

/**
 * Execute action if true
 */
inline fun Boolean.ifTrue(action: () -> Unit): Boolean {
    if (this) action()
    return this
}

/**
 * Execute action if false
 */
inline fun Boolean.ifFalse(action: () -> Unit): Boolean {
    if (!this) action()
    return this
}

// ==================== COLLECTION EXTENSIONS ====================

/**
 * Safe get with default value
 */
fun <K, V> Map<K, V>.getOrDefault(key: K, defaultValue: V): V {
    return this[key] ?: defaultValue
}

/**
 * Check if collection is not null and not empty
 */
fun <T> Collection<T>?.isNotNullOrEmpty(): Boolean {
    return this != null && this.isNotEmpty()
}

/**
 * Check if collection is null or empty
 */
fun <T> Collection<T>?.isNullOrEmpty(): Boolean {
    return this == null || this.isEmpty()
}

// ==================== PAIR & TRIPLE EXTENSIONS ====================

/**
 * Swap pair values
 */
fun <A, B> Pair<A, B>.swap(): Pair<B, A> = Pair(second, first)

/**
 * Convert triple to list
 */
fun <T> Triple<T, T, T>.toList(): List<T> = listOf(first, second, third)