package com.example.sample.data.dataSource.movie

import android.util.Log
import com.example.sample.data.remote.ApiService
import com.example.sample.domain.repository.RemoteMovieRepository
import com.example.sample.presentation.entity.MovieEntity
import com.example.sample.presentation.mapper.toEntity
import com.example.sample.utill.Constant.PARAM_STRING
import com.example.sample.utill.Constant.TAG
import javax.inject.Inject

class RemoteMovieDataSource @Inject constructor(private val apiService: ApiService) :
    RemoteMovieRepository {

    override suspend fun getMovies(): List<MovieEntity> {
        Log.d(TAG, "getMovies: remote")
        return apiService.getMovies(
            PARAM_STRING
        ).movieList.toEntity()

    }

}