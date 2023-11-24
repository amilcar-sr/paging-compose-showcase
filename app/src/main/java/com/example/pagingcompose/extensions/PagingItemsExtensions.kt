package com.example.pagingcompose.extensions

import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems

internal val LazyPagingItems<*>.isLoading: Boolean get() = loadState.refresh is LoadState.Loading && itemCount == 0

internal val LazyPagingItems<*>.isRefreshing: Boolean get() = loadState.append is LoadState.Loading || (loadState.refresh is LoadState.Loading && itemCount > 0)

internal val LazyPagingItems<*>.hasError: Boolean get() = loadState.refresh is LoadState.Error || loadState.append is LoadState.Error