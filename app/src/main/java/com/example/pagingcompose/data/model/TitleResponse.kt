package com.example.pagingcompose.data.model

import com.google.gson.annotations.SerializedName

data class TitleResponse(
    @SerializedName("page") var page: Int? = null,
    @SerializedName("next") var next: String? = null,
    @SerializedName("entries") var entries: Int? = null,
    @SerializedName("results") var results: ArrayList<Movie> = arrayListOf(),
    @SerializedName("error") var error: String? = null,
)