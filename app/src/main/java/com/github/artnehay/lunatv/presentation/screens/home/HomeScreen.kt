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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.github.artnehay.lunatv.presentation.common.MovieRow

@Composable
fun HomeScreen(
    onMovieSelected: (String) -> Unit,
    viewModel: HomeScreenViewModel = hiltViewModel(),
) {
    val lazyListState = rememberLazyListState()
    val rowHeight = LocalConfiguration.current.screenHeightDp / 3f
    val sections = viewModel.homeSections.collectAsStateWithLifecycle()

    LazyColumn(
        state = lazyListState,
        contentPadding = PaddingValues(bottom = 108.dp),
        modifier = Modifier.fillMaxSize(),
    ) {
        sections.value.forEach { section ->
            item {
                MovieRow(
                    movieList = section.movies,
                    title = stringResource(section.section.titleId),
                    onMovieSelected = { onMovieSelected(it.id) },
                    modifier = Modifier
                        .padding(start = 16.dp, top = 32.dp)
                        .height(rowHeight.dp),
                )
            }
        }
    }
}