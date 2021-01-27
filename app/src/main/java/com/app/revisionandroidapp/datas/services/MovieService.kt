package com.app.revisionandroidapp.datas.services

import com.app.revisionandroidapp.datas.models.MovieModel
import com.app.revisionandroidapp.datas.models.MovieResult
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @GET("movie/popular")
    fun getMovies(
        @Query("api_key") apiKey: String = MovieServiceHolder.API_KEY
    ): Observable<MovieResult>

}