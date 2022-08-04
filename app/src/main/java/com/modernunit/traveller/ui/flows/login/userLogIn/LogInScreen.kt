package com.modernunit.traveller.ui.flows.login.userLogIn

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.modernunit.traveller.R
import com.modernunit.traveller.extensions.AnnotatedClickableText
import com.modernunit.traveller.extensions.EmailValidationResult
import com.modernunit.traveller.extensions.PasswordValidationResult
import com.modernunit.traveller.extensions.toValidationTextResult
import com.modernunit.traveller.service.NetworkState
import com.modernunit.traveller.ui.base.*
import com.modernunit.traveller.ui.theme.TravellerTheme

@Composable
fun LoginScreen(
    onBackPressed: () -> Unit,
    onSuccessfullyLogIn: () -> Unit,
    onGoToSignUp: () -> Unit,
    viewModel: LogInViewModel = hiltViewModel()
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
    val isLogInButtonEnabled by viewModel.isLogInButtonEnabled.collectAsState(false)

    //todo add shimmer
    LogInScreenContent(
        modifier = Modifier
            .align(Alignment.TopStart)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 30.dp),
        email = email,
        password = password,
        emailValidationResult = emailValidationResult,
        passwordValidationResult = passwordValidationResult,
        isLogInButtonEnabled = isLogInButtonEnabled,
        onEmailChanged = viewModel::onEmailChanged,
        onPasswordChanged = viewModel::onPasswordChanged,
        onBackPressed = onBackPressed,
        onLogIn = viewModel::onLogIn,
        onGoToSignUp = onGoToSignUp,
        onForgotPassword = viewModel::onForgotPassword
    )

    ConnectionLostCard(
        modifier = Modifier
            .align(Alignment.TopCenter),
        connectionState = connectionState,
    )
}

@Composable
fun LogInScreenContent(
    modifier: Modifier = Modifier,
    email: String?,
    emailValidationResult: EmailValidationResult?,
    password: String?,
    passwordValidationResult: PasswordValidationResult?,
    isLogInButtonEnabled: Boolean,
    onEmailChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    onBackPressed: () -> Unit,
    onLogIn: () -> Unit,
    onGoToSignUp: () -> Unit,
    onForgotPassword: () -> Unit,
) = Column(modifier = modifier) {
    Spacer(modifier = Modifier.height(12.dp))
    IconButton(onClick = onBackPressed) {
        Icon(
            painter = painterResource(id = R.drawable.ic_arrow_left),
            contentDescription = null
        )
    }
    Spacer(modifier = Modifier.height(16.dp))
    Text(text = stringResource(id = R.string.log_in), style = MaterialTheme.typography.h1)
    Spacer(modifier = Modifier.height(20.dp))
    SocialButtonsGroup(
        modifier = Modifier.fillMaxWidth(),
        onGoogleClicked = {},
        onFacebookClicked = {}
    )
    Spacer(modifier = Modifier.height(32.dp))
    Text(
        text = stringResource(id = R.string.or_log_in_using),
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.subtitle1
    )
    TravellerInputTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 32.dp, bottom = 8.dp),
        text = email ?: "",
        onValueChanged = onEmailChanged,
        error = emailValidationResult?.toValidationTextResult(),
        placeholderText = stringResource(id = R.string.email_field)
    )
    TravellerInputPasswordField(
        modifier = Modifier.padding(top = 8.dp),
        password = password ?: "",
        onPasswordChanged = onPasswordChanged,
        error = passwordValidationResult?.toValidationTextResult()
    )
    Spacer(modifier = Modifier.height(12.dp))
    ClickableText(
        text = AnnotatedString(stringResource(id = R.string.forgot_your_password)),
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 12.dp),
        style = MaterialTheme.typography.subtitle1.copy(textAlign = TextAlign.End),
        onClick = { _ ->
            onForgotPassword()
        }
    )
    Spacer(modifier = Modifier.weight(1f))
    TravellerButton(
        onClick = onLogIn,
        text = stringResource(id = R.string.log_in),
        modifier = Modifier
            .fillMaxWidth(),
        enabled = isLogInButtonEnabled
    )
    Spacer(modifier = Modifier.height(32.dp))
    AnnotatedClickableText(
        onClick = onGoToSignUp, modifier = Modifier.fillMaxWidth(), normalText = stringResource(
            id = R.string.dont_have_an_account_yet
        ), stringToBeAnnotated = stringResource(id = R.string.sign_up)
    )
    Spacer(modifier = Modifier.height(32.dp))
}

@Preview
@Composable
fun LoginScreenPreview() = TravellerTheme {
    Scaffold {
        LogInScreenContent(
            modifier = Modifier.padding(horizontal = 30.dp),
            email = "email",
            password = "123",
            emailValidationResult = EmailValidationResult.Valid,
            passwordValidationResult = PasswordValidationResult.Valid,
            isLogInButtonEnabled = true,
            onLogIn = {},
            onBackPressed = {},
            onEmailChanged = {},
            onGoToSignUp = {},
            onPasswordChanged = {},
            onForgotPassword = {}
        )
    }
}