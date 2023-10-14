package com.example.pagingcompose.data.model

import com.google.gson.annotations.SerializedName


data class Caption(
    @SerializedName("plainText") var plainText: String? = null,
    @SerializedName("__typename") var _typename: String? = null,
)