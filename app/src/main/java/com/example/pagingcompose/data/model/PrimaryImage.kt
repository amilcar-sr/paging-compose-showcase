package com.example.pagingcompose.data.model

import com.google.gson.annotations.SerializedName


data class PrimaryImage(
    @SerializedName("id") var id: String? = null,
    @SerializedName("width") var width: Int? = null,
    @SerializedName("height") var height: Int? = null,
    @SerializedName("url") var url: String? = null,
    @SerializedName("caption") var caption: Caption? = Caption(),
    @SerializedName("__typename") var _typename: String? = null,
)