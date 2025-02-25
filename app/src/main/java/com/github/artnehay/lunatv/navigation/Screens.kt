package com.github.artnehay.lunatv.navigation

import kotlinx.serialization.Serializable

sealed class Screens {
    @Serializable
    data object Home : Screens()

    @Serializable
    class MovieDetail(val movieId: String) : Screens()
}