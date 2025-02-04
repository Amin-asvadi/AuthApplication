package com.example.ui_auth_screen

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import collectAsState
import com.example.base_android.base_classes.Fail
import com.example.base_android.base_classes.Success
import com.example.base_android.uiles.Constant
import com.example.common_ui_resources.header.ImageHeader
import com.example.presentation.AuthEvent
import com.example.presentation.AuthScreenViewModel
import com.example.presentation.AuthState
import com.example.common_ui_resources.R
import com.example.common_ui_resources.input.CustomBasicTextField
import com.example.common_ui_resources.input.CustomOutlineTextFiled
import com.example.common_ui_resources.theme.Gray_500
import com.example.common_ui_resources.theme.Gray_900
import com.example.common_ui_resources.theme.Primary
import com.example.ui_auth_screen.component.BottomActionBar
import com.saba.design_system.snackbar.AppnackBarScreen
import kotlinx.coroutines.delay

@Composable
fun AuthScreen(
    navController: NavController,
    viewModel: AuthScreenViewModel = hiltViewModel(),
    modifier: Modifier = Modifier,
) {


    val viewState by viewModel.collectAsState()
    AuthScreen(
        navController = navController,
        modifier = modifier,
        viewModel = viewModel,
        state = viewState,
        event =
        { action ->
            when (action) {
                is AuthEvent.NavigateToScreen -> navController.navigate(action.route)
                else -> viewModel.submitAction(action)
            }
        }
    )
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
internal fun AuthScreen(
    navController: NavController,
    state: AuthState,
    viewModel: AuthScreenViewModel,
    event: (AuthEvent) -> Unit,
    modifier: Modifier,
) {
    var onVisibleClick by remember { mutableStateOf(false) }
    val snackbarHostState = remember { SnackbarHostState() }
    val context = LocalContext.current
    LaunchedEffect(
        Unit,
    ) {
        delay(3000)
        snackbarHostState.showSnackbar("Error")
    }

    LaunchedEffect(
        key1 = state.loginResult,
    ) {
        if (state.loginResult is Success) {
            Toast.makeText(context, "لاگین انجام شد",Toast.LENGTH_LONG).show()
        }else if (state.loginResult is Fail){
            Toast.makeText(context, "توکن ندارید",Toast.LENGTH_LONG).show()
        }
    }
    Scaffold(modifier = modifier.fillMaxSize(),
        snackbarHost = {
            val error = viewModel.networkErrorState.value()?.isError ?: false
            AppnackBarScreen(
                snackbarHostState = snackbarHostState,
                message = viewModel.networkErrorState.value()?.text
                    ?: "",
                isSuccess = !error,
                dissmiss = {
                    snackbarHostState.currentSnackbarData?.dismiss()
                }
            )
        },
        bottomBar = {
            BottomActionBar(
                modifier = modifier,
                enable = state.emailValue.isNotEmpty() && state.passwordValue.isNotEmpty(),
                onSignInClick = {
                    event(AuthEvent.LoginClick)
                },
                onGoogleClick = {}
            )
        }) { Image(
            painter = painterResource(R.drawable.log_in),
            modifier = modifier.fillMaxSize(),
            contentDescription = "Back",
            contentScale = ContentScale.FillBounds
        )
        LazyColumn(
            modifier = modifier.fillMaxSize(),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 56.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item("HeaderImage") {
                ImageHeader(
                    modifier = modifier, image = R.drawable.image,
                    title = "login",
                    description = "Learn languages your way! Unlock new skills, practice daily, and track your progress with Tell me."
                )
            }
            items(state.inputList, key = {
                it.id
            }) { item ->
                CustomOutlineTextFiled(
                    modifier = modifier.fillMaxWidth(),
                    height = 48.dp,
                    value = when (item.keyBoardMode) {
                        Constant.KeyBoardMode.EMAIL -> state.emailValue
                        else -> state.passwordValue
                    },
                    singleLine = true,
                    placeholder = {
                        Text(item.placeHolder, color = Gray_500)
                    },
                    trailingIcon = {
                        if (item.keyBoardMode == Constant.KeyBoardMode.PASSWORD) {
                            IconButton(onClick = {
                                onVisibleClick = !onVisibleClick
                            }) {
                                Icon(
                                    painter = painterResource(if (onVisibleClick) R.drawable.hide else R.drawable.baseline_remove_red_eye_24),
                                    contentDescription = "Hide",
                                )
                            }

                        }
                    },
                    visualTransformation =if (item.keyBoardMode == Constant.KeyBoardMode.PASSWORD){
                        if (onVisibleClick ) VisualTransformation.None else PasswordVisualTransformation()
                    }else{
                        VisualTransformation.None
                    } ,
                    onValueChange = { v ->
                        event(AuthEvent.OnValueChange(value = v, mode = item.keyBoardMode))
                    },

                    )
            }
            item("ForgotPassword") {
                Text(
                    "Forgot password !",
                    color = Primary,
                    modifier = modifier.fillMaxWidth(),
                    textAlign = TextAlign.End
                )
            }

        }

    }
}