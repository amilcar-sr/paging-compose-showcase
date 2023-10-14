package com.example.pagingcompose.data.model

import com.google.gson.annotations.SerializedName


data class Results(
    @SerializedName("_id") var _id: String? = null,
    @SerializedName("id") var id: String? = null,
    @SerializedName("primaryImage") var primaryImage: PrimaryImage? = PrimaryImage(),
    @SerializedName("titleType") var titleType: TitleType? = TitleType(),
    @SerializedName("titleText") var titleText: TitleText? = TitleText(),
    @SerializedName("originalTitleText") var originalTitleText: OriginalTitleText? = OriginalTitleText(),
    @SerializedName("releaseYear") var releaseYear: ReleaseYear? = ReleaseYear(),
    @SerializedName("releaseDate") var releaseDate: ReleaseDate? = ReleaseDate(),
)