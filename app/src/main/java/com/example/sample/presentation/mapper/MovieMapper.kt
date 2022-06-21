package com.example.sample.presentation.mapper

import com.example.sample.data.entity.MovieData
import com.example.sample.presentation.entity.MovieEntity


//MovieData to MovieEntity
fun mapMovieDataToMovieEntity(movieData: MovieData) = with(movieData) {
    MovieEntity(
        title,
        year,
        poster,
        imdbID,
        type
    )
}
fun MovieData.toEntity() = mapMovieDataToMovieEntity(this)
fun List<MovieData>.toEntity() = map {
    it.toEntity()
}

//MovieEntity to MovieData
fun mapMovieEntityToMovieData(movieEntity: MovieEntity) = with(movieEntity) {
    MovieData(
        title,
        year,
        poster,
        imdbID,
        type
    )
}
fun MovieEntity.toData() = mapMovieEntityToMovieData(this)
fun List<MovieEntity>.toData() = map {
    it.toData()
}



