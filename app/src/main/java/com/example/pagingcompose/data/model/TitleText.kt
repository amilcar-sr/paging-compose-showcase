package com.example.pagingcompose.data.model

import com.google.gson.annotations.SerializedName


data class TitleText(
    @SerializedName("text") var text: String? = null,
    @SerializedName("__typename") var _typename: String? = null,
)