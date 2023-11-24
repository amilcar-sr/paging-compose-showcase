package com.example.pagingcompose.data.model

import com.google.gson.annotations.SerializedName


data class Movie(
    @SerializedName("_id") var _id: String? = null,
    @SerializedName("id") var id: String? = null,
    @SerializedName("primaryImage") var primaryImage: PrimaryImage? = PrimaryImage(),
    @SerializedName("titleType") var movieType: MovieType? = MovieType(),
    @SerializedName("titleText") var movieTitle: MovieTitle? = MovieTitle(),
    @SerializedName("originalTitleText") var originalMovieText: OriginalMovieTitle? = OriginalMovieTitle(),
    @SerializedName("releaseYear") var releaseYear: ReleaseYear? = ReleaseYear(),
    @SerializedName("releaseDate") var releaseDate: ReleaseDate? = ReleaseDate(),
)