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
import androidx.hilt.navigation.compose.hiltViewModel
import com.github.artnehay.lunatv.domain.model.Movie
import com.github.artnehay.lunatv.presentation.common.MovieRow

@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel = hiltViewModel(),
) {
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
                        posterUri = "https://www.vintagemovieposters.co.uk/wp-content/uploads/2018/12/IMG_3109-1024x678.jpeg",
                        name = "",
                        description = "",
                    ),
                    Movie(
                        id = "2",
                        videoUri = "",
                        subtitleUri = "",
                        posterUri = "https://www.vintagemovieposters.co.uk/wp-content/uploads/2018/12/IMG_3109-1024x678.jpeg",
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
                        posterUri = "https://www.vintagemovieposters.co.uk/wp-content/uploads/2018/12/IMG_3109-1024x678.jpeg",
                        name = "The hateful eight",
                        description = "",
                    ),
                    Movie(
                        id = "2",
                        videoUri = "",
                        subtitleUri = "",
                        posterUri = "https://www.vintagemovieposters.co.uk/wp-content/uploads/2018/12/IMG_3109-1024x678.jpeg",
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
                        posterUri = "https://www.vintagemovieposters.co.uk/wp-content/uploads/2018/12/IMG_3109-1024x678.jpeg",
                        name = "The hateful eight",
                        description = "",
                    ),
                    Movie(
                        id = "2",
                        videoUri = "",
                        subtitleUri = "",
                        posterUri = "https://www.vintagemovieposters.co.uk/wp-content/uploads/2018/12/IMG_3109-1024x678.jpeg",
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