package com.example.sample.data.dataSource.movie

import android.util.Log
import com.example.sample.data.data.MovieDao
import com.example.sample.data.entity.MovieData
import com.example.sample.domain.repository.MovieCache
import com.example.sample.presentation.entity.MovieEntity
import com.example.sample.presentation.mapper.toEntity
import com.example.sample.utill.Constant.TAG
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class LocalMovieDataSource @Inject constructor(
    private val movieDao: MovieDao
) : MovieCache {


    override suspend fun insertAll(movies: List<MovieData>) {
        Log.d(TAG, "insertAll: ${movies.size}")
        movieDao.insertAll(movies)
    }

    override suspend fun deleteAll() {
        Log.d(TAG, "deleteAll: ")
        movieDao.deleteAll()
    }

    override fun getMovies(): Flow<List<MovieEntity>> = movieDao.getMovies().map { list ->
        Log.d(TAG, "getMovies: local")
        list.toEntity()
    }

}