package com.modernunit.common.network

import app.cash.turbine.test
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class ResultKtTest {

    @Test
    fun `data got successfully, result will be Success`() = runTest {
        flow {
            emit(1)
        }.asResult().test {
            assertEquals(Result.Loading, awaitItem())
            assertEquals(Result.Success(1), awaitItem())
            awaitComplete()
        }
    }

    @Test
    fun `emitted error, result will be Error with given text`() = runTest {
        val exceptionErrorText = "Test exception"
        flow<Int> {
            throw Exception(exceptionErrorText)
        }.asResult().test {
            assertEquals(Result.Loading, awaitItem())
            assertEquals((awaitItem() as? Result.Error)?.exception?.message, exceptionErrorText)
            awaitComplete()
        }
    }
}
