package com.example.pagingcompose.data

import com.example.pagingcompose.data.model.TitleResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {

    @Headers(
        "X-RapidAPI-Key: {API-KEY}",
        "X-RapidAPI-Host: moviesdatabase.p.rapidapi.com"
    )
    @GET("titles")
    suspend fun getTitles(@Query("sort") sort: String = "year.decr"): TitleResponse
}