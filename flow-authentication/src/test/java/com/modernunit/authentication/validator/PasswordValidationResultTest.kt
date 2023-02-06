package com.modernunit.authentication.validator

import com.modernunit.authentication.auth.validator.PasswordValidationResult
import com.modernunit.authentication.auth.validator.validatePassword
import org.junit.Assert.assertEquals
import org.junit.Test

class PasswordValidationResultTest {
    @Test
    fun `password is empty, result will be empty password error`() {
        val emptyPassword = ""
        assertEquals(emptyPassword.validatePassword(), PasswordValidationResult.EmptyValue)
    }

    @Test
    fun `invalid passwords are given, the results will be error`() {
        assertEquals("123".validatePassword(), PasswordValidationResult.PatternValidationFailed)
        assertEquals("1234".validatePassword(), PasswordValidationResult.PatternValidationFailed)
        assertEquals("124q".validatePassword(), PasswordValidationResult.PatternValidationFailed)
        assertEquals("1231q_".validatePassword(), PasswordValidationResult.PatternValidationFailed)
        assertEquals("wQ1".validatePassword(), PasswordValidationResult.PatternValidationFailed)
    }

    @Test
    fun `valid passwords are given, the results will be Valid`() {
        assertEquals("1234Qq".validatePassword(), PasswordValidationResult.Valid)
        assertEquals("1234Qwe".validatePassword(), PasswordValidationResult.Valid)
    }
}