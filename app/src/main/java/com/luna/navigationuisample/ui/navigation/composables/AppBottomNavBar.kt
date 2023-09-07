package com.luna.navigationuisample.ui.navigation.composables

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import com.luna.navigationuisample.ui.navigation.graphs.Destination
import com.luna.navigationuisample.ui.navigation.graphs.SecondNavGraph
import com.luna.navigationuisample.ui.theme.NavigationUISampleTheme

private val menu: List<Pair<Destination, ImageVector>> = listOf(
    SecondNavGraph.HomeScreen to Icons.Outlined.Home,
    SecondNavGraph.AnotherScreen to Icons.Outlined.AccountCircle,
    SecondNavGraph.HomeScreen to Icons.Outlined.Check,
    SecondNavGraph.AnotherScreen to Icons.Outlined.Call
)

@Composable
fun AppBottomNavBar(
    isVisible: Boolean,
    onNavigate: (Destination) -> Unit,
) {
    if (!isVisible) return

    BottomAppBar(
        actions = {
            menu.forEach { menuItem ->
                BottomNavigationItem(
                    menuItem = menuItem,
                    onNavigate = onNavigate
                )
            }
        },
        containerColor = MaterialTheme.colorScheme.secondaryContainer
    )
}

@Composable
fun RowScope.BottomNavigationItem(
    menuItem: Pair<Destination, ImageVector>,
    onNavigate: (Destination) -> Unit
) {
    IconButton(
        onClick = { onNavigate(menuItem.first) },
        modifier = Modifier.weight(1F)
    ) {
        Icon(imageVector = menuItem.second, contentDescription = menuItem.second.name)
    }
}

@Preview
@Composable
fun MenuPreview() {
    NavigationUISampleTheme {
        AppBottomNavBar(isVisible = true, onNavigate = {})
    }
}