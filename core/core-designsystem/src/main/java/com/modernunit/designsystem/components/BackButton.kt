package com.modernunit.designsystem.components

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.LocalMinimumTouchTargetEnforcement
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.modernunit.designsystem.R

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BackButton(modifier: Modifier = Modifier, onBackPressed: () -> Unit) =
    CompositionLocalProvider(
        LocalMinimumTouchTargetEnforcement provides false,
    ) {
        IconButton(onClick = onBackPressed, modifier = modifier) {
            Icon(
                painter = painterResource(id = R.drawable.ic_arrow_left),
                contentDescription = null
            )
        }
    }
