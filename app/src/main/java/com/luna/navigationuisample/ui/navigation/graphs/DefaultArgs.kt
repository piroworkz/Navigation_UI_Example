package com.luna.navigationuisample.ui.navigation.graphs

import androidx.navigation.NavType

sealed class DefaultArgs<T>(val args: Triple<String, T, NavType<*>>) {
    object ShowBottomBar :
        DefaultArgs<Boolean>(Triple(SHOW_BOTTOM_BAR, true, NavType.BoolType))

    object ShowTopBar :
        DefaultArgs<Boolean>(Triple(SHOW_TOP_BAR, true, NavType.BoolType))

    data class TopBarTitle(val title: String) :
        DefaultArgs<String>(Triple(TOP_BAR_TITLE, title, NavType.StringType))

    data class NavIcon(val icon: Int) :
        DefaultArgs<Int>(Triple(NAV_ICON, icon, NavType.IntType))

    companion object {
        private const val SHOW_BOTTOM_BAR = "SHOW_BOTTOM_BAR"
        private const val SHOW_TOP_BAR = "SHOW_TOP_BAR"
        private const val TOP_BAR_TITLE = "title"
        private const val NAV_ICON = "NAV_ICON"
    }
}