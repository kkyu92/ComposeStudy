package com.example.composestudy.navigation.destination

import androidx.compose.material.ExperimentalMaterialApi
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.composestudy.ui.screens.list.ListScreen
import com.example.composestudy.ui.viewmodel.SharedViewModel
import com.example.composestudy.util.Constants.LIST_ARGUMENT_KEY
import com.example.composestudy.util.Constants.LIST_SCREEN

@ExperimentalMaterialApi
fun NavGraphBuilder.listComposable(
    navigateToTaskScreen: (taskId: Int) -> Unit,
    sharedViewModel: SharedViewModel
) {
    composable(
        route = LIST_SCREEN,
        arguments = listOf(navArgument(LIST_ARGUMENT_KEY){
            type = NavType.StringType
        })
    ) {
        ListScreen(
            navigationToTaskScreen = navigateToTaskScreen,
            sharedViewModel = sharedViewModel
        )
    }
}