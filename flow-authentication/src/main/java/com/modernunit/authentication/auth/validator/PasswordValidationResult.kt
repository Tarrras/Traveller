package com.modernunit.authentication.auth.validator

import androidx.annotation.StringRes
import com.modernunit.authentication.R

enum class PasswordRequirement(
    @StringRes val requirementRes: Int
) {
    NUMBER(R.string.requirement_at_least_one_digit_password),
    ONE_UPPER_CASE(R.string.requirement_at_least_one_uppercase_letter_password),
    ONE_LOWER_CASE(R.string.requirement_at_least_one_lowercase_letter_password),
    FOUR_CHARACTERS(R.string.requirement_longer_than_x_password)
}

fun String.validatePassword(): List<PasswordRequirement> {
    val satisfiedRequirements = mutableListOf<PasswordRequirement>()
    if (any { it.isDigit() }) satisfiedRequirements.add(PasswordRequirement.NUMBER)
    if (any { it.isLowerCase() }) satisfiedRequirements.add(PasswordRequirement.ONE_LOWER_CASE)
    if (any { it.isUpperCase() }) satisfiedRequirements.add(PasswordRequirement.ONE_UPPER_CASE)
    if (length > 4) satisfiedRequirements.add(PasswordRequirement.FOUR_CHARACTERS)
    return satisfiedRequirements.toList()
}

private const val PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{5,}$"
