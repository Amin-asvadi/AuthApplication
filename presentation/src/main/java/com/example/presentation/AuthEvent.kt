package com.example.presentation

import com.example.base_android.uiles.Constant

sealed class AuthEvent {
    data class NavigateToScreen(val route: String) : AuthEvent()
    object LoginClick : AuthEvent()
    data class OnValueChange(val value: String, val mode: Constant.KeyBoardMode) : AuthEvent()
}
