package com.modernunit.homeFlow

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation

fun NavGraphBuilder.mainGraph(route: String) {
    navigation(startDestination = "home", route = route) {
        composable("home") {
            Text(text = "Home", fontSize = 30.sp, color = MaterialTheme.colors.primary)
        }
    }
}