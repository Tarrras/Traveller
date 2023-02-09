package com.modernunit.authentication.validator

import com.modernunit.authentication.auth.validator.PasswordRequirement
import com.modernunit.authentication.auth.validator.validatePassword
import org.junit.Assert.assertEquals
import org.junit.Test

class PasswordValidationResultTest {
    @Test
    fun `password is empty, result will be empty password error`() {
        val emptyPassword = ""
        assertEquals(emptyPassword.validatePassword(), emptyList<PasswordRequirement>())
    }

    @Test
    fun `invalid passwords are given, the results will be error`() {
        assertEquals("123".validatePassword(), listOf(PasswordRequirement.NUMBER))
        assertEquals("1234".validatePassword(), listOf(PasswordRequirement.NUMBER))
        assertEquals(
            "124q".validatePassword(),
            listOf(PasswordRequirement.NUMBER, PasswordRequirement.ONE_LOWER_CASE)
        )
        assertEquals(
            "1231q_".validatePassword(),
            listOf(
                PasswordRequirement.NUMBER,
                PasswordRequirement.ONE_LOWER_CASE,
                PasswordRequirement.FOUR_CHARACTERS
            )
        )
        assertEquals(
            "wQ1".validatePassword(),
            listOf(
                PasswordRequirement.NUMBER,
                PasswordRequirement.ONE_UPPER_CASE,
                PasswordRequirement.ONE_LOWER_CASE
            )
        )
    }

    @Test
    fun `valid passwords are given, the results will be Valid`() {
        assertEquals("1234Qq".validatePassword(), PasswordRequirement.values().toList())
        assertEquals("1234Qwe".validatePassword(), PasswordRequirement.values().toList())
    }
}
