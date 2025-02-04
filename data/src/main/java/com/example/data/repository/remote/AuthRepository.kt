package com.example.data.repository.remote

import com.example.data.model.LoginBody
import com.example.data.model.LoginResponse

interface AuthRepository {
    suspend fun authLogin(request:LoginBody):LoginResponse
}