package com.example.presentation

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.text.input.KeyboardType
import com.example.base_android.base_classes.AsyncResult
import com.example.base_android.base_classes.Uninitialized
import com.example.base_android.uiles.Constant
import com.example.data.model.LoginResponse
import com.example.data.staticdata.InputDataClass

data class AuthState(
    val refreshing: Boolean = false,
    val emailValue: String="",
    val passwordValue: String="",
    val loginResult: AsyncResult<LoginResponse> = Uninitialized,
) {
    val inputList = listOf(
        InputDataClass(
            id = 1,
            placeHolder = "Email",
            keyboardType = KeyboardOptions(keyboardType = KeyboardType.Email),
            keyBoardMode = Constant.KeyBoardMode.EMAIL
        ),
        InputDataClass(
            id = 2,
            placeHolder = "Password",
            keyboardType = KeyboardOptions(keyboardType = KeyboardType.Password),
            keyBoardMode = Constant.KeyBoardMode.PASSWORD
        )
    )
}