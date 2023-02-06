package com.modernunit.authentication.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.modernunit.authentication.R
import com.modernunit.designsystem.base.TravellerButton
import com.modernunit.designsystem.theme.TravellerTheme

@Composable
fun WelcomeScreen(
    modifier: Modifier = Modifier,
    onClickNext: () -> Unit
) = Box(
    modifier = modifier
        .fillMaxSize()
) {
    val composition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(R.raw.location_loader_anim)
    )
    Image(
        modifier = Modifier.fillMaxSize(),
        painter = painterResource(id = R.drawable.start_image),
        contentDescription = null,
        contentScale = ContentScale.Crop
    )
    Column(
        modifier = Modifier
            .navigationBarsPadding()
            .padding(WindowInsets.statusBars.asPaddingValues())
            .padding(horizontal = 32.dp)
            .align(Alignment.Center)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.weight(1f, true),
            verticalArrangement = Arrangement.Center
        ) {
            LottieAnimation(
                composition = composition,
                iterations = LottieConstants.IterateForever,
                modifier = Modifier
                    .padding(top = 16.dp)
                    .size(200.dp)
            )
            Text(
                stringResource(id = R.string.app_name),
                fontSize = 46.sp,
                fontWeight = FontWeight.W700,
                fontFamily = FontFamily.SansSerif
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = stringResource(id = R.string.welcome_to),
                fontSize = 16.sp,
                style = MaterialTheme.typography.subtitle1,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.weight(1f))
            TravellerButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 32.dp),
                onClick = onClickNext,
                text = stringResource(id = R.string.lets_start)
            )
        }
    }
}

@Preview(device = "id:Nexus One")
@Composable
fun WelcomeScreenPreview() = TravellerTheme {
    Surface {
        WelcomeScreen(onClickNext = {})
    }
}