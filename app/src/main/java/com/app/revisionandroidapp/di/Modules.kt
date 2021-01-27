package com.app.revisionandroidapp

import com.app.revisionandroidapp.datas.repository.MovieRepository
import com.app.revisionandroidapp.ui.home.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

var modules: Module = module {

    single { MovieRepository() }

    viewModel { MainViewModel(get()) }

}