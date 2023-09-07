package com.luna.navigationuisample.ui.navigation.composables

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.luna.navigationuisample.ui.theme.NavigationUISampleTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    isVisible: Boolean,
    title: String,
    onNavigationIconClick: () -> Unit
) {

    if (!isVisible) return

    TopAppBar(
        title = { Text(text = title) },
        navigationIcon = {
            IconButton(
                onClick = onNavigationIconClick
            ) {
                Icon(imageVector = Icons.Outlined.ArrowBack, contentDescription = "Back Button")
            }
        },
        colors = topAppBarColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer
        )
    )
}

@Preview
@Composable
fun TopBarPreview() {
    NavigationUISampleTheme {
        AppTopBar(isVisible = true, title = "APP BAR TITLE") {
        }
    }
}