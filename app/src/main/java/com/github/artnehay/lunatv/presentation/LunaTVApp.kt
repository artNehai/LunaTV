package com.github.artnehay.lunatv.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.Icon
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.NavigationDrawer
import androidx.tv.material3.NavigationDrawerItem
import androidx.tv.material3.Text
import com.github.artnehay.lunatv.navigation.LunaTVNavHost
import com.github.artnehay.lunatv.navigation.topLevelScreens

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun LunaTVApp() {

    val navController = rememberNavController()
    val currentDestination = navController.currentBackStackEntryAsState().value?.destination

    NavigationDrawer(
        drawerContent = {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(12.dp)
                    .selectableGroup(),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.spacedBy(
                    space = 10.dp,
                    alignment = Alignment.CenterVertically,
                ),
            ) {
                topLevelScreens.forEach { topLevelScreen ->
                    NavigationDrawerItem(
                        selected = currentDestination?.hierarchy
                            ?.any { it.hasRoute(topLevelScreen.screen::class) } == true,
                        onClick = { navController.navigate(topLevelScreen.screen) },
                        leadingContent = {
                            Icon(
                                imageVector = topLevelScreen.icon,
                                contentDescription = null,
                            )
                        }
                    ) {
                        Text(
                            text = stringResource(topLevelScreen.label),
                            style = MaterialTheme.typography.bodyLarge,
                        )
                    }
                }
            }
        }
    ) {
        LunaTVNavHost(
            navController = navController,
            modifier = Modifier.fillMaxSize(),
        )
    }
}