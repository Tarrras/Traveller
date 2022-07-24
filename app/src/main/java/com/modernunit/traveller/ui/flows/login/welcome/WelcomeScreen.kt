package com.modernunit.traveller.ui.flows.login.welcome

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.modernunit.traveller.R

@Composable
fun WelcomeScreen(modifier: Modifier = Modifier) = Box(
    modifier = modifier
        .fillMaxSize()
) {
    Log.d("TAG", "Welcome fragment!")
    Image(
        modifier = Modifier.fillMaxSize(),
        painter = painterResource(id = R.drawable.start_image),
        contentDescription = null,
        contentScale = ContentScale.Crop
    )
    Column(
        modifier = Modifier.align(Alignment.Center),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Android",
        )
        Button(onClick = { /*TODO*/ }, shape = RoundedCornerShape(30.dp)) {
            Text(text = "Button")
        }
    }
}