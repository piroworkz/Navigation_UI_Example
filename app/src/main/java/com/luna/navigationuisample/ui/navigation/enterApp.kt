package com.luna.navigationuisample.ui.navigation

import androidx.navigation.NavHostController
import com.luna.navigationuisample.ui.navigation.graphs.Destination
import com.luna.navigationuisample.ui.navigation.graphs.FirstNavGraph

fun enterApp(
    navHostController: NavHostController,
    dest: Destination
) {
    navHostController.navigateTo(dest) {
        popUpTo(FirstNavGraph.Splash.route) { inclusive = true }
        launchSingleTop = true
    }
}