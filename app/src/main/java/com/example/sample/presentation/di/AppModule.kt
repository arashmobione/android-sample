package com.example.sample.presentation.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.sample.R
import com.example.sample.data.data.MovieDatabase
import com.example.sample.data.dataSource.MovieRepositoryImpl
import com.example.sample.data.dataSource.movie.LocalMovieDataSource
import com.example.sample.data.dataSource.movie.RemoteMovieDataSource
import com.example.sample.data.remote.ApiService
import com.example.sample.domain.repository.MovieRepository
import com.example.sample.utill.Constant.BASE_URL
import com.example.sample.utill.Constant.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(
        app: Application
    ) = Room.databaseBuilder(app, MovieDatabase::class.java, DATABASE_NAME)
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    fun provideTaskDao(db: MovieDatabase) = db.movieDao()

    @Singleton
    @Provides
    fun provideRetrofit(moshiConverterFactory: MoshiConverterFactory): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(moshiConverterFactory)
            .build()
    }

    @Provides
    fun providesMoshiConverterFactory(): MoshiConverterFactory {
        return MoshiConverterFactory.create()
    }

    @Singleton
    @Provides
    fun provideApi(retrofit: Retrofit) = retrofit.create(ApiService::class.java)


    @Provides
    @Singleton
    fun provideApplicationScope() = CoroutineScope(SupervisorJob())

    @Provides
    fun provideOmp(
        remoteMovieDataSource: RemoteMovieDataSource,
        localMovieDataSource: LocalMovieDataSource,
        database: MovieDatabase
    ): MovieRepository {
        return MovieRepositoryImpl(remoteMovieDataSource, localMovieDataSource, database)
    }

    @Singleton
    @Provides
    fun provideGlideInstance(
        @ApplicationContext context: Context
    ) = Glide.with(context).setDefaultRequestOptions(
        RequestOptions()
            .placeholder(R.drawable.ic_baseline_texture_24)
            .error(R.drawable.ic_baseline_texture_24)
    )

}