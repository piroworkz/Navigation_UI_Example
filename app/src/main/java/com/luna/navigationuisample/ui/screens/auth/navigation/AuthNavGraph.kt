package com.luna.navigationuisample.ui.screens.auth.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.luna.navigationuisample.ui.navigation.graphs.Destination
import com.luna.navigationuisample.ui.navigation.graphs.FirstNavGraph
import com.luna.navigationuisample.ui.navigation.navComposable
import com.luna.navigationuisample.ui.screens.auth.login.LoginScreen
import com.luna.navigationuisample.ui.screens.auth.recoverpass.RecoverPassScreen
import com.luna.navigationuisample.ui.screens.auth.splash.SplashScreen

fun NavGraphBuilder.authNavGraph(
    onNavigateFromSplash: (Destination) -> Unit,
    onNavigate: (Destination) -> Unit,
) {
    navigation(
        startDestination = FirstNavGraph.Splash.route,
        route = FirstNavGraph.Init.route
    ) {

        navComposable(FirstNavGraph.Splash) {
            SplashScreen { onNavigateFromSplash(FirstNavGraph.AuthScreen) }
        }

        navComposable(FirstNavGraph.AuthScreen) {
            LoginScreen(onNavigate)
        }

        navComposable(FirstNavGraph.RecoverPass) {
            RecoverPassScreen(onNavigate = onNavigate)
        }
    }

}