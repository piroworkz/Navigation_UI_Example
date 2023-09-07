package com.luna.navigationuisample.ui.screens.auth.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.luna.navigationuisample.ui.navigation.graphs.Destination
import com.luna.navigationuisample.ui.navigation.graphs.FirstNavGraph
import com.luna.navigationuisample.ui.navigation.graphs.SecondNavGraph

@Composable
fun LoginScreen(
    onNavigate: (Destination) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Login Screen",
            fontSize = 30.sp,
            fontWeight = FontWeight.Black
        )

        Button(onClick = { onNavigate(SecondNavGraph.HomeScreen) }) {
            Text(text = "Login")
        }

        Button(onClick = { onNavigate(FirstNavGraph.RecoverPass) }) {
            Text(text = "Recover Password")
        }
    }
}