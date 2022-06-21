package com.example.sample.data.dataSource


import androidx.room.withTransaction
import com.example.sample.data.data.MovieDatabase
import com.example.sample.data.dataSource.movie.LocalMovieDataSource
import com.example.sample.data.dataSource.movie.RemoteMovieDataSource
import com.example.sample.domain.repository.MovieRepository
import com.example.sample.presentation.entity.MovieEntity
import com.example.sample.presentation.mapper.toData
import com.example.sample.utill.Resource
import com.example.sample.utill.networkBoundResource
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val remoteMovieDataSource: RemoteMovieDataSource,
    private val localMovieDataSource: LocalMovieDataSource,
    private val database: MovieDatabase
) :
    MovieRepository {

    override fun getMovies(): Flow<Resource<List<MovieEntity>>> = networkBoundResource(
        query = { localMovieDataSource.getMovies() },
        fetch = { remoteMovieDataSource.getMovies() },
        saveFetchResult = { movies ->
            database.withTransaction {
                localMovieDataSource.deleteAll()
                localMovieDataSource.insertAll(movies.toData())
            }
        },
        shouldFetch = { movies ->
            movies.isNullOrEmpty()
        }
    )


}