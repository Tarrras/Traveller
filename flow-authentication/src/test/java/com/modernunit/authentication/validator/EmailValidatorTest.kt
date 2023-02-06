package com.modernunit.authentication.validator

import com.modernunit.authentication.auth.validator.EmailValidationResult
import com.modernunit.authentication.auth.validator.validateEmail
import org.junit.Assert.assertEquals
import org.junit.Test

class EmailValidatorTest {
    @Test
    fun `email is empty, result will be empty email error`() {
        val emptyEmail = ""
        assertEquals(
            emptyEmail.validateEmail(),
            EmailValidationResult.EmptyValue
        )
    }

    @Test
    fun `invalid emails are given, the results will be error`() {
        assertEquals(
            "test".validateEmail(),
            EmailValidationResult.PatternValidationFailed
        )
        assertEquals(
            "test@".validateEmail(),
            EmailValidationResult.PatternValidationFailed
        )
        assertEquals(
            "test@dsds".validateEmail(),
            EmailValidationResult.PatternValidationFailed
        )
        assertEquals(
            "test@dsads@".validateEmail(),
            EmailValidationResult.PatternValidationFailed
        )
        assertEquals(
            "test.com".validateEmail(),
            EmailValidationResult.PatternValidationFailed
        )
    }

    @Test
    fun `valid emails are given, the results will be Valid`() {
        assertEquals(
            "test@gmail.com".validateEmail(),
            EmailValidationResult.Valid
        )
        assertEquals(
            "123@gmal.com".validateEmail(),
            EmailValidationResult.Valid
        )
    }
}

