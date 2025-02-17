package com.baltajmn.features.home.presentation.screen

import androidx.lifecycle.ViewModel
import com.baltajmn.template.core.common.dispatchers.DispatcherProvider
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow

class HomeViewModel(
    dispatcherProvider: DispatcherProvider
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeState())
    val uiState: StateFlow<HomeState> = _uiState

    private val _event = Channel<Event>()
    val event = _event.receiveAsFlow()

}