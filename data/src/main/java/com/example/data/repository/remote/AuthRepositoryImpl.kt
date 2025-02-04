package com.example.data.repository.remote

import com.example.base_android.network.bodyOrThrow
import com.example.data.api.AuthApi
import com.example.data.model.LoginBody
import com.example.data.model.LoginResponse
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    val api: AuthApi
) : AuthRepository {
    override suspend fun authLogin(request: LoginBody): LoginResponse {
        return api.login(request).bodyOrThrow()
    }

}