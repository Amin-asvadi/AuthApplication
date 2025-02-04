package com.example.presentation

import androidx.lifecycle.viewModelScope
import com.example.base_android.base_classes.BaseViewModel
import com.example.base_android.network.DispatcherProvider
import com.example.base_android.network.NetworkErrorData
import com.example.base_android.network.NetworkErrorHandler
import com.example.base_android.uiles.Constant
import com.example.data.model.LoginBody
import com.example.domain.usecase.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthScreenViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    networkErrorHandler: NetworkErrorHandler,
    dispatcherProvider: DispatcherProvider,
) : BaseViewModel<AuthState, AuthEvent>(AuthState()) {

    init {
        networkHandler(networkErrorHandler.event)
        onEachAction { action ->
            when (action) {
                is AuthEvent.OnValueChange -> {
                    setState {
                        when (action.mode) {
                            Constant.KeyBoardMode.EMAIL -> copy(
                                emailValue = action.value
                            )

                            else -> copy(
                                passwordValue = action.value
                            )
                        }

                    }
                }

                is AuthEvent.LoginClick -> loginRequest()
                else -> throw IllegalArgumentException("unknown action: $action")
            }
        }
        onAsyncResult(
            AuthState::loginResult,
            onSuccess = {
                networkErrorHandler.emitEvent(
                    NetworkErrorData(
                        isError = true,
                        text = "با موفقیت وارد شدید"
                    )
                )

            },
            onFail = {
                networkErrorHandler.emitEvent(
                    NetworkErrorData(
                        isError = true,
                        text = "با موفقیت وارد شدید"
                    )
                )
            }
        )
    }

    private fun loginRequest() {
        viewModelScope.launch {
            suspend {
                val param = LoginBody(email = state.emailValue, password = state.passwordValue)
                loginUseCase(param)
            }.execute {
                copy(loginResult = it)
            }
        }
    }

}