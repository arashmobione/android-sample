package com.example.sample.domain.usecase

import com.example.sample.domain.repository.MovieRepository
import com.example.sample.presentation.entity.MovieEntity
import com.example.sample.utill.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Named

class GetMoviesUseCase @Inject constructor(
    @Named("MovieRepoImpl") private val movieRepository: MovieRepository
) : BaseUseCase<Unit, List<MovieEntity>>() {
    override fun execute(parameter: Unit): Flow<Resource<List<MovieEntity>>> = movieRepository.getMovies()
}