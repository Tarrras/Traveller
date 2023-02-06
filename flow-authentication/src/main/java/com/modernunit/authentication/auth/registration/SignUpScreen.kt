package com.modernunit.authentication.auth.registration

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
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
    /*val connectionState by viewModel.connectionState.collectAsState(initial = NetworkState.AVAILABLE)
    val isUpdating by viewModel.isInProgress.collectAsState()

    val email by viewModel.userEmail.collectAsState()
    val emailValidationResult by viewModel.userEmailValidation.collectAsState()
    val password by viewModel.userPassword.collectAsState()
    val passwordValidationResult by viewModel.userPasswordValidation.collectAsState()
    val isSignUpButtonEnabled by viewModel.isSignUpButtonEnabled.collectAsState(false)
    val isFeatureIsNotAvailable by viewModel.featureIsNotAvailableShown.collectAsState()

    val authState by viewModel.signUpState.collectAsState()*/
    /*if (authState is AuthenticationScreenState.AuthenticationSuccessfully) {
        LaunchedEffect(Unit) { onSuccessfullySignUp() }
    }*/

    /*SignUpScreenContent(
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
        authenticationError = authState as? AuthenticationScreenState.AuthenticationError,
        isSignUpButtonEnabled = isSignUpButtonEnabled,
        onEmailChanged = viewModel::onEmailChanged,
        onPasswordChanged = viewModel::onPasswordChanged,
        onBackPressed = onBackPressed,
        onSignUp = viewModel::onSignUp,
        onGoToLogIn = onGoToLogIn,
        onFacebookClicked = viewModel::showFeatureIsNotAvailableMessage,
        onGoogleClicked = viewModel::showFeatureIsNotAvailableMessage
    )*/

    /*ConnectionLostCard(
        modifier = Modifier
            .align(Alignment.TopCenter),
        isVisible = connectionState == NetworkState.UNAVAILABLE,
    )

    FeatureIsNotAvailableMessage(
        modifier = Modifier
            .align(Alignment.BottomCenter),
        shown = isFeatureIsNotAvailable
    )*/
}

/*
@Composable
fun SignUpScreenContent(
    modifier: Modifier = Modifier,
    email: String?,
    emailValidationResult: EmailValidationResult?,
    password: String?,
    passwordValidationResult: PasswordValidationResult?,
    authenticationError: AuthenticationScreenState.AuthenticationError?,
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
}*/
