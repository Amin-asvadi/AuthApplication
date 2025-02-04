package com.example.data.api

import com.example.data.model.LoginBody
import com.example.data.model.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {
    @POST("v1/auth/login")
    suspend fun login(
        @Body loginBody: LoginBody
    ): Response<LoginResponse>
}