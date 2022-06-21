package com.example.sample.presentation.di

import com.example.sample.data.dataSource.MovieRepositoryImpl
import com.example.sample.domain.repository.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Named

@Module
@InstallIn(ActivityComponent::class)
abstract class ActivityModule {

    @Named("MovieRepoImpl")
    @ActivityScoped
    @Binds
    abstract fun bindMovieRepoImpl(movieRepoImpl: MovieRepositoryImpl): MovieRepository


}

