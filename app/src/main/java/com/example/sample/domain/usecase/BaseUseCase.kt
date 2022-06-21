package com.example.sample.domain.usecase

import com.example.sample.utill.Resource
import kotlinx.coroutines.flow.Flow

abstract class BaseUseCase<in P, R>() {
    abstract fun execute(parameter: P): Flow<Resource<R>>
}