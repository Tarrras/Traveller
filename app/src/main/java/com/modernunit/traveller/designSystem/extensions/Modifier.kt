package com.modernunit.traveller.designSystem.extensions

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.isImeVisible
import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.foundation.relocation.bringIntoViewRequester
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusChanged

@OptIn(ExperimentalLayoutApi::class, ExperimentalFoundationApi::class)
fun Modifier.bringIntoViewAfterImeAnimation(): Modifier = composed {
    val isImeVisible = WindowInsets.isImeVisible
    var focusState by remember { mutableStateOf<FocusState?>(null) }
    val bringIntoViewRequester = remember { BringIntoViewRequester() }

    LaunchedEffect(
        isImeVisible,
        focusState,
        bringIntoViewRequester
    ) {
        if (isImeVisible &&
            focusState?.isFocused == true
        ) {
            bringIntoViewRequester.bringIntoView()
        }
    }

    bringIntoViewRequester(bringIntoViewRequester)
        .onFocusChanged { focusState = it }
}