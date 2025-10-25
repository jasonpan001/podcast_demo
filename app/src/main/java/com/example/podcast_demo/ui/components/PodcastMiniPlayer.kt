package com.example.podcast_demo.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.podcast_demo.ui.theme.CardBackground

@Composable
fun PodcastMiniPlayer() {
    // Placeholder for mini player - will be implemented later
    // This will be positioned at the bottom of the screen, above the navigation
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 16.dp)
            .height(0.dp) // Hidden for now
            .clip(RoundedCornerShape(32.dp))
            .background(CardBackground),
        contentAlignment = Alignment.Center
    ) {
        // Mini player content will go here
    }
}