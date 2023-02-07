package com.modernunit.authentication

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.modernunit.authentication.auth.InputPasswordFieldTestTag
import com.modernunit.authentication.auth.PasswordEyeTestTag
import com.modernunit.authentication.auth.TravellerInputPasswordField
import com.modernunit.designsystem.base.InputFieldTestTag
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TravellerInputPasswordFieldTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun placeholderIsDisplayedInputTextIsWorkingCorrectly() {
        var text = ""
        composeTestRule.setContent {
            TravellerInputPasswordField(
                password = "",
                onPasswordChanged = { text = it },
                needToShowStrengthMeter = false,
                passwordSatisfiedRequirements = emptyList()
            )
        }

        composeTestRule.onNodeWithTag(InputPasswordFieldTestTag).assertIsDisplayed()
        composeTestRule.onNodeWithTag(PasswordEyeTestTag).assertIsNotEnabled()
        composeTestRule.onNodeWithTag(InputFieldTestTag).performTextInput("qwerty")
        composeTestRule.onNodeWithTag(PasswordEyeTestTag).performClick()
        Assert.assertEquals(text, "qwerty")
    }

}