package com.dimaklekchyan.wizardium.core.vm

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

abstract class BaseViewModel<ViewState, Action, Event>(
    initialState: ViewState
): ViewModel() {

    private val _viewStateFlow = MutableStateFlow(initialState)
    val viewStateFlow: StateFlow<ViewState> = _viewStateFlow

    private val _viewActionFlow = MutableSharedFlow<Action?>(
        replay = 0,
        extraBufferCapacity = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )
    val viewActionFlow: SharedFlow<Action?> = _viewActionFlow

    protected var viewState: ViewState
        get() = _viewStateFlow.value
        set(value) {
            _viewStateFlow.tryEmit(value)
        }
    var viewAction: Action?
        get() = _viewActionFlow.replayCache.firstOrNull()
        set(value) {
            viewModelScope.launch {
                _viewActionFlow.emit(value)
            }
        }

    protected val coroutineExceptionHandler =
        CoroutineExceptionHandler { _, throwable ->
            if (throwable !is CancellationException) {
            }
            onErrorOccurred(throwable)
        }

    abstract fun obtainEvent(viewEvent: Event)

    open fun onErrorOccurred(throwable: Throwable) {}

    protected fun launch(
        context: CoroutineContext = EmptyCoroutineContext,
        handler: CoroutineExceptionHandler = coroutineExceptionHandler,
        action: suspend () -> Unit,
    ) = viewModelScope.launch(
        context + handler,
    ) { action() }

    @Suppress("NonSkippableComposable")
    @Composable
    fun collectActions(collect: suspend (Action) -> Unit) {
        LaunchedEffect(viewActionFlow) {
            viewActionFlow.collect {
                it?.let { collect(it) }
            }
        }
    }

    @Composable
    fun collectState(): State<ViewState> {
        return viewStateFlow.collectAsState()
    }

    fun close() {
        viewModelScope.cancel()
    }
}