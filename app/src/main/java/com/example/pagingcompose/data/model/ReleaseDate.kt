package com.example.pagingcompose.data.model

import com.google.gson.annotations.SerializedName


data class ReleaseDate(
    @SerializedName("day") var day: Int? = null,
    @SerializedName("month") var month: String? = null,
    @SerializedName("year") var year: String? = null,
)