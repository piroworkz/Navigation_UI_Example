package com.luna.navigationuisample.ui.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.luna.navigationuisample.ui.navigation.graphs.Destination

fun NavGraphBuilder.navComposable(
    destination: Destination,
    enterTransition: AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition? = { null },
    exitTransition: AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition? = { null },
    popEnterTransition: AnimatedContentTransitionScope<NavBackStackEntry>.() -> EnterTransition? = enterTransition,
    popExitTransition: AnimatedContentTransitionScope<NavBackStackEntry>.() -> ExitTransition? = exitTransition,
    content: @Composable (NavBackStackEntry) -> Unit,
) = composable(
    route = destination.getRoute(),
    arguments = destination.setDefaultArgs(),
    enterTransition = enterTransition,
    exitTransition = exitTransition,
    popEnterTransition = popEnterTransition,
    popExitTransition = popExitTransition
) { content(it) }

private fun Destination.getRoute(): String {
    return listOf(route)
        .plus(defaultArgs.map { "{${it.args.first}}" })
        .joinToString("/")
}

private fun Destination.setDefaultArgs(): List<NamedNavArgument> =
    defaultArgs.map {
        navArgument(name = it.args.first) {
            defaultValue = it.args.second
            type = it.args.third
        }
    }

fun NavHostController.navigateTo(
    destination: Destination,
    args: List<Any> = emptyList(),
    navOptionsBuilder: NavOptionsBuilder.() -> Unit = {
        popUpTo(destination.route) {
            inclusive = false
        }
        launchSingleTop = true
    }
) {
    navigate(
        route = destination.createRoute(args),
        builder = { navOptionsBuilder() }
    )
}

private fun Destination.createRoute(args: List<Any>): String {
    return listOf(route)
        .plus(defaultArgs.map { it.args.second })
        .plus(args)
        .joinToString("/")
}