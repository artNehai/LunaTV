package com.github.artnehay.lunatv.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.darkColorScheme
import androidx.tv.material3.lightColorScheme

@Composable
fun LunaTVTheme(
    isInDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colorScheme = if (isInDarkTheme) {
        darkColorScheme()
    } else {
        lightColorScheme()
    }
    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}