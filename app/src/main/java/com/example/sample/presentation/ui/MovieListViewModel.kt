package com.example.sample.presentation.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.example.sample.domain.usecase.GetMoviesUseCase

class MovieListViewModel @ViewModelInject constructor(
    private val getMoviesUseCase: GetMoviesUseCase
) :
    ViewModel() {

    val movieList = getMoviesUseCase.execute(Unit).asLiveData()

}