package com.baltajmn.features.splash.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.baltajmn.template.core.design.components.LoadingView
import com.baltajmn.template.core.design.components.collectEvents
import kotlinx.coroutines.flow.collectLatest
import org.koin.androidx.compose.koinViewModel

@Composable
fun SplashScreen(
    viewModel: SplashViewModel = koinViewModel(),
    navigateToMainGraph: () -> Unit
) {
    collectEvents {
        viewModel.event.collectLatest {
            when (it) {
                is SplashViewModel.Event.NavigateToMainGraph -> navigateToMainGraph()
            }
        }
    }

    LaunchedEffect(key1 = Unit) {
        viewModel.checkConditions()
    }

    LoadingView()
}
