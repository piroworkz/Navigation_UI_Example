package com.luna.navigationuisample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.luna.navigationuisample.ui.navigation.Navigator
import com.luna.navigationuisample.ui.theme.NavigationUISampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavigationUISampleTheme {
                Navigator(navController = navController)
            }
        }
    }
}