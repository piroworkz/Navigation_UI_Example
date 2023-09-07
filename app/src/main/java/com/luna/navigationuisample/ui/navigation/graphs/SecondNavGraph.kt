package com.luna.navigationuisample.ui.navigation.graphs

sealed class SecondNavGraph(
    route: String,
    defaultArgs: List<DefaultArgs<*>> = emptyList()
) : Destination(route = route, defaultArgs = defaultArgs) {

    object Init : SecondNavGraph(route = INIT)

    object HomeScreen : SecondNavGraph(
        route = HOME_SCREEN,
        defaultArgs = listOf(
            DefaultArgs.ShowBottomBar,
            DefaultArgs.ShowTopBar,
            DefaultArgs.TopBarTitle("Home Screen"),
        )
    )

    object AnotherScreen : SecondNavGraph(
        route = ANOTHER_SCREEN,
        defaultArgs = listOf(
            DefaultArgs.ShowBottomBar,
            DefaultArgs.TopBarTitle("Another Screen"),
        )
    )

    companion object {
        private const val INIT = "SECOND_GRAPH"
        private const val HOME_SCREEN = "HOME_SCREEN"
        private const val ANOTHER_SCREEN = "ANOTHER_SCREEN"
    }
}