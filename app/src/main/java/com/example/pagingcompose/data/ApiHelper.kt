package com.example.pagingcompose.data

import com.example.pagingcompose.data.model.TitleResponse
import kotlinx.coroutines.flow.Flow

interface ApiHelper {

    fun getTitles(): Flow<TitleResponse>

}