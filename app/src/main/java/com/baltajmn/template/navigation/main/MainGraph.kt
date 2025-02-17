package com.baltajmn.template.navigation.main

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import com.baltajmn.template.core.navigation.GRAPH
import com.baltajmn.template.ui.AppState

@Composable
fun MainGraph(
    appState: AppState
) {
    NavHost(
        navController = appState.mainNavController,
        route = GRAPH.Main,
        startDestination = com.baltajmn.template.core.navigation.MainGraph.Home.route
    ) {

    }
}