package com.luna.navigationuisample.ui.navigation.graphs

sealed class Destination(
    val route: String,
    val defaultArgs: List<DefaultArgs<*>> = emptyList(),
)
