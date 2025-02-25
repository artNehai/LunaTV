package com.github.artnehay.lunatv.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.github.artnehay.lunatv.presentation.screens.home.HomeScreen
import com.github.artnehay.lunatv.presentation.screens.moviedetail.MovieDetailScreen

@Composable
fun LunaTVNavHost(
    modifier: Modifier = Modifier,
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screens.Home,
        modifier = modifier,
    ) {
        composable<Screens.Home> {
            HomeScreen(
                onMovieSelected = { id ->
                    navController.navigate(Screens.MovieDetail(id))
                }
            )
        }

        composable<Screens.MovieDetail> {
            MovieDetailScreen()
        }
    }
}