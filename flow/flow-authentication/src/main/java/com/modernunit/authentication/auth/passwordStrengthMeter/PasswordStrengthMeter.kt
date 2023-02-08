package com.modernunit.authentication.auth.passwordStrengthMeter

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.modernunit.authentication.R
import com.modernunit.authentication.auth.validator.PasswordRequirement
import kotlinx.collections.immutable.ImmutableList

@Composable
fun PasswordStrengthMeter(
    modifier: Modifier = Modifier,
    passwordSatisfiedRequirements: ImmutableList<PasswordRequirement>,
    showMeterProgress: Boolean = true,
) {
    val strengthState: PasswordStrengthMeterState = remember(passwordSatisfiedRequirements) {
        when {
            passwordSatisfiedRequirements.isEmpty() -> PasswordStrengthMeterState.Empty
            passwordSatisfiedRequirements.size == 1 -> PasswordStrengthMeterState.Weak
            passwordSatisfiedRequirements.size == 2 -> PasswordStrengthMeterState.Medium
            passwordSatisfiedRequirements.size == 3 -> PasswordStrengthMeterState.Almost
            else -> PasswordStrengthMeterState.Awesome
        }
    }

    Column(horizontalAlignment = Alignment.Start, modifier = modifier) {
        if (showMeterProgress) {
            PasswordStrengthMeterProgress(
                meterColors = defaultMeterColors(),
                strengthState = strengthState
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = strengthState.getEmojiStatus(),
            color = Color.Gray //todo change
        )
        Spacer(modifier = Modifier.height(8.dp))
        PasswordRequirement.values().forEach { requirement ->
            Qualifier(
                text = stringResource(id = requirement.requirementRes),
                isSatisfied = passwordSatisfiedRequirements.contains(requirement)
            )
        }
    }
}

@Composable
fun Qualifier(
    modifier: Modifier = Modifier,
    text: String,
    isSatisfied: Boolean
) = Row(
    modifier
        .wrapContentWidth()
        .animateContentSize()
) {
    val textColor by animateColorAsState(
        targetValue = if (isSatisfied) Color(0xFF67C85A) else Color.LightGray //todo update
    )

    Text(text = text, color = textColor)
    Spacer(modifier = Modifier.width(12.dp))
    AnimatedVisibility(visible = isSatisfied) {
        Icon(
            painter = painterResource(id = R.drawable.round_done_24),
            contentDescription = text
        )
    }
}

