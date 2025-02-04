package com.example.authapplication.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.base_android.graph.AppGraphScreens


@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    isDark:Boolean,
) {
        SharedTransitionLayout {
            NavHost(
                navController = navController,
                startDestination = AppGraphScreens.AuthScreen.route,
                enterTransition = { EnterTransition.None },
                exitTransition = { ExitTransition.None },
                popEnterTransition = { EnterTransition.None },
                popExitTransition = { ExitTransition.None }

            ) {
                /*    composable(AppGraphScreens.SplashScreens.route) {
                      //  SplashScreen(navController = navController)
                    }*/
                composable(AppGraphScreens.AuthScreen.route) {
                }


            }
        }

}