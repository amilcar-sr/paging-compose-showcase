package com.example.pagingcompose

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.pagingcompose.data.MovieDataSource

private const val MOVIE_PAGE_SIZE = 15
private const val MOVIE_INITIAL_LOAD_SIZE = 45

class MainViewModel : ViewModel() {
    val moviePager = Pager(
        config = PagingConfig(
            pageSize = MOVIE_PAGE_SIZE,
            initialLoadSize = MOVIE_INITIAL_LOAD_SIZE
        ),
        initialKey = null,
        pagingSourceFactory = { MovieDataSource() }
    ).flow.cachedIn(viewModelScope)
}