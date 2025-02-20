package com.baltajmn.template.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.baltajmn.features.home.presentation.screen.HomeScreen
import com.baltajmn.features.preferences.presentation.screen.PreferencesScreen
import com.baltajmn.features.splash.presentation.screen.SplashScreen
import com.baltajmn.template.core.design.components.BottomNavBar
import com.baltajmn.template.core.design.components.BottomNavBarItem
import com.baltajmn.template.core.design.components.isScrollingUp
import com.baltajmn.template.core.navigation.GRAPH
import com.baltajmn.template.core.navigation.GRAPH.PreMain
import com.baltajmn.template.core.navigation.MainGraph
import com.baltajmn.template.core.navigation.PreMainGraph.Preferences
import com.baltajmn.template.core.navigation.PreMainGraph.Splash

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
                navigateToMainGraph = { appState.navigateToMainGraph() },
                navigateToPreferences = { appState.navigateToPreferences() }
            )
        }

        composable(
            route = Preferences.route
        ) {
            PreferencesScreen(
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
    var screenRoute by remember { mutableStateOf(BottomNavBarItem.Home) }
    val currentRoute = appState.currentRoute

    val homeListState = rememberLazyListState()
    val settingsListState = rememberLazyListState()

    val isHomeScrolling = homeListState.isScrollingUp()
    val isSettingsScrolling = settingsListState.isScrollingUp()

    val shouldShow = isHomeScrolling && isSettingsScrolling

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
                route = MainGraph.Settings.route
            ) {
                //HomeScreen(listState = homeListState)
            }
        }
    }
}