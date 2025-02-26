package com.github.artnehay.lunatv.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Screen {
    @Serializable
    data object Home : Screen()

    @Serializable
    class MovieDetail(val movieId: String) : Screen()
}