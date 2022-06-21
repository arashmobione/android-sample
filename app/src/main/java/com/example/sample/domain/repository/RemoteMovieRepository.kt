package com.example.sample.domain.repository

import com.example.sample.presentation.entity.MovieEntity

interface RemoteMovieRepository  {
     suspend fun getMovies(): List<MovieEntity>
}