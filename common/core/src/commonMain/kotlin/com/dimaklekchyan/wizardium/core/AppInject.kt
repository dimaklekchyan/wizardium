package com.dimaklekchyan.wizardium.core

import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.core.module.Module
import org.koin.core.parameter.parametersOf
import org.koin.core.qualifier.Qualifier
import org.koin.core.qualifier.TypeQualifier
import org.koin.core.scope.Scope
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

object AppInject {

    private var _di: KoinApplication? = null

    val di: KoinApplication
        get() = requireNotNull(_di)

    fun start(modules: List<Module>) {
        _di = startKoin { modules(modules) }
    }

    fun stop() {
        stopKoin()
    }

    @OptIn(ExperimentalUuidApi::class)
    inline fun <reified T: Any> createScope(): KoinInjectScope {
        val scope = di.koin.createScope(
            scopeId = Uuid.random().toString(),
            qualifier = TypeQualifier(T::class)
        )
        return KoinInjectScope(scope)
    }

    @OptIn(ExperimentalUuidApi::class)
    fun createScope(qualifier: Qualifier): KoinInjectScope {
        val scope = di.koin.createScope(
            scopeId = Uuid.random().toString(),
            qualifier = qualifier
        )
        return KoinInjectScope(scope)
    }

    inline fun <reified T: Any> get(
        param: Any? = null
    ):T {
        return di.koin.get<T> { parametersOf(param) }
    }
}

class KoinInjectScope(val scope: Scope) {
    inline fun <reified T: Any> get(
        vararg params: Any = emptyArray()
    ):T {
        return scope.get<T> { parametersOf(params) }
    }

    fun close() { scope.close() }
}