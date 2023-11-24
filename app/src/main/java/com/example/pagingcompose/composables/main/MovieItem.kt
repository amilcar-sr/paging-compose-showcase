package com.example.pagingcompose.composables.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.pagingcompose.R
import com.example.pagingcompose.data.model.Movie
import java.time.Month
import java.time.format.TextStyle
import java.util.Locale

@Composable
fun MovieItem(
    movie: Movie
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
        ) {
            AsyncImage(
                model = movie.primaryImage?.url,
                contentDescription = null,
                placeholder = painterResource(R.drawable.ic_movie),
                error = painterResource(R.drawable.ic_broken_image),
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .width(80.dp)
                    .height(100.dp)
                    .clip(RoundedCornerShape(10.dp)),
                filterQuality = FilterQuality.Low
            )

            Column(modifier = Modifier.padding(start = 16.dp)) {
                Text(
                    text = movie.movieTitle?.text ?: "Unavailable",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = movie.movieType?.text ?: "Unavailable",
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(vertical = 4.dp)
                )

                val releaseDate = movie.releaseDate
                val date = if (releaseDate?.month != null && releaseDate.year != null) {
                    val month = releaseDate.month?.let {
                        Month.of(it.toInt()).getDisplayName(
                            TextStyle.FULL_STANDALONE,
                            Locale.getDefault()
                        )
                    } ?: ""
                    "$month - ${movie.releaseDate?.year}"
                } else {
                    movie.releaseYear?.year.toString()
                }

                Text(
                    text = date,
                    style = MaterialTheme.typography.bodyMedium,
                )
            }
        }
    }
}