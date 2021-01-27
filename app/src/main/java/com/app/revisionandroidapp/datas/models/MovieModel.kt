package com.app.revisionandroidapp.datas.models

class MovieResult(
        val results: List<MovieModel> = listOf()
)

class MovieModel(
    val id: Int,
    val poster_path: String,
    val backdrop_path: String,
    val overview: String,
    val title: String,
    val popularity: Float,
    val vote_count: Int
)
