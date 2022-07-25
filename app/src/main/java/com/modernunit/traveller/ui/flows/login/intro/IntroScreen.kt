package com.modernunit.traveller.ui.flows.login.intro

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.modernunit.traveller.R
import com.modernunit.traveller.service.NetworkState
import com.modernunit.traveller.ui.base.ConnectionLostCard
import com.modernunit.traveller.ui.base.TravellerButton
import com.modernunit.traveller.ui.theme.TravellerTheme

@Composable
fun IntroScreen(
    onLogIn: () -> Unit,
    onSignUp: () -> Unit,
    viewModel: IntroScreenViewModel = hiltViewModel()
) = Box(
    modifier = Modifier
        .fillMaxSize()
        .background(Color.White) //todo add support for dark theme
        .navigationBarsPadding()
        .statusBarsPadding(),
) {
    val connectionState by viewModel.connectionState.collectAsState(initial = NetworkState.AVAILABLE)

    IntroScreenContent(
        modifier = Modifier
            .align(Alignment.TopStart)
            .padding(horizontal = 30.dp),
        onLogIn = onLogIn,
        onSignUp = onSignUp
    )

    ConnectionLostCard(
        modifier = Modifier
            .align(Alignment.TopCenter),
        connectionState = connectionState,
    )
}

@Composable
fun IntroScreenContent(
    modifier: Modifier = Modifier,
    onLogIn: () -> Unit,
    onSignUp: () -> Unit,
) = Column(
    horizontalAlignment = Alignment.CenterHorizontally,
    modifier = modifier,
) {
    Spacer(modifier = Modifier.height(12.dp))
    Image(
        painter = painterResource(id = R.drawable.traveller_logo),
        contentDescription = stringResource(
            id = R.string.app_name
        )
    )
    Spacer(modifier = Modifier.weight(1f))
    Text(
        text = stringResource(id = R.string.play_your_trip),
        style = MaterialTheme.typography.h1
    )
    Spacer(modifier = Modifier.height(8.dp))
    Text(
        text = stringResource(id = R.string.custom_and_fast),
        fontSize = 16.sp,
        style = MaterialTheme.typography.subtitle1,
        textAlign = TextAlign.Center
    )
    Spacer(modifier = Modifier.weight(1f))
    TravellerButton(
        onClick = onLogIn,
        text = stringResource(id = R.string.log_in),
        modifier = Modifier
            .fillMaxWidth()
    )
    Spacer(modifier = Modifier.height(16.dp))
    TravellerButton(
        modifier = Modifier
            .fillMaxWidth(),
        onClick = onSignUp,
        text = stringResource(id = R.string.sign_up),
        backgroundColor = Color.White, //todo add support for dark theme
        contentColor = Color.Black //todo add support for dark theme
    )
    Spacer(modifier = Modifier.height(32.dp))
}

@Preview(device = "id:pixel_3")
@Composable
fun IntroScreenPreview() = TravellerTheme {
    Scaffold {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White) //todo add support for dark theme
                .navigationBarsPadding()
                .statusBarsPadding()
        ) {
            IntroScreenContent(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(horizontal = 30.dp),
                onLogIn = {},
                onSignUp = {}
            )
            ConnectionLostCard(
                modifier = Modifier
                    .align(Alignment.TopCenter),
                connectionState = NetworkState.UNAVAILABLE,
            )
        }
    }
}

