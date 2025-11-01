package com.kug.payirthekkam

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<UiState, UiEvent, UiEffect> : ViewModel() {
    // State (for UI observation)
    protected val _uiState: MutableStateFlow<UiState> by lazy { MutableStateFlow(initialState()) }
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    // One-time UI effects (e.g., Toasts, Navigation)
    private val _uiEffect = MutableSharedFlow<UiEffect?>(replay = 0, extraBufferCapacity = 1)
    val uiEffect = _uiEffect.asSharedFlow()

    // Expose way to update state
    protected fun setState(reducer: UiState.() -> UiState) {
        _uiState.value = _uiState.value.reducer()
    }

    // Emit UI Effects
    protected fun sendEffect(effect: UiEffect) {
        viewModelScope.launch {
            _uiEffect.emit(effect)
        }
    }

    fun resetUiState() {
        _uiState.value = initialState()
    }

    // Handle UI events
    abstract fun onEvent(event: UiEvent)

    // Provide initial state
    abstract fun initialState(): UiState

    companion object {
        const val STAGE = "stage"
    }
}