package com.modernunit.traveller.ui.flows.top

sealed class TopNavDestination(val destination: String) {
    object LoginGraph : TopNavDestination("login")
    object MainGraph : TopNavDestination("main")
}
