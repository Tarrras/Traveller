package com.modernunit.authentication.auth.passwordStrengthMeter

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.modernunit.designsystem.theme.TravellerTheme

@Composable
fun PasswordStrengthMeterProgress(
    modifier: Modifier = Modifier,
    strengthState: PasswordStrengthMeterState = PasswordStrengthMeterState.Almost,
    meterColors: PasswordStrengthMeterColors,
) {
    val widthMultiplier by animateFloatAsState(
        targetValue = strengthState.absoluteProgress,
        animationSpec = tween(1000)
    )

    val progressColor by animateColorAsState(
        targetValue = strengthState.getStateColor(meterColors),
        animationSpec = tween(1000)
    )

    Canvas(
        modifier = modifier
            .fillMaxWidth()
            .height(6.dp)
    ) {
        drawBackgroundRect(meterColors.backgroundColor)
        drawStrengthProgressRect(
            backgroundColor = progressColor,
            widthMultiplier = widthMultiplier
        )
    }
}

private fun DrawScope.drawBackgroundRect(
    backgroundColor: Color
) {
    drawRoundRect(
        color = backgroundColor,
        style = Fill,
        cornerRadius = CornerRadius(x = 8.dp.toPx(), y = 8.dp.toPx())
    )
}

private fun DrawScope.drawStrengthProgressRect(
    backgroundColor: Color,
    widthMultiplier: Float,
) {
    drawRoundRect(
        size = Size(
            width = size.width * widthMultiplier,
            height = size.height
        ),
        color = backgroundColor,
        style = Fill,
        cornerRadius = CornerRadius(x = 8.dp.toPx(), y = 8.dp.toPx())
    )
}


data class PasswordStrengthMeterColors(
    val backgroundColor: Color = Color.Gray.copy(alpha = 0.1f),
    val weakStrengthBackgroundColor: Color = Color(0xFFFB0066),
    val mediumStrengthBackgroundColor: Color = Color(0xFFFBDC00),
    val almostStrengthBackgroundColor: Color = Color(0xFF259ED7),
    val awesomeStrengthBackgroundColor: Color = Color(0xFF67C85A)
)

fun defaultMeterColors() = PasswordStrengthMeterColors()


@Preview
@Composable
private fun PasswordStrengthMeterPreview() {
    TravellerTheme {
        Surface {
            Column {
                PasswordStrengthMeterProgress(
                    modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp),
                    meterColors = defaultMeterColors(),
                    strengthState = PasswordStrengthMeterState.Weak
                )
                PasswordStrengthMeterProgress(
                    modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp),
                    meterColors = defaultMeterColors(),
                    strengthState = PasswordStrengthMeterState.Medium
                )
                PasswordStrengthMeterProgress(
                    modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp),
                    meterColors = defaultMeterColors(),
                    strengthState = PasswordStrengthMeterState.Almost
                )
                PasswordStrengthMeterProgress(
                    modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp),
                    meterColors = defaultMeterColors(),
                    strengthState = PasswordStrengthMeterState.Awesome
                )
            }
        }
    }
}