package com.modernunit.traveller.ui.flows.splash

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
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.modernunit.traveller.R
import com.modernunit.traveller.ui.flows.top.TopNavDestination
import com.modernunit.traveller.ui.flows.top.navigateToNestedGraph

fun NavGraphBuilder.splashRoute(navController: NavHostController) {
    composable(SplashScreenRoute) {
        val viewModel = hiltViewModel<SplashViewModel>()
        SplashScreen(
            modifier = Modifier.fillMaxSize(),
            viewModel = viewModel,
            onNavigateToNewGraph = { isLogged ->
                Log.d("TAG", "navigateToNestedGraph here!")
                navController.navigateToNestedGraph(
                    if (isLogged) TopNavDestination.MainGraph
                    else TopNavDestination.LoginGraph
                )
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
    if (viewModel.isUserLogged != null) {
        //todo refactor this
        LaunchedEffect(Unit) { onNavigateToNewGraph(viewModel.isUserLogged!!) }
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