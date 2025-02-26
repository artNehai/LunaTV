package com.github.artnehay.lunatv.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.github.artnehay.lunatv.presentation.screens.home.HomeScreen
import com.github.artnehay.lunatv.presentation.screens.moviedetail.MovieDetailScreen

@Composable
fun LunaTVNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home,
        modifier = modifier,
    ) {
        composable<Screen.Home> {
            HomeScreen(
                onMovieSelected = { id ->
                    navController.navigate(Screen.MovieDetail(id))
                }
            )
        }

        composable<Screen.MovieDetail> {
            MovieDetailScreen()
        }
    }
}