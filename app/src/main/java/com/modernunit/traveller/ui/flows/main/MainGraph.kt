package com.modernunit.traveller.ui.flows.main

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.modernunit.traveller.ui.flows.top.TopNavDestination

fun NavGraphBuilder.mainGraph() {
    navigation(startDestination = "home", route = TopNavDestination.MainGraph.destination) {
        composable("home") {
            Text(text = "Home", fontSize = 30.sp, color = MaterialTheme.colors.primary)
        }
    }
}