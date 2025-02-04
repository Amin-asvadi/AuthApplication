package com.example.base_android.uiles

interface BaseUseCase<In, Out>{
    suspend fun execute(input: In): Out
}