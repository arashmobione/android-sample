package com.example.sample.domain.repository

import com.example.sample.presentation.entity.MovieEntity
import com.example.sample.utill.Resource
import kotlinx.coroutines.flow.Flow

interface MovieRepository  {
     fun getMovies(): Flow<Resource<List<MovieEntity>>>

}