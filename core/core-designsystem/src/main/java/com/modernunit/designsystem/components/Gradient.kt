package com.modernunit.designsystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

val IvoryGradient = Brush.linearGradient(
    0.0f to Color(0xFFECF0F5),
    1.0f to Color(0xFFCCD6E6)
)

val AzureGradient = Brush.linearGradient(
    0.0f to Color(0xFF46D2FD),
    1.0f to Color(0xFF5351F0)
)

val ShamrockGradient = Brush.linearGradient(
    0.0f to Color(0xFF9DE686),
    1.0f to Color(0xFF2FAD66)
)

val SalmonGradient = Brush.linearGradient(
    0.0f to Color(0xFFF15887),
    1.0f to Color(0xFFFE9B86)
)

@Preview
@Composable
fun GradientsPreview() {
    val gradients = listOf(
        IvoryGradient,
        AzureGradient,
        ShamrockGradient,
        SalmonGradient
    )
    Surface {
        Column {
            repeat(gradients.size) {
                Box(
                    modifier = Modifier
                        .padding(12.dp)
                        .size(20.dp)
                        .background(
                            brush = gradients[it],
                            shape = RoundedCornerShape(percent = 16)
                        )
                )
            }
        }
    }
}