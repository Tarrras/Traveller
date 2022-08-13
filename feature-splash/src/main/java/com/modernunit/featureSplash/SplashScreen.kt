package com.modernunit.featureSplash

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

fun NavGraphBuilder.splashRoute(navigateToHome: () -> Unit, navigateToAuth: () -> Unit) {
    composable(SplashScreenRoute) {
        val viewModel = hiltViewModel<SplashViewModel>()
        SplashScreen(
            modifier = Modifier.fillMaxSize(),
            viewModel = viewModel,
            onNavigateToNewGraph = { isLogged ->
                Log.d("TAG", "navigateToNestedGraph here!")
                if (isLogged) navigateToHome() else navigateToAuth()
            }
        )
        LaunchedEffect(Unit) {
            Log.d("TAG", "checkLoggedStatus goes here!")
            viewModel.checkLoggedStatus()
        }

    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    viewModel: SplashViewModel,
    onNavigateToNewGraph: (Boolean) -> Unit,
) {
    var visible by remember { mutableStateOf(false) }
    val dataState by viewModel.isLogged.collectAsState()
    when (val state = dataState) {
        is SplashUiState.DataLoaded ->
            LaunchedEffect(Unit) { onNavigateToNewGraph(state.isLogged) }
        else -> Unit
    }


    AnimatedVisibility(
        visible = visible,
        enter = scaleIn() + fadeIn(
            initialAlpha = 0.3f
        ),
        modifier = modifier
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.start_image),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
    }

    LaunchedEffect(Unit) {
        visible = true
        viewModel.checkLoggedStatus()
    }
}

const val SplashScreenRoute = "splash_screen"