package com.baltajmn.features.article.presentation.screen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.baltajmn.template.core.common.dispatchers.DispatcherProvider
import com.baltajmn.template.core.common.model.Article
import com.google.gson.Gson
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update

class ArticleViewModel(
    savedStateHandle: SavedStateHandle,
    dispatcherProvider: DispatcherProvider
) : ViewModel() {

    private val articleJson: String = checkNotNull(savedStateHandle["articleJson"])


    private val _uiState = MutableStateFlow(State())
    val uiState: StateFlow<State> = _uiState

    private val _event = Channel<Event>()
    val event = _event.receiveAsFlow()

    init {
        _uiState.update { it.copy(article = Gson().fromJson(articleJson, Article::class.java)) }
    }

}