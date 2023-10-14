package com.example.pagingcompose.data.model

import com.google.gson.annotations.SerializedName


data class ReleaseYear(
    @SerializedName("year") var year: Int? = null,
    @SerializedName("endYear") var endYear: String? = null,
    @SerializedName("__typename") var _typename: String? = null,
)