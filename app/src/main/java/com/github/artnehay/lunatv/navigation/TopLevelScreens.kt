package com.github.artnehay.lunatv.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector
import com.github.artnehay.lunatv.R

data class TopLevelScreen<T : Any>(
    val screen: T,
    val icon: ImageVector,
    @StringRes val label: Int,
)

val topLevelScreens = listOf(
    TopLevelScreen(
        screen = Screen.Home,
        icon = Icons.Default.Home,
        label = R.string.home_nav_label,
    ),
)