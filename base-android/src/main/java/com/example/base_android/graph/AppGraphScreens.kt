package com.example.base_android.graph

sealed class AppGraphScreens(val route: String) {
    data object AuthScreen : AppGraphScreens("auth_screen")
}