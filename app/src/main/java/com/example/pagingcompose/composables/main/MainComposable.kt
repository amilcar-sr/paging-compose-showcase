package com.example.pagingcompose.composables.main

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.PullRefreshState
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.itemContentType
import com.example.pagingcompose.R
import com.example.pagingcompose.data.model.Movie

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MainComposable(
    isLoading: Boolean,
    hasError: Boolean,
    isRefreshing: Boolean,
    pullRefreshState: PullRefreshState,
    onRetryClick: () -> Unit,
    moviePagingItems: LazyPagingItems<Movie>,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .pullRefresh(pullRefreshState),
        contentAlignment = Alignment.Center
    ) {
        when {
            hasError -> {
                Text(
                    text = stringResource(R.string.error_text),
                    color = Color.Red,
                    modifier = Modifier
                        .clickable(onClick = onRetryClick)
                        .padding(16.dp)
                )
            }

            moviePagingItems.itemCount == 0 && !isLoading -> {
                Text(
                    text = stringResource(R.string.empty_list_text),
                    color = Color.DarkGray,
                    modifier = Modifier
                        .clickable(onClick = onRetryClick)
                        .padding(16.dp)
                )
            }

            else -> {
                MovieListComposable(moviePagingItems, isLoading, isRefreshing, pullRefreshState)
            }
        }
    }
}

@Composable
@OptIn(ExperimentalMaterialApi::class)
private fun BoxScope.MovieListComposable(
    moviePagingItems: LazyPagingItems<Movie>,
    isLoading: Boolean,
    isRefreshing: Boolean,
    pullRefreshState: PullRefreshState
) {

    if (isLoading) {
        CircularProgressIndicator()
    } else {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(count = moviePagingItems.itemCount) { index ->
                moviePagingItems[index]?.let { movie ->
                    MovieItem(movie = movie)
                }
            }
        }
    }

    PullRefreshIndicator(
        refreshing = isRefreshing,
        state = pullRefreshState,
        modifier = Modifier.Companion.align(Alignment.TopCenter)
    )
}