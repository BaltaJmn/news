package com.baltajmn.features.home.presentation.screen

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.baltajmn.template.core.design.components.LoadingView
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = koinViewModel(),
    listState: LazyListState
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    AnimatedContent(
        targetState = state.isLoading,
        label = ""
    ) {
        when (it) {
            true -> LoadingView()
            false -> Content(
                state = state,
                listState = listState
            )
        }
    }
}

@Composable
private fun Content(
    state: HomeState,
    listState: LazyListState
) {
    // Content
}
