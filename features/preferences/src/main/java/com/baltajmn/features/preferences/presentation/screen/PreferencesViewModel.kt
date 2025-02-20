package com.baltajmn.features.preferences.presentation.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.baltajmn.template.core.common.dispatchers.DispatcherProvider
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class PreferencesViewModel(
    dispatcherProvider: DispatcherProvider
) : ViewModel() {


    private val _event = Channel<Event>()
    val event = _event.receiveAsFlow()

    fun checkConditions() {
        viewModelScope.launch {
            _event.send(Event.NavigateToMainGraph)
        }
    }

    sealed interface Event {
        data object NavigateToMainGraph : Event
    }

}