package com.modernunit.traveller.navigation

import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController

fun NavHostController.navigateToNestedGraph(destination: TopNavDestination) {
    navigate(destination.destination) {
        // Pop up to the start destination of the graph to
        // avoid building up a large stack of destinations
        popUpTo(graph.findStartDestination().id) {
            inclusive = true
        }
        // Avoid multiple copies of the same destination
        launchSingleTop = true
    }
}
