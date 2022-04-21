package com.example.composestudy.navigation.destination

import android.util.Log
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.composestudy.ui.screens.list.ListScreen
import com.example.composestudy.ui.viewmodel.SharedViewModel
import com.example.composestudy.util.Constants.LIST_ARGUMENT_KEY
import com.example.composestudy.util.Constants.LIST_SCREEN
import com.example.composestudy.util.toAction

@ExperimentalMaterialApi
fun NavGraphBuilder.listComposable(
    navigateToTaskScreen: (taskId: Int) -> Unit,
    sharedViewModel: SharedViewModel
) {
    composable(
        route = LIST_SCREEN,
        arguments = listOf(navArgument(LIST_ARGUMENT_KEY) {
            type = NavType.StringType
        })
    ) { navBackStackEntry ->
        val action = navBackStackEntry.arguments?.getString(LIST_ARGUMENT_KEY).toAction()

        LaunchedEffect(key1 = action) {
            sharedViewModel.action.value = action
        }

        ListScreen(
            navigationToTaskScreen = navigateToTaskScreen,
            sharedViewModel = sharedViewModel
        )
    }
}