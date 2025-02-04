package com.example.data.model

import androidx.annotation.Keep
import kotlinx.serialization.Serializable

@Serializable
@Keep
data class LoginResponse(
    val access_token: String,
    val refresh_token: String
)