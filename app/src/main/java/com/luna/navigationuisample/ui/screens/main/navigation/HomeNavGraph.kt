package com.luna.navigationuisample.ui.screens.main.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.luna.navigationuisample.ui.navigation.graphs.Destination
import com.luna.navigationuisample.ui.navigation.graphs.SecondNavGraph
import com.luna.navigationuisample.ui.navigation.navComposable
import com.luna.navigationuisample.ui.screens.main.home.HomeScreen
import com.luna.navigationuisample.ui.screens.main.other.AnotherScreen

fun NavGraphBuilder.homeNavGraph(
    onNavigate: (Destination) -> Unit
) {

    navigation(
        route = SecondNavGraph.Init.route,
        startDestination = SecondNavGraph.HomeScreen.route
    ) {

        navComposable(SecondNavGraph.HomeScreen) {
            HomeScreen(onNavigate = onNavigate)
        }

        navComposable(SecondNavGraph.AnotherScreen) {
            AnotherScreen(onNavigate = onNavigate)
        }
    }

}