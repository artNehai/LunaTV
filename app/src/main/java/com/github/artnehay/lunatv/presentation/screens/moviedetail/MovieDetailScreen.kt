package com.github.artnehay.lunatv.presentation.screens.moviedetail

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.tv.material3.Button
import androidx.tv.material3.ButtonDefaults
import androidx.tv.material3.Icon
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.ShapeDefaults
import androidx.tv.material3.Text
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.github.artnehay.lunatv.R

@OptIn(ExperimentalFoundationApi::class, ExperimentalComposeUiApi::class)
@Composable
fun MovieDetailScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        val surfaceColor = MaterialTheme.colorScheme.surface
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data("https://www.vintagemovieposters.co.uk/wp-content/uploads/2018/12/IMG_3109-1024x678.jpeg")
                .crossfade(true).build(),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .drawWithContent {
                    drawContent()
                    drawRect(
                        Brush.linearGradient(
                            colors = listOf(Color.Transparent, surfaceColor),
                            start = Offset(x = 500f, y = 500f),
                            end = Offset(x = 0f, y = 1000f),
                        )
                    )
                },
            contentScale = ContentScale.Crop,
        )

        Column(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(start = 24.dp),
        ) {
            Text(
                text = "movieTitle",
                style = MaterialTheme.typography.displayMedium.copy(
                    fontWeight = FontWeight.Bold,
                ),
                maxLines = 1,
            )

            Text(
                text = "description",
                style = MaterialTheme.typography.titleSmall.copy(
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Normal,
                ),
                modifier = Modifier.padding(top = 8.dp),
                maxLines = 2,
            )

            val focusRequester = remember { FocusRequester() }
            LaunchedEffect(Unit) { focusRequester.requestFocus() }

            Button(
                onClick = {},
                modifier = Modifier
                    .padding(top = 24.dp, bottom = 40.dp)
                    .focusRequester(focusRequester),
                contentPadding = ButtonDefaults.ButtonWithIconContentPadding,
                shape = ButtonDefaults.shape(ShapeDefaults.Large),
            ) {
                Icon(
                    imageVector = Icons.Outlined.PlayArrow,
                    contentDescription = null,
                )

                Spacer(Modifier.size(8.dp))

                Text(
                    text = stringResource(R.string.watch_trailer),
                    style = MaterialTheme.typography.titleSmall,
                )
            }
        }
    }
}