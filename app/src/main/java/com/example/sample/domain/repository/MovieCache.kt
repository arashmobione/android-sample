package com.example.sample.domain.repository

import com.example.sample.data.entity.MovieData
import com.example.sample.presentation.entity.MovieEntity
import kotlinx.coroutines.flow.Flow

interface MovieCache {

    fun getMovies(): Flow<List<MovieEntity>>
    suspend fun insertAll(movies: List<MovieData>)
    suspend fun deleteAll()
}