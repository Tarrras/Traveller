package com.modernunit.authentication.registration

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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.modernunit.authentication.R
import com.modernunit.background.connection.NetworkState
import com.modernunit.common.validator.AuthenticationUserState
import com.modernunit.common.validator.EmailValidationResult
import com.modernunit.common.validator.PasswordValidationResult
import com.modernunit.common.validator.toValidationTextResult
import com.modernunit.coreUi.TravellerInputPasswordField
import com.modernunit.designsystem.base.BackButton
import com.modernunit.designsystem.base.ConnectionLostCard
import com.modernunit.designsystem.base.FeatureIsNotAvailableMessage
import com.modernunit.designsystem.base.SocialButtonsGroup
import com.modernunit.designsystem.base.TravellerButton
import com.modernunit.designsystem.base.TravellerInputTextField
import com.modernunit.designsystem.extensions.AnnotatedClickableText
import com.modernunit.designsystem.extensions.shimmer
import com.modernunit.designsystem.theme.TravellerTheme

@Composable
fun SignUpScreen(
    onBackPressed: () -> Unit,
    onSuccessfullySignUp: () -> Unit,
    onGoToLogIn: () -> Unit,
    viewModel: SignUpViewModel = hiltViewModel()
) = Box(
    modifier = Modifier
        .fillMaxSize()
        .background(TravellerTheme.colors.backgroundGrey)
        .navigationBarsPadding()
        .imePadding()
        .statusBarsPadding(),
) {
    val connectionState by viewModel.connectionState.collectAsState(initial = NetworkState.AVAILABLE)
    val isUpdating by viewModel.isInProgress.collectAsState()

    val email by viewModel.userEmail.collectAsState()
    val emailValidationResult by viewModel.userEmailValidation.collectAsState()
    val password by viewModel.userPassword.collectAsState()
    val passwordValidationResult by viewModel.userPasswordValidation.collectAsState()
    val isSignUpButtonEnabled by viewModel.isSignUpButtonEnabled.collectAsState(false)
    val isFeatureIsNotAvailable by viewModel.featureIsNotAvailableShown.collectAsState()

    val authState by viewModel.signUpState.collectAsState()
    if (authState is AuthenticationUserState.AuthenticationSuccessfully) {
        LaunchedEffect(Unit) { onSuccessfullySignUp() }
    }

    SignUpScreenContent(
        modifier = Modifier
            .align(Alignment.TopStart)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 30.dp)
            .shimmer(isUpdating),
        email = email,
        password = password,
        emailValidationResult = emailValidationResult,
        passwordValidationResult = passwordValidationResult,
        authenticationError = authState as? AuthenticationUserState.AuthenticationError,
        isSignUpButtonEnabled = isSignUpButtonEnabled,
        onEmailChanged = viewModel::onEmailChanged,
        onPasswordChanged = viewModel::onPasswordChanged,
        onBackPressed = onBackPressed,
        onSignUp = viewModel::onSignUp,
        onGoToLogIn = onGoToLogIn,
        onFacebookClicked = viewModel::showFeatureIsNotAvailableMessage,
        onGoogleClicked = viewModel::showFeatureIsNotAvailableMessage
    )

    ConnectionLostCard(
        modifier = Modifier
            .align(Alignment.TopCenter),
        isVisible = connectionState == NetworkState.UNAVAILABLE,
    )

    FeatureIsNotAvailableMessage(
        modifier = Modifier
            .align(Alignment.BottomCenter),
        shown = isFeatureIsNotAvailable
    )
}

@Composable
fun SignUpScreenContent(
    modifier: Modifier = Modifier,
    email: String?,
    emailValidationResult: EmailValidationResult?,
    password: String?,
    passwordValidationResult: PasswordValidationResult?,
    authenticationError: AuthenticationUserState.AuthenticationError?,
    isSignUpButtonEnabled: Boolean,
    onEmailChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    onBackPressed: () -> Unit,
    onSignUp: () -> Unit,
    onGoToLogIn: () -> Unit,
    onGoogleClicked: () -> Unit,
    onFacebookClicked: () -> Unit,
) = Column(modifier = modifier) {
    Spacer(modifier = Modifier.height(12.dp))
    BackButton(onBackPressed = onBackPressed)

    Spacer(modifier = Modifier.height(16.dp))
    Text(text = stringResource(id = R.string.sign_up), style = MaterialTheme.typography.h1)
    Spacer(modifier = Modifier.height(20.dp))
    SocialButtonsGroup(
        modifier = Modifier.fillMaxWidth(),
        onGoogleClicked = onGoogleClicked,
        onFacebookClicked = onFacebookClicked
    )
    Spacer(modifier = Modifier.height(32.dp))
    Text(
        text = stringResource(id = R.string.or_sign_up_using),
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.subtitle1
    )
    authenticationError?.let {
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = it.errorMessage,
            color = MaterialTheme.colors.error,
            style = MaterialTheme.typography.subtitle1
        )
        Spacer(modifier = Modifier.height(24.dp))
    } ?: Spacer(modifier = Modifier.height(32.dp))
    TravellerInputTextField(
        modifier = Modifier
            .fillMaxWidth(),
        text = email ?: "",
        onValueChanged = onEmailChanged,
        error = emailValidationResult?.toValidationTextResult(),
        placeholderText = stringResource(id = R.string.email_field)
    )
    Spacer(modifier = Modifier.height(16.dp))
    TravellerInputPasswordField(
        modifier = Modifier.fillMaxWidth(),
        password = password ?: "",
        onPasswordChanged = onPasswordChanged,
        error = passwordValidationResult?.toValidationTextResult()
    )
    Spacer(modifier = Modifier.height(16.dp))
    Spacer(modifier = Modifier.weight(1f))
    TravellerButton(
        onClick = onSignUp,
        text = stringResource(id = R.string.sign_up),
        modifier = Modifier
            .fillMaxWidth(),
        enabled = isSignUpButtonEnabled
    )
    Spacer(modifier = Modifier.height(32.dp))
    AnnotatedClickableText(
        onClick = onGoToLogIn, modifier = Modifier.fillMaxWidth(), normalText = stringResource(
            id = R.string.already_have_an_account
        ), stringToBeAnnotated = stringResource(id = R.string.sign_in)
    )
    Spacer(modifier = Modifier.height(32.dp))
}