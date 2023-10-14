package com.example.pagingcompose.data

import kotlinx.coroutines.flow.flow

class ApiHelperImpl(private val apiService: ApiService) : ApiHelper {

    override fun getTitles() = flow {
        emit(apiService.getTitles())
    }

}