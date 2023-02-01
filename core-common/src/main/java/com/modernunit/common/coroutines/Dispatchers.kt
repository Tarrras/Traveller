package com.modernunit.common.coroutines

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Dispatcher(val dispatcher: TravellerDispatchers)

enum class TravellerDispatchers {
    Main, IO
}