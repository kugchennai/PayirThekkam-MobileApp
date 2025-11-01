package com.kug.payirthekkam.feature.ui.viewmodel

import com.kug.payirthekkam.BaseViewModel

class FeatureViewModel : BaseViewModel<FeatureUiState, FeatureUiEvent, FeatureUiEffect>() {
    override fun onEvent(event: FeatureUiEvent) {
        when (event) {
            //fooEvent -> doSomething
            else -> {}
        }
    }

    override fun initialState(): FeatureUiState = FeatureUiState.Idle

}

sealed class FeatureUiState() {
    data object Loading : FeatureUiState()
    data class Error(val message: String) : FeatureUiState()
    data class Success(val data: Any) : FeatureUiState()
    data object Idle : FeatureUiState()
}


sealed class FeatureUiEffect() {
    // one time effects to ui
}

sealed class FeatureUiEvent() {
    // events from ui
}