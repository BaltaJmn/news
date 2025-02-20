package com.baltajmn.template.ui

import android.content.Context
import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.baltajmn.template.core.common.model.Article
import com.baltajmn.template.core.design.components.BottomNavBarItem
import com.baltajmn.template.core.navigation.GRAPH
import com.baltajmn.template.core.navigation.MainGraph
import com.baltajmn.template.core.navigation.PreMainGraph
import com.baltajmn.template.core.navigation.extensions.navigateAndPop
import com.baltajmn.template.core.navigation.extensions.navigatePoppingUpToStartDestination
import com.google.gson.Gson

@Composable
fun rememberAppState(
    authNavController: NavHostController = rememberNavController(),
    mainNavController: NavHostController = rememberNavController(),
    context: Context = LocalContext.current
) = remember(authNavController, mainNavController, context) {
    AppState(authNavController, mainNavController, context)
}

@Stable
class AppState(
    val preMainNavController: NavHostController,
    val mainNavController: NavHostController,
    private val context: Context
) {

    val currentRoute: String
        @Composable get() = mainNavController.currentBackStackEntryAsState().value?.destination?.route
            ?: ""

    fun navigateToPreferences() {
        preMainNavController.navigatePoppingUpToStartDestination(PreMainGraph.Preferences.route)
    }

    fun navigateToMainGraph() {
        preMainNavController.popBackStack()
        preMainNavController.navigateAndPop(GRAPH.Main)
    }

    fun navigateUp() {
        mainNavController.navigateUp()
    }

    fun bottomNavigationTo(bottomNavBarItem: BottomNavBarItem) {
        when (bottomNavBarItem) {
            BottomNavBarItem.Home -> navigateToHome()
            BottomNavBarItem.Top -> navigateToTop()
            BottomNavBarItem.Settings -> navigateToSettings()
        }
    }

    fun navigateToArticle(article: Article) {
        mainNavController.navigate(
            MainGraph.Article.route.replace(
                "{articleJson}", Uri.encode(Gson().toJson(article))
            )
        )
    }

    private fun navigateToHome() {
        mainNavController.navigatePoppingUpToStartDestination(MainGraph.Home.route)
    }

    private fun navigateToTop() {
        mainNavController.navigatePoppingUpToStartDestination(MainGraph.Top.route)
    }

    private fun navigateToSettings() {
        mainNavController.navigatePoppingUpToStartDestination(MainGraph.Settings.route)
    }
}