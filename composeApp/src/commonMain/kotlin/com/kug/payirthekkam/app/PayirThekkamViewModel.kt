package com.kug.payirthekkam.app

import com.kug.payirthekkam.BaseViewModel

class PayirThekkamViewModel :
    BaseViewModel<PayirThekkamUiState, PayirThekkamUiEvent, PayirThekkamUiEffect>() {
    override fun onEvent(event: PayirThekkamUiEvent) {
        when (event) {
            else -> {}
        }
    }

    override fun initialState(): PayirThekkamUiState = PayirThekkamUiState.Idle
}

sealed class PayirThekkamUiState() {
    data object Loading : PayirThekkamUiState()
    data class Error(val message: String) : PayirThekkamUiState()
    data class Success(val data: Any) : PayirThekkamUiState()
    data object Idle : PayirThekkamUiState()
}


sealed class PayirThekkamUiEvent() {
    // one time effects to ui
}

sealed class PayirThekkamUiEffect() {
    // events from ui
}