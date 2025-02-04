package com.example.data.staticdata

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.text.input.KeyboardType
import com.example.base_android.uiles.Constant

data class InputDataClass(
    val id:Int,
    val placeHolder: String,
    val keyboardType: KeyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
    val keyBoardMode: Constant.KeyBoardMode
)
