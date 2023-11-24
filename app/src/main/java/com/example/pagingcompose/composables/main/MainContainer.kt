package com.example.pagingcompose.composables.main

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.pagingcompose.MainViewModel
import com.example.pagingcompose.extensions.hasError
import com.example.pagingcompose.extensions.isLoading
import com.example.pagingcompose.extensions.isRefreshing

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MainContainer() {
    val viewModel = viewModel { MainViewModel() }

    val movies = viewModel.moviePager.collectAsLazyPagingItems()
    val isRefreshing = movies.isRefreshing

    val pullRefreshState = rememberPullRefreshState(
        refreshing = isRefreshing,
        onRefresh = movies::refresh
    )

    MainComposable(
        moviePagingItems = movies,
        isLoading = movies.isLoading,
        isRefreshing = isRefreshing,
        hasError = movies.hasError,
        pullRefreshState = pullRefreshState,
        onRetryClick = movies::retry,
    )
}