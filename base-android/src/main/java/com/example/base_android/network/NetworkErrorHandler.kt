package com.example.base_android.network
import com.example.base_android.uiles.Constant
import kotlinx.coroutines.flow.SharedFlow

data class NetworkErrorData(
    val text: String ="",
    val isError: Boolean,
    val isWarning: Boolean = false,
    val message: String? = null,
    val isSignOut:Boolean = false,
    val errorMode: Constant.ERROR_MODE = Constant.ERROR_MODE.SERVER_ERROR,
    val bottomSheetError:Boolean =false
)

interface NetworkErrorHandler {
    val event: SharedFlow<NetworkErrorData>
    fun emitEvent(networkErrorData: NetworkErrorData)
}