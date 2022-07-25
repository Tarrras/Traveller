package com.modernunit.traveller.ui.base

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.modernunit.traveller.ui.theme.TravellerTheme

@Composable
fun TravellerButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    backgroundColor: Color = MaterialTheme.colors.primary,
    contentColor: Color = contentColorFor(backgroundColor = backgroundColor)
) = Button(
    modifier = modifier,
    onClick = onClick,
    elevation = ButtonDefaults.elevation(defaultElevation = 4.dp),
    colors = ButtonDefaults.buttonColors(
        backgroundColor = backgroundColor,
        contentColor = contentColor
    ),
    shape = RoundedCornerShape(30.dp),
    contentPadding = PaddingValues(vertical = 16.dp, horizontal = 16.dp)
) {
    Text(
        text = text, style = MaterialTheme.typography.button,
        maxLines = 1
    )
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Preview(uiMode = UI_MODE_NIGHT_NO)
@Composable
fun TravellerButtonPreview() = TravellerTheme {
    Surface {
        TravellerButton(text = "Log In", onClick = { })
    }
}