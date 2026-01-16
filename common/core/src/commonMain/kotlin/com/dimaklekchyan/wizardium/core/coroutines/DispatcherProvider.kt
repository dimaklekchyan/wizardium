package ru.travelata.core.coroutines

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import org.koin.core.module.Module

interface DispatcherProvider {
    val main: CoroutineDispatcher
    val default: CoroutineDispatcher
    val io: CoroutineDispatcher
    val unconfined: CoroutineDispatcher
}

class DefaultDispatcherProvider : DispatcherProvider {
    override val main = Dispatchers.Main
    override val default = Dispatchers.Default
    override val io = Dispatchers.IO
    override val unconfined = Dispatchers.Unconfined
}

class TestDispatcherProvider(testDispatcher: CoroutineDispatcher): DispatcherProvider {
    override val main = testDispatcher
    override val default = testDispatcher
    override val io = testDispatcher
    override val unconfined = testDispatcher
}

internal fun Module.provideDispatcherProvider() {
    single<DispatcherProvider> { DefaultDispatcherProvider() }
}