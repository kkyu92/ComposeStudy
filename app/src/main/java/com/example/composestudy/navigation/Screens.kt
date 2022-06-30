package com.example.composestudy.navigation

import androidx.navigation.NavController
import com.example.composestudy.util.Action
import com.example.composestudy.util.Constants.LIST_SCREEN
import com.example.composestudy.util.Constants.SPLASH_SCREEN

class Screens(navController: NavController) {
    val splash: () -> Unit = {
        navController.navigate(route = "list/${Action.NO_ACTION}") {
            popUpTo(SPLASH_SCREEN) { inclusive = true }
        }
    }
    val list: (Int) -> Unit = { taskId ->
        navController.navigate(route = "task/$taskId")
    }
    val task: (Action) -> Unit = { action ->
        navController.navigate(route = "list/${action.name}") {
            popUpTo(LIST_SCREEN) { inclusive = true}
        }
    }
}