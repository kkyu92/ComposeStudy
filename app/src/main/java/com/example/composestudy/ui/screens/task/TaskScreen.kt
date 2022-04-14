package com.example.composestudy.ui.screens.task

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.composestudy.data.models.ToDoTask
import com.example.composestudy.util.Action

@Composable
fun TaskScreen(
    selectedTask: ToDoTask?,
    navigateToListScreen: (Action) -> Unit
) {
    Scaffold(
        topBar = {
            TaskAppBar(selectedTask, navigateToListScreen)
        },
        content = {},
    )
}

@Composable
@Preview
fun TaskScreenPreview() {

}