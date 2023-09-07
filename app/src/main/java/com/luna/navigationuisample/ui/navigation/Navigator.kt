package com.luna.navigationuisample.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import com.luna.navigationuisample.ui.navigation.composables.AppBottomNavBar
import com.luna.navigationuisample.ui.navigation.composables.AppTopBar
import com.luna.navigationuisample.ui.navigation.graphs.DefaultArgs
import com.luna.navigationuisample.ui.navigation.graphs.DefaultArgs.ShowBottomBar
import com.luna.navigationuisample.ui.navigation.graphs.DefaultArgs.ShowTopBar
import com.luna.navigationuisample.ui.navigation.graphs.FirstNavGraph
import com.luna.navigationuisample.ui.screens.auth.navigation.authNavGraph
import com.luna.navigationuisample.ui.screens.main.navigation.homeNavGraph

@Composable
fun Navigator(navController: NavHostController) {

    var isBottomBarVisible by remember { mutableStateOf(false) }
    var isTopBarVisible by remember { mutableStateOf(false) }
    var appTopBarTitle by remember { mutableStateOf("App Title") }

    navController.currentBackStackEntryAsState().value?.arguments?.let {
        isBottomBarVisible = it.getBoolean(ShowBottomBar.args.first, false)
        isTopBarVisible = it.getBoolean(ShowTopBar.args.first, false)
        appTopBarTitle = it.getString(DefaultArgs.TopBarTitle::title.name, "App Title")
    }

    Scaffold(
        bottomBar = {
            AppBottomNavBar(
                isVisible = isBottomBarVisible,
                onNavigate = navController::navigateTo
            )
        },
        topBar = {
            AppTopBar(
                isVisible = isTopBarVisible,
                title = appTopBarTitle,
                onNavigationIconClick = { navController.popBackStack() }
            )
        }
    ) {
        NavHost(
            navController = navController,
            startDestination = FirstNavGraph.Init.route,
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            contentAlignment = Alignment.Center
        ) {

            authNavGraph(
                onNavigateFromSplash = { dest -> enterApp(navController, dest) },
                onNavigate = navController::navigateTo
            )

            homeNavGraph(onNavigate = navController::navigateTo)
        }
    }
}
