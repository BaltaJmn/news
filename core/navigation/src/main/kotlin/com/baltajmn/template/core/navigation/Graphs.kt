package com.baltajmn.template.core.navigation

object GRAPH {
    val Root = "root_graph"
    val PreMain = "auth_graph"
    val Main = "main_graph"
}

enum class PreMainGraph(val route: String) {
    Splash("splash")
}

enum class MainGraph(val route: String) {
    Home("home"),
    Top("top"),
    Settings("settings")
}