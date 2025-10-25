package com.example.podcast_demo.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.podcast_demo.navigation.PodcastDestinations
import com.example.podcast_demo.ui.components.PodcastBottomNavigation
import com.example.podcast_demo.ui.components.PodcastMiniPlayer
import com.example.podcast_demo.ui.screens.home.HomeScreen
import com.example.podcast_demo.ui.screens.library.LibraryScreen
import com.example.podcast_demo.ui.screens.premium.PremiumScreen
import com.example.podcast_demo.ui.screens.search.SearchScreen

@Composable
fun PodcastApp(
    navController: NavHostController = rememberNavController()
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    
    Scaffold(
        bottomBar = {
            PodcastBottomNavigation(
                navController = navController,
                currentDestination = currentDestination
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            NavHost(
                navController = navController,
                startDestination = PodcastDestinations.Home.route,
                modifier = Modifier.fillMaxSize()
            ) {
                composable(PodcastDestinations.Home.route) {
                    HomeScreen()
                }
                composable(PodcastDestinations.Search.route) {
                    SearchScreen()
                }
                composable(PodcastDestinations.Library.route) {
                    LibraryScreen()
                }
                composable(PodcastDestinations.Premium.route) {
                    PremiumScreen()
                }
            }
            
            // Mini player overlay (will be implemented later)
            PodcastMiniPlayer()
        }
    }
}