package com.example.podcast_demo.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import com.example.podcast_demo.ui.theme.BackgroundGradientEnd
import com.example.podcast_demo.ui.theme.BackgroundGradientStart
import com.example.podcast_demo.ui.theme.TextPrimary

@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        BackgroundGradientStart,
                        BackgroundGradientEnd
                    )
                )
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Greeting section
            Text(
                text = "good afternoon",
                style = MaterialTheme.typography.headlineLarge,
                color = TextPrimary
            )
            
            // TODO: Implement the rest of the home screen components
            // - User avatar and search icon
            // - "to get you started" section with Daily Mix cards
            // - "recently played" section
            // - Horizontal scrollable lists
        }
    }
}