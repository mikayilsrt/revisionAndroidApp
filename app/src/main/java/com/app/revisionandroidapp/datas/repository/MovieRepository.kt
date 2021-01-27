package com.app.revisionandroidapp.datas.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.app.revisionandroidapp.datas.models.MovieModel
import com.app.revisionandroidapp.datas.models.MovieResult
import com.app.revisionandroidapp.datas.services.MovieService
import com.app.revisionandroidapp.datas.services.MovieServiceHolder
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

class MovieRepository {

    private val service: MovieService = MovieServiceHolder.retrofit.create(MovieService::class.java)

    private var _movies: MutableLiveData<List<MovieModel>> = MutableLiveData()
    fun getMovies(): LiveData<List<MovieModel>> {
        return this._movies
    }

    fun loadMovies() {
        service.getMovies()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object: Observer<MovieResult> {
                    override fun onSubscribe(d: Disposable?) = Unit

                    override fun onNext(t: MovieResult) {
                        this@MovieRepository._movies.value = t.results
                    }

                    override fun onError(e: Throwable?) = Unit

                    override fun onComplete() = Unit
                })
    }

}