package com.example.sample.data.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.sample.data.entity.MovieData

@Database(entities = [MovieData::class], version = 1, exportSchema = false)
abstract class MovieDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao
}