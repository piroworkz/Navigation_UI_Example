package com.luna.navigationuisample.ui.navigation.graphs

import androidx.navigation.NavType

sealed class Args(val args: Pair<String, NavType<*>>) {
    object ItemId : Args("id" to NavType.IntType)
}