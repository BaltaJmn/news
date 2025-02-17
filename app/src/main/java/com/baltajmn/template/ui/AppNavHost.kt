package com.baltajmn.template.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalConfiguration
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.baltajmn.template.core.design.components.BottomNavBar
import com.baltajmn.template.core.design.components.BottomNavBarItem
import com.baltajmn.template.core.design.components.isScrollingUp
import com.baltajmn.template.core.navigation.GRAPH
import com.baltajmn.template.core.navigation.GRAPH.PreMain
import com.baltajmn.template.core.navigation.MainGraph
import com.baltajmn.template.core.navigation.PreMainGraph.Splash
import com.baltajmn.features.home.presentation.screen.HomeScreen
import com.baltajmn.features.splash.presentation.screen.SplashScreen

fun NavGraphBuilder.preMainNavGraph(
    appState: AppState
) {
    navigation(
        route = PreMain,
        startDestination = Splash.route
    ) {
        composable(
            route = Splash.route
        ) {
            SplashScreen(
                navigateToMainGraph = { appState.navigateToMainGraph() }
            )
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainNavGraph(
    appState: AppState
) {
    val configuration = LocalConfiguration.current

    var screenRoute by remember { mutableStateOf(BottomNavBarItem.Home) }
    val currentRoute = appState.currentRoute

    val homeListState = rememberLazyListState()
    val shouldShow = homeListState.isScrollingUp()

    Scaffold(
        bottomBar = {
            BottomNavBar(
                shouldShow = { shouldShow },
                currentRoute = { currentRoute },
                onSelectedItem = {
                    screenRoute = it
                    appState.bottomNavigationTo(it)
                }
            )
        }
    ) { _ ->
        NavHost(
            navController = appState.mainNavController,
            route = GRAPH.Main,
            startDestination = MainGraph.Home.route
        ) {
            composable(
                route = MainGraph.Home.route
            ) {
                HomeScreen(listState = homeListState)
            }

            composable(
                route = MainGraph.Top.route
            ) {
                HomeScreen(listState = homeListState)
            }

            composable(
                route = MainGraph.Settings.route
            ) {
                HomeScreen(listState = homeListState)
            }
        }
    }
}