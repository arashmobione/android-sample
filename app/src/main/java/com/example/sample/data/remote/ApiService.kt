package com.example.sample.data.remote

import com.example.sample.data.entity.NetworkMovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("v1/4b9b8880-bb17-4f8e-a31f-7909c4a680dd")
    suspend fun getMovies(
        @Query("param") name: String
    ): NetworkMovieResponse
}