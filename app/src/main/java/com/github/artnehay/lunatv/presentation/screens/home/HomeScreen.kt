package com.github.artnehay.lunatv.presentation.screens.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.github.artnehay.lunatv.domain.model.Movie
import com.github.artnehay.lunatv.presentation.common.MovieRow

@Composable
fun HomeScreen() {
    val lazyListState = rememberLazyListState()
    val height = LocalConfiguration.current.screenHeightDp / 3f

    LazyColumn(
        state = lazyListState,
        contentPadding = PaddingValues(bottom = 108.dp),
        modifier = Modifier.fillMaxSize(),
    ) {
        item {
            MovieRow(
                movieList = listOf(
                    Movie(
                        id = "1",
                        videoUri = "",
                        subtitleUri = "The hateful eight",
                        posterUri = "https://indierevolver.com/wp-content/uploads/2015/12/hateful-eight-header-2-e1450230987265.png",
                        name = "",
                        description = "",
                    ),
                    Movie(
                        id = "2",
                        videoUri = "",
                        subtitleUri = "",
                        posterUri = "https://indierevolver.com/wp-content/uploads/2015/12/hateful-eight-header-2-e1450230987265.png",
                        name = "The hateful eight",
                        description = "",
                    ),
                ),
                title = "Home",
                onMovieSelected = {},
                modifier = Modifier
                    .padding(start = 16.dp, top = 32.dp)
                    .height(height.dp),
            )
        }
        item {
            MovieRow(
                movieList = listOf(
                    Movie(
                        id = "1",
                        videoUri = "",
                        subtitleUri = "",
                        posterUri = "https://indierevolver.com/wp-content/uploads/2015/12/hateful-eight-header-2-e1450230987265.png",
                        name = "The hateful eight",
                        description = "",
                    ),
                    Movie(
                        id = "2",
                        videoUri = "",
                        subtitleUri = "",
                        posterUri = "https://indierevolver.com/wp-content/uploads/2015/12/hateful-eight-header-2-e1450230987265.png",
                        name = "The hateful eight",
                        description = "",
                    ),
                ),
                title = "Home",
                onMovieSelected = {},
                modifier = Modifier
                    .padding(start = 16.dp, top = 32.dp)
                    .height(height.dp),
            )
        }
        item {
            MovieRow(
                movieList = listOf(
                    Movie(
                        id = "1",
                        videoUri = "",
                        subtitleUri = "",
                        posterUri = "https://indierevolver.com/wp-content/uploads/2015/12/hateful-eight-header-2-e1450230987265.png",
                        name = "The hateful eight",
                        description = "",
                    ),
                    Movie(
                        id = "2",
                        videoUri = "",
                        subtitleUri = "",
                        posterUri = "https://indierevolver.com/wp-content/uploads/2015/12/hateful-eight-header-2-e1450230987265.png",
                        name = "The hateful eight",
                        description = "",
                    ),
                ),
                title = "Home",
                onMovieSelected = {},
                modifier = Modifier
                    .padding(start = 16.dp, top = 32.dp)
                    .height(height.dp),
            )
        }
    }
}