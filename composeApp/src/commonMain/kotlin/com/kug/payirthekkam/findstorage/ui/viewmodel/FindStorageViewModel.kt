package com.kug.payirthekkam.findstorage.ui.viewmodel

import com.kug.payirthekkam.BaseViewModel

class FindStorageViewModel : BaseViewModel<FindStorageUiState, FindStorageUiEvent, FindStorageUiEffect>() {
    override fun onEvent(event: FindStorageUiEvent) {
        when (event) {
            //fooEvent -> doSomething
            else -> {}
        }
    }

    override fun initialState(): FindStorageUiState = FindStorageUiState.Idle

}

sealed class FindStorageUiState() {
    data object Loading : FindStorageUiState()
    data class Error(val message: String) : FindStorageUiState()
    data class Success(val data: Any) : FindStorageUiState()
    data object Idle : FindStorageUiState()
}


sealed class FindStorageUiEffect() {
    // one time effects to ui
}

sealed class FindStorageUiEvent() {
    // events from ui
}