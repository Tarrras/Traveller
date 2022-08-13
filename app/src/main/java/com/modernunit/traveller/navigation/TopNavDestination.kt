package com.modernunit.traveller.navigation

sealed class TopNavDestination(val destination: String) {
    object LoginGraph : TopNavDestination("login")
    object MainGraph : TopNavDestination("main")
}
