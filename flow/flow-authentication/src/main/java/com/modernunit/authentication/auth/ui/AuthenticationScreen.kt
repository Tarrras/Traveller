package com.modernunit.authentication.auth.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.insets.ui.Scaffold
import com.modernunit.authentication.R
import com.modernunit.authentication.auth.AuthenticationMode
import com.modernunit.authentication.auth.AuthenticationScreenEvent
import com.modernunit.authentication.auth.AuthenticationScreenState
import com.modernunit.authentication.auth.EmptyAuthenticationScreenState
import com.modernunit.authentication.auth.TravellerInputPasswordField
import com.modernunit.authentication.auth.validator.toValidationTextResult
import com.modernunit.designsystem.components.BackButton
import com.modernunit.designsystem.components.ConnectionLostCard
import com.modernunit.designsystem.components.FeatureIsNotAvailableMessage
import com.modernunit.designsystem.components.GoogleAuthButton
import com.modernunit.designsystem.components.TravellerGradientButton
import com.modernunit.designsystem.components.TravellerInputTextField
import com.modernunit.designsystem.extensions.AnnotatedClickableText
import com.modernunit.designsystem.extensions.shimmer
import com.modernunit.designsystem.theme.TravellerTheme

@Composable
fun AuthenticationScreen(
    onBackPressed: () -> Unit,
    onSuccessfullyLogIn: () -> Unit,
    viewModel: AuthenticationViewModel = hiltViewModel()
) = Box(
    modifier = Modifier
        .fillMaxSize()
        .background(TravellerTheme.colors.neutralGrey)
        .navigationBarsPadding()
        .imePadding()
        .statusBarsPadding(),
) {
    val uiState by viewModel.uiState.collectAsState()
    if (uiState.isAuthSuccess) {
        LaunchedEffect(Unit) { onSuccessfullyLogIn() }
    }

    AuthenticationScreenContent(
        modifier = Modifier
            .align(Alignment.TopStart)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 30.dp),
        uiState = uiState,
        handleEvent = viewModel::handleEvent,
        onBackPressed = onBackPressed,
    )

    ConnectionLostCard(
        modifier = Modifier
            .align(Alignment.TopCenter),
        isVisible = !uiState.isInternetConnectionAvailable,
    )

    FeatureIsNotAvailableMessage(
        modifier = Modifier
            .align(Alignment.BottomCenter),
        shown = uiState.isFeatureIsNotAvailableMessageShow
    )
}

@Composable
fun AuthenticationScreenContent(
    modifier: Modifier = Modifier,
    uiState: AuthenticationScreenState,
    handleEvent: (AuthenticationScreenEvent) -> Unit,
    onBackPressed: () -> Unit,
) = Column(
    modifier = modifier.shimmer(uiState.isLoading)
) {
    Spacer(modifier = Modifier.height(12.dp))
    BackButton(onBackPressed = onBackPressed)
    Spacer(modifier = Modifier.height(16.dp))
    Text(
        text = stringResource(id = if (uiState.mode == AuthenticationMode.SIGN_IN) R.string.log_in else R.string.sign_up),
        style = MaterialTheme.typography.h1
    )
    Spacer(modifier = Modifier.height(20.dp))
    GoogleAuthButton(
        modifier = Modifier.fillMaxWidth(),
        onGoogleClicked = { handleEvent(AuthenticationScreenEvent.AuthenticateWithGoogle) },
    )
    Spacer(modifier = Modifier.height(32.dp))
    Text(
        text = stringResource(
            id = if (uiState.mode == AuthenticationMode.SIGN_IN) R.string.or_log_in_using
            else R.string.or_sign_up_using
        ),
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.subtitle1
    )
    uiState.errorMessage?.let {
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = it,
            color = MaterialTheme.colors.error,
            style = MaterialTheme.typography.subtitle1
        )
        Spacer(modifier = Modifier.height(24.dp))
    } ?: Spacer(modifier = Modifier.height(32.dp))
    TravellerInputTextField(
        modifier = Modifier
            .fillMaxWidth(),
        text = uiState.emailField ?: "",
        onValueChanged = { handleEvent(AuthenticationScreenEvent.EmailChangedEvent(it)) },
        error = uiState.emailValidationResult?.toValidationTextResult(),
        placeholderText = stringResource(id = R.string.email_field)
    )
    Spacer(modifier = Modifier.height(16.dp))
    TravellerInputPasswordField(
        modifier = Modifier.fillMaxWidth(),
        password = uiState.passwordField ?: "",
        onPasswordChanged = { handleEvent(AuthenticationScreenEvent.PasswordChangedEvent(it)) },
        needToShowStrengthMeter = uiState.mode == AuthenticationMode.SIGN_UP,
        passwordSatisfiedRequirements = uiState.passwordValidationResult
    )
    Spacer(modifier = Modifier.height(12.dp))
    AnimatedVisibility(visible = uiState.mode == AuthenticationMode.SIGN_IN) {
        ClickableText(
            text = AnnotatedString(stringResource(id = R.string.forgot_your_password)),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 12.dp),
            style = MaterialTheme.typography.subtitle1.copy(textAlign = TextAlign.End),
            onClick = { _ ->
                handleEvent(AuthenticationScreenEvent.ForgotPasswordEvent)
            }
        )
    }
    Spacer(modifier = Modifier.weight(1f))
    TravellerGradientButton(
        onClick = {
            handleEvent(AuthenticationScreenEvent.Authenticate)
        },
        text = stringResource(id = if (uiState.mode == AuthenticationMode.SIGN_IN) R.string.log_in else R.string.sign_up),
        modifier = Modifier
            .fillMaxWidth(),
        enabled = uiState.isLogInButtonEnabled
    )
    Spacer(modifier = Modifier.height(32.dp))
    AnnotatedClickableText(
        onClick = {
            handleEvent(AuthenticationScreenEvent.ChangeModeEvent)
        },
        modifier = Modifier.fillMaxWidth(),
        normalText = stringResource(
            id = if (uiState.mode == AuthenticationMode.SIGN_IN) R.string.dont_have_an_account_yet else R.string.already_have_an_account
        ),
        stringToBeAnnotated = stringResource(id = if (uiState.mode == AuthenticationMode.SIGN_IN) R.string.sign_up else R.string.sign_in)
    )
    Spacer(modifier = Modifier.height(32.dp))
}

@Preview(device = "id:Nexus S")
@Composable
fun LoginScreenPreview() = TravellerTheme {
    Scaffold {
        AuthenticationScreenContent(
            modifier = Modifier.padding(horizontal = 30.dp),
            uiState = EmptyAuthenticationScreenState,
            handleEvent = { },
            onBackPressed = { },
        )
    }
}
