package com.baltajmn.template.navigation.main

import android.annotation.SuppressLint
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.baltajmn.template.core.design.components.BottomNavBar
import com.baltajmn.template.core.design.components.isScrollingUp
import com.baltajmn.template.ui.AppState

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(
    appState: AppState
) {
    val currentRoute = appState.currentRoute
    val appLazyListState = rememberLazyListState()
    val isAppScrolling = appLazyListState.isScrollingUp()


    Scaffold(
        bottomBar = {
            BottomNavBar(
                shouldShow = { isAppScrolling },
                currentRoute = { currentRoute },
                onSelectedItem = {
                    if (currentRoute != it.getScreenRoute()) {
                        appState.bottomNavigationTo(it)
                    }
                }
            )
        }
    ) { _ ->
        MainGraph(appState = appState)
    }
}