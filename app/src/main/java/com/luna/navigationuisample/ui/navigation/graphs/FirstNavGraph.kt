package com.luna.navigationuisample.ui.navigation.graphs

sealed class FirstNavGraph(
    route: String,
    defaultArgs: List<DefaultArgs<*>> = emptyList()
) : Destination(route = route, defaultArgs = defaultArgs) {
    object Init : FirstNavGraph(route = INIT)

    object Splash : FirstNavGraph(route = SPLASH_SCREEN)

    object AuthScreen : FirstNavGraph(
        route = AUTH_SCREEN,
        defaultArgs = listOf(
            DefaultArgs.ShowBottomBar,
            DefaultArgs.ShowTopBar,
            DefaultArgs.TopBarTitle("Auth Screen"),
        )
    )

    object RecoverPass : FirstNavGraph(
        route = RECOVER_PASS,
        defaultArgs = listOf(
            DefaultArgs.ShowTopBar,
            DefaultArgs.TopBarTitle("Recover Password"),
        )
    )


    companion object {
        private const val INIT = "FIRST_GRAPH"
        private const val SPLASH_SCREEN = "SPLASH_SCREEN"
        private const val AUTH_SCREEN = "AUTH_SCREEN"
        private const val RECOVER_PASS = "RECOVER_PASS"
    }
}