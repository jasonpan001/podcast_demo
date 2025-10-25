package com.example.podcast_demo.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import com.example.podcast_demo.navigation.bottomNavItems
import com.example.podcast_demo.ui.theme.BackgroundGradientEnd
import com.example.podcast_demo.ui.theme.BackgroundGradientStart
import com.example.podcast_demo.ui.theme.CardBackground
import com.example.podcast_demo.ui.theme.CardStroke
import com.example.podcast_demo.ui.theme.TextPrimary
import com.example.podcast_demo.ui.theme.TextSecondary

@Composable
fun PodcastBottomNavigation(
    navController: NavController,
    currentDestination: NavDestination?
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        BackgroundGradientStart,
                        BackgroundGradientEnd
                    )
                )
            )
    ) {
        // Background rounded container with stroke border
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 16.dp)
                .clip(RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
                .background(CardBackground)
                .border(
                    width = 0.5.dp,
                    color = CardStroke,
                    shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp)
                )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                bottomNavItems.forEach { destination ->
                    val selected = currentDestination?.hierarchy?.any { 
                        it.route == destination.route 
                    } == true
                    
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .weight(1f)
                            .clickable { 
                                if (!selected) {
                                    navController.navigate(destination.route) {
                                        // Pop up to the start destination to avoid building up a large stack
                                        popUpTo(navController.graph.startDestinationId) {
                                            saveState = true
                                        }
                                        // Avoid multiple copies of the same destination
                                        launchSingleTop = true
                                        // Restore state when reselecting a previously selected item
                                        restoreState = true
                                    }
                                }
                            }
                            .padding(vertical = 8.dp)
                    ) {
                        Icon(
                            imageVector = destination.icon,
                            contentDescription = destination.title,
                            modifier = Modifier.size(20.dp),
                            tint = if (selected) TextPrimary else TextSecondary
                        )
                        
                        Spacer(modifier = Modifier.height(4.dp))
                        
                        Text(
                            text = destination.title,
                            style = MaterialTheme.typography.bodySmall,
                            color = if (selected) TextPrimary else TextSecondary
                        )
                    }
                }
            }
        }
    }
}