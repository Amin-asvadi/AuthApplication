package com.example.domain.usecase

import com.example.base_android.uiles.IoDispatcher
import com.example.base_android.uiles.ResultUseCase
import com.example.data.model.LoginBody
import com.example.data.model.LoginResponse
import com.example.data.repository.remote.AuthRepository
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    @IoDispatcher dispatcher: CoroutineDispatcher,
    private val repository: AuthRepository
) : ResultUseCase<LoginBody,LoginResponse>(dispatcher) {

    override suspend fun doWork(params: LoginBody): LoginResponse{
        return repository.authLogin(params)
    }

}
