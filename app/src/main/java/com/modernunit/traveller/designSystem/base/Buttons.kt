package com.modernunit.traveller.designSystem.base

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.modernunit.traveller.designSystem.theme.TravellerTheme

@Composable
fun TravellerButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    backgroundColor: Color = MaterialTheme.colors.primary,
    contentColor: Color = contentColorFor(backgroundColor = backgroundColor),
    enabled: Boolean = true,
) = Button(
    modifier = modifier,
    onClick = onClick,
    elevation = ButtonDefaults.elevation(defaultElevation = 4.dp),
    colors = ButtonDefaults.buttonColors(
        backgroundColor = backgroundColor,
        contentColor = contentColor,
        disabledBackgroundColor = backgroundColor.copy(alpha = 0.12f)
    ),
    shape = RoundedCornerShape(30.dp),
    contentPadding = PaddingValues(vertical = 16.dp, horizontal = 16.dp),
    enabled = enabled
) {
    Text(
        text = text, style = MaterialTheme.typography.button,
        maxLines = 1
    )
}

@Composable
fun SocialButton(
    modifier: Modifier = Modifier,
    text: String,
    logo: Painter,
    onClick: () -> Unit,
    backgroundColor: Color = MaterialTheme.colors.primary,
    textColor: Color
) = Button(
    modifier = modifier,
    onClick = onClick,
    elevation = ButtonDefaults.elevation(defaultElevation = 4.dp),
    colors = ButtonDefaults.buttonColors(
        backgroundColor = backgroundColor,
    ),
    shape = RoundedCornerShape(30.dp),
    contentPadding = PaddingValues(top = 16.dp, bottom = 16.dp)
) {
    Spacer(modifier = Modifier.weight(1f))
    Icon(
        painter = logo, contentDescription = text, tint = Color.Unspecified
    )
    Spacer(modifier = Modifier.weight(1f))
    Text(
        text = text, style = MaterialTheme.typography.h3,
        maxLines = 1, color = textColor
    )
    Spacer(modifier = Modifier.weight(1f))
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Preview(uiMode = UI_MODE_NIGHT_NO)
@Composable
fun TravellerButtonPreview() = TravellerTheme {
    Surface {
        TravellerButton(text = "Log In", onClick = { })
    }
}