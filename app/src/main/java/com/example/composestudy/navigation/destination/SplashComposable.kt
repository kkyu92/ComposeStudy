package com.example.composestudy.navigation.destination

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideOutVertically
import androidx.navigation.NavGraphBuilder
import com.example.composestudy.ui.screens.splash.SplashScreen
import com.example.composestudy.util.Constants.SPLASH_SCREEN
import com.google.accompanist.navigation.animation.composable

@ExperimentalAnimationApi
fun NavGraphBuilder.splashComposable(
    navigateToTaskScreen: () -> Unit
) {
    composable(
        route = SPLASH_SCREEN,
        exitTransition = { initial, target ->
            slideOutVertically(
                targetOffsetY = { fullHeight -> -fullHeight },
                animationSpec = tween(durationMillis = 300)
            )
        }
    ) {
        SplashScreen(navigateToTaskScreen)
    }
}