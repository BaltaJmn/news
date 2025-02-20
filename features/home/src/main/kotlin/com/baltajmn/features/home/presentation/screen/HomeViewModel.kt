package com.baltajmn.features.home.presentation.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.baltajmn.features.home.domain.GetNewsUseCase
import com.baltajmn.template.core.common.dispatchers.DispatcherProvider
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    dispatcherProvider: DispatcherProvider,
    private val getNews: GetNewsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeState())
    val uiState: StateFlow<HomeState> = _uiState

    private val _event = Channel<Event>()
    val event = _event.receiveAsFlow()

    init {
        viewModelScope.launch {
            _uiState.update { it.copy(articles = getNews()) }
        }
    }

}