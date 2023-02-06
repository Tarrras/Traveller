package com.modernunit.authentication

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.modernunit.authentication.auth.TravellerInputPasswordField
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TravellerInputPasswordFieldTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    //private val resources = ApplicationProvider.getApplicationContext<TestApp>().resources

    @Test
    fun `placeholder is displayed, input text is working correctly`() {
        composeTestRule.setContent {
            var input by remember {
                mutableStateOf("")
            }

            TravellerInputPasswordField(
                password = input,
                onPasswordChanged = {
                    input = it
                },
                modifier = Modifier.testTag(InputPasswordFieldTestTag),
                needToShowStrengthMeter = false,
                passwordSatisfiedRequirements = emptyList()
            )
        }

        composeTestRule.onNodeWithText("resources.getString(R.string.password_field)")
            .assertIsDisplayed()

        composeTestRule.onNodeWithTag(InputPasswordFieldTestTag).assertIsDisplayed()
        composeTestRule.onNodeWithTag(InputPasswordFieldTestTag).performClick()
        composeTestRule.onNodeWithTag(InputPasswordFieldTestTag).performTextInput("123")
        composeTestRule.onNodeWithText("123").assertExists()
        composeTestRule.onNodeWithText("123").assertIsNotDisplayed()

    }

    private val InputPasswordFieldTestTag = "TravellerInputPasswordFieldTestTag"
}