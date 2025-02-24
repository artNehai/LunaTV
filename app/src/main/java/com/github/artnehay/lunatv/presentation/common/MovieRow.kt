package com.github.artnehay.lunatv.presentation.common

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.focusGroup
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.focusRestorer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.Text
import com.github.artnehay.lunatv.domain.model.Movie

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun MovieRow(
    movieList: List<Movie>,
    title: String,
    onMovieSelected: (movie: Movie) -> Unit,
    modifier: Modifier = Modifier,
) {
    val (lazyRow, firstItem) = remember { FocusRequester.createRefs() }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .focusGroup()
    ) {
        Text(
            text = title,
            modifier = Modifier.padding(start = 16.dp),
            style = MaterialTheme.typography.headlineLarge.copy(
                fontWeight = FontWeight.Medium,
                fontSize = 30.sp
            ),
        )

        Spacer(Modifier.height(16.dp))

        AnimatedContent(
            targetState = movieList,
        ) { movieState ->
            LazyRow(
                modifier = Modifier
                    .focusRequester(lazyRow)
                    .focusRestorer {
                        firstItem
                    },
                contentPadding = PaddingValues(
                    start = 16.dp,
                    end = 16.dp,
                ),
                horizontalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                itemsIndexed(movieState, key = { _, movie -> movie.id }) { index, movie ->
                    val itemModifier = if (index == 0) {
                        Modifier.focusRequester(firstItem)
                    } else {
                        Modifier
                    }

                    MovieCard(
                        movie = movie,
                        onClick = {
                            lazyRow.saveFocusedChild()
                            onMovieSelected(movie)
                        },
                        modifier = itemModifier.weight(1f),
                    )
                }
            }
        }
    }
}