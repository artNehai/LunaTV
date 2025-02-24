package com.github.artnehay.lunatv.presentation.common

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.tv.material3.Border
import androidx.tv.material3.CardDefaults
import androidx.tv.material3.CompactCard
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.ShapeDefaults
import androidx.tv.material3.Text
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.github.artnehay.lunatv.domain.model.Movie

@Composable
fun MovieCard(
    movie: Movie,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    CompactCard(
        onClick = onClick,
        image = {
            AsyncImage(
                modifier = modifier.aspectRatio(16f / 9f),
                model = ImageRequest.Builder(LocalContext.current)
                    .crossfade(true)
                    .data(movie.posterUri)
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        },
        title = {
            Text(
                text = movie.name,
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontWeight = FontWeight.SemiBold
                ),
                textAlign = TextAlign.Start,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(start = 4.dp, bottom = 4.dp),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        },
        modifier = modifier,
        scale = CardDefaults.scale(focusedScale = 1.3f),
        border = CardDefaults.border(
            focusedBorder = Border(
                border = BorderStroke(
                    width = 3.dp,
                    color = MaterialTheme.colorScheme.onSurface
                ),
                shape = ShapeDefaults.ExtraSmall,
            )
        ),
    )
}