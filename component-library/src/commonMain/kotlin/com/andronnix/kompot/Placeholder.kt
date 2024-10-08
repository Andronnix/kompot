package com.andronnix.kompot

import androidx.compose.foundation.background
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.HoverInteraction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.unit.dp

@Composable
fun Placeholder() {
    val hoverSource = remember { MutableInteractionSource() }
    val isHovered by hoverSource.collectIsHoveredAsState()

    val brush = if (isHovered) stripedBrushHover else stripedBrush
    Box(modifier = Modifier.hoverable(hoverSource)) {
        Row(modifier = Modifier.background(brush = brush).padding(10.dp)) {
            Text(
                "Placeholder",
                modifier = Modifier
                    .align(alignment = Alignment.CenterVertically)
                    .padding(2.dp)
                    .background(Color.hsl(0f, 0f, 1.0f, 0.7f))
            )
        }
    }
}

object st : HoverInteraction {

}

val stripedBrush = Brush.linearGradient(
    0.0f to Color.hsl(41f, 0.0f, 0.75f),
    0.5f to Color.hsl(41f, 0.0f, 0.75f),
    0.5f to Color.hsl(41f, 0.97f, 0.75f),
    1.0f to Color.hsl(41f, 0.97f, 0.75f),
    start = Offset.Zero,
    end = Offset(x = 20f, y = 20f),
    tileMode = TileMode.Repeated
)

val stripedBrushHover = Brush.linearGradient(
    0.0f to Color.hsl(41f, 0.0f, 0.51f),
    0.5f to Color.hsl(41f, 0.0f, 0.51f),
    0.5f to Color.hsl(41f, 0.97f, 0.51f),
    1.0f to Color.hsl(41f, 0.97f, 0.51f),
    start = Offset.Zero,
    end = Offset(x = 20f, y = 20f),
    tileMode = TileMode.Repeated
)
