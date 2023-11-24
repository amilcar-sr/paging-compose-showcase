package com.example.pagingcompose.data.model

import com.google.gson.annotations.SerializedName


data class MovieType(
    @SerializedName("text") var text: String? = null,
    @SerializedName("id") var id: String? = null,
    @SerializedName("isSeries") var isSeries: Boolean? = null,
    @SerializedName("isEpisode") var isEpisode: Boolean? = null,
    @SerializedName("__typename") var _typename: String? = null,
)