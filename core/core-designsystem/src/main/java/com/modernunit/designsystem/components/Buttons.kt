package com.modernunit.designsystem.components

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.modernunit.designsystem.R
import com.modernunit.designsystem.theme.TravellerTheme

@Composable
fun TravellerGradientButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    enabled: Boolean = true,
) {
    val disabledBrush = Brush.horizontalGradient(
        0f to MaterialTheme.colorScheme.surfaceVariant,
        1f to MaterialTheme.colorScheme.surfaceVariant
    )
    val backgroundBrush = remember(enabled) {
        if (enabled) AzureGradient else disabledBrush
    }
    Button(
        modifier = modifier,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = TravellerTheme.colors.neutralGrey,
        ),
        shape = RoundedCornerShape(30.dp),
        contentPadding = PaddingValues(),
        enabled = enabled
    ) {
        Box(
            modifier = Modifier
                .background(backgroundBrush)
                .padding(
                    horizontal = 16.dp,
                    vertical = 8.dp
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text,
                style = MaterialTheme.typography.titleMedium,
                maxLines = 1
            )
        }
    }
}

@Composable
fun GoogleAuthButton(
    modifier: Modifier = Modifier,
    onGoogleClicked: () -> Unit
) = SocialButton(
    modifier = modifier,
    text = stringResource(id = R.string.google),
    logoProvider = {
        painterResource(id = R.drawable.ic_google_logo)
    },
    onClick = onGoogleClicked,
)

@Composable
private fun SocialButton(
    modifier: Modifier = Modifier,
    text: String,
    logoProvider: @Composable () -> Painter,
    onClick: () -> Unit,
) = Button(
    modifier = modifier,
    onClick = onClick,
    elevation = ButtonDefaults.buttonElevation(
        defaultElevation = 0.dp
    ),
    colors = ButtonDefaults.buttonColors(
        containerColor =
        TravellerTheme.colors.semitransparent,
    ),
    shape = RoundedCornerShape(30.dp),
    contentPadding = PaddingValues(top = 16.dp, bottom = 16.dp)
) {
    Spacer(modifier = Modifier.weight(1f))
    Icon(
        painter = logoProvider(),
        contentDescription = text,
        tint = Color.Unspecified
    )
    Spacer(modifier = Modifier.width(16.dp))
    Text(
        text = text,
        style = MaterialTheme.typography.titleMedium,
        maxLines = 1,
        color = TravellerTheme.colors.neutralGrey
    )
    Spacer(modifier = Modifier.weight(1f))
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Preview(uiMode = UI_MODE_NIGHT_NO)
@Composable
fun TravellerButtonPreview() = TravellerTheme {
    var isEnabled by remember { mutableStateOf(true) }
    Surface {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            TravellerGradientButton(
                text = "Log In",
                onClick = { isEnabled = !isEnabled },
                modifier = Modifier.padding(24.dp),
                enabled = isEnabled
            )
            GoogleAuthButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp)
            ) {

            }
        }
    }
}
