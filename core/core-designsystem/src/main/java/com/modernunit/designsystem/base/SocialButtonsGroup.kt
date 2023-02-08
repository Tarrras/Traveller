package com.modernunit.designsystem.base

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.modernunit.designsystem.R
import com.modernunit.designsystem.theme.TravellerTheme

@Composable
fun SocialButtonsGroup(
    modifier: Modifier = Modifier,
    onGoogleClicked: () -> Unit,
    onFacebookClicked: () -> Unit,
) = Row(modifier = modifier) {
    SocialButton(
        modifier = Modifier.weight(1f),
        text = stringResource(id = R.string.google),
        logoProvider = {
            painterResource(id = R.drawable.ic_google_logo)
        },
        onClick = onGoogleClicked,
        backgroundColor = Color.White,
        textColor = Color.Black
    )
    Spacer(modifier = Modifier.width(20.dp))
    SocialButton(
        modifier = Modifier.weight(1f),
        text = stringResource(id = R.string.facebook),
        logoProvider = {
            painterResource(id = R.drawable.ic_facebook_logo)
        },
        onClick = onFacebookClicked,
        backgroundColor = TravellerTheme.colors.facebookBlue,
        textColor = Color.White
    )
}