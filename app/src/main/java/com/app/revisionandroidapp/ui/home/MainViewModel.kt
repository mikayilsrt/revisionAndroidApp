package com.app.revisionandroidapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.app.revisionandroidapp.datas.models.MovieModel
import com.app.revisionandroidapp.datas.repository.MovieRepository

class MainViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    init {
        this.movieRepository.loadMovies()
    }

    fun getMovies(): LiveData<List<MovieModel>> {
        return this.movieRepository.getMovies()
    }

}