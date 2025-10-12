package com.example.archiewiki.util

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Icon mappings and utilities for the Buildings Wiki app
 * Maps category names and types to appropriate Material Icons
 */
object AppIcons {

    // ==================== CATEGORY ICONS ====================

    /**
     * Get icon for category by name
     */
    fun getCategoryIcon(categoryName: String): ImageVector {
        return when (categoryName.lowercase()) {
            "walls" -> Icons.Filled.ViewInAr
            "roofs" -> Icons.Filled.Home
            "columns" -> Icons.Filled.ViewColumn
            "floors" -> Icons.Filled.Layers
            "windows_doors", "windows & doors" -> Icons.Filled.MeetingRoom
            "stairs" -> Icons.Filled.Stairs
            else -> Icons.Filled.Category
        }
    }

    // Explicit category icons
    val Walls = Icons.Filled.ViewInAr
    val Roofs = Icons.Filled.Home
    val Columns = Icons.Filled.ViewColumn
    val Floors = Icons.Filled.Layers
    val WindowsDoors = Icons.Filled.MeetingRoom
    val Stairs = Icons.Filled.Stairs

    // ==================== NAVIGATION ICONS ====================

    val Home = Icons.Filled.Home
    val HomeOutlined = Icons.Outlined.Home

    val Search = Icons.Filled.Search

    val Browse = Icons.Filled.List
    val BrowseOutlined = Icons.Outlined.List

    val More = Icons.Filled.MoreVert
    val MoreOutlined = Icons.Outlined.MoreVert

    // ==================== ACTION ICONS ====================

    val Back = Icons.Filled.ArrowBack
    val Forward = Icons.Filled.ArrowForward
    val Close = Icons.Filled.Close
    val Done = Icons.Filled.Done
    val Add = Icons.Filled.Add
    val Remove = Icons.Filled.Remove
    val Edit = Icons.Filled.Edit
    val Delete = Icons.Filled.Delete
    val Share = Icons.Filled.Share
    val Refresh = Icons.Filled.Refresh

    // ==================== FAVORITE ICONS ====================

    val Favorite = Icons.Filled.Favorite
    val FavoriteOutlined = Icons.Outlined.FavoriteBorder
    val FavoriteBorder = Icons.Filled.FavoriteBorder

    // ==================== INFO ICONS ====================

    val Info = Icons.Filled.Info
    val InfoOutlined = Icons.Outlined.Info
    val Help = Icons.Filled.Help
    val Warning = Icons.Filled.Warning
    val Error = Icons.Filled.Error
    val Check = Icons.Filled.Check
    val CheckCircle = Icons.Filled.CheckCircle

    // ==================== SETTINGS ICONS ====================

    val Settings = Icons.Filled.Settings
    val SettingsOutlined = Icons.Outlined.Settings
    val DarkMode = Icons.Filled.DarkMode
    val LightMode = Icons.Filled.LightMode
    val Notifications = Icons.Filled.Notifications
    val NotificationsOff = Icons.Filled.NotificationsOff

    // ==================== CONTENT ICONS ====================

    val Image = Icons.Filled.Image
    val PhotoLibrary = Icons.Filled.PhotoLibrary
    val Description = Icons.Filled.Description
    val Article = Icons.Filled.Article
    val Category = Icons.Filled.Category
    val Label = Icons.Filled.Label
    val Tag = Icons.Filled.LocalOffer

    // ==================== NAVIGATION DETAIL ICONS ====================

    val ExpandMore = Icons.Filled.ExpandMore
    val ExpandLess = Icons.Filled.ExpandLess
    val ChevronRight = Icons.Filled.ChevronRight
    val ChevronLeft = Icons.Filled.ChevronLeft
    val Menu = Icons.Filled.Menu

    // ==================== FILTER & SORT ICONS ====================

    val Filter = Icons.Filled.FilterList
    val Sort = Icons.Filled.Sort
    val ViewGrid = Icons.Filled.GridView
    val ViewList = Icons.Filled.ViewList

    // ==================== BUILDING ELEMENT ICONS ====================

    val Architecture = Icons.Filled.Architecture
    val Build = Icons.Filled.Build
    val Construction = Icons.Filled.Construction
    val Carpenter = Icons.Filled.Carpenter
    val Foundation = Icons.Filled.Foundation

    // ==================== DETAIL SCREEN ICONS ====================

    val Dimensions = Icons.Filled.Straighten
    val Material = Icons.Filled.Texture
    val Tools = Icons.Filled.Handyman
    val Calendar = Icons.Filled.CalendarToday
    val Location = Icons.Filled.LocationOn
    val Person = Icons.Filled.Person

    // ==================== EMPTY STATE ICONS ====================

    val SearchOff = Icons.Filled.SearchOff
    val FolderOpen = Icons.Filled.FolderOpen
    val ErrorOutline = Icons.Filled.ErrorOutline
    val HourglassEmpty = Icons.Filled.HourglassEmpty

    // ==================== SOCIAL & SHARE ICONS ====================

    val Email = Icons.Filled.Email
    val Link = Icons.Filled.Link
    val ContentCopy = Icons.Filled.ContentCopy

    // ==================== MORE SCREEN ICONS ====================

    val About = Icons.Filled.Info
    val PrivacyPolicy = Icons.Filled.Policy
    val RateApp = Icons.Filled.Star
    val Feedback = Icons.Filled.Feedback
    val BugReport = Icons.Filled.BugReport

    // ==================== SPECIFICATION ICONS ====================

    /**
     * Get icon for specification category
     */
    fun getSpecIcon(specCategory: String): ImageVector {
        return when (specCategory.lowercase()) {
            "material" -> Material
            "structural" -> Build
            "dimensional" -> Dimensions
            "aesthetic" -> Image
            "performance" -> CheckCircle
            "installation" -> Construction
            "maintenance" -> Tools
            else -> Info
        }
    }
}

/**
 * Extension function to get category icon safely
 */
fun String.toCategoryIcon(): ImageVector {
    return AppIcons.getCategoryIcon(this)
}