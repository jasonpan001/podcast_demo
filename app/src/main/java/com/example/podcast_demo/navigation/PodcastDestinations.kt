package com.example.podcast_demo.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.LibraryMusic
import androidx.compose.material.icons.filled.Stars
import androidx.compose.ui.graphics.vector.ImageVector

sealed class PodcastDestinations(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Home : PodcastDestinations(
        route = "home",
        title = "home",
        icon = Icons.Default.Home
    )
    
    object Search : PodcastDestinations(
        route = "search", 
        title = "search",
        icon = Icons.Default.Search
    )
    
    object Library : PodcastDestinations(
        route = "library",
        title = "your library", 
        icon = Icons.Default.LibraryMusic
    )
    
    object Premium : PodcastDestinations(
        route = "premium",
        title = "premium",
        icon = Icons.Default.Stars
    )
}

val bottomNavItems = listOf(
    PodcastDestinations.Home,
    PodcastDestinations.Search,
    PodcastDestinations.Library,
    PodcastDestinations.Premium
)