package com.example.data.model

import androidx.annotation.Keep
import kotlinx.serialization.Serializable

@Serializable
@Keep
data class LoginBody(
    val email: String,
    val password: String
)