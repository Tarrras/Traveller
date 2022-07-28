package com.modernunit.traveller.ui.flows.login.userLogIn

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.modernunit.traveller.ui.theme.TravellerTheme

@Composable
fun LoginScreen(modifier: Modifier = Modifier) = Column(
    modifier = modifier
) {

}

@Preview
@Composable
fun LoginScreenPreview() = TravellerTheme {
    Scaffold {
        LoginScreen()
    }
}