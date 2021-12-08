package com.example.todoappjetpackcomposemvvm.navigation.destinations

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.todoappjetpackcomposemvvm.ui.screens.splash.ListScreen
import com.example.todoappjetpackcomposemvvm.ui.viewmodels.SharedViewModel
import com.example.todoappjetpackcomposemvvm.util.Action
import com.example.todoappjetpackcomposemvvm.util.Constants.LIST_ARGUMENT_KEY
import com.example.todoappjetpackcomposemvvm.util.Constants.LIST_SCREEN
import com.example.todoappjetpackcomposemvvm.util.toAction


@ExperimentalMaterialApi
@ExperimentalAnimationApi
fun NavGraphBuilder.listComposable(
    navigationToTaskScreen: (taskId: Int) -> Unit,
    sharedViewModel: SharedViewModel
) {

    composable(
        route = LIST_SCREEN,
        arguments = listOf(navArgument(LIST_ARGUMENT_KEY) {
            type = NavType.IntType
        })
    ) { navBackStackEntry ->

        val action = navBackStackEntry.arguments?.getString(LIST_ARGUMENT_KEY).toAction()

        var myAction by rememberSaveable { mutableStateOf(Action.NO_ACTION) }

        LaunchedEffect(key1 = myAction) {
            if (action != myAction) {
                myAction = action
                sharedViewModel.action.value = action
            }
        }

        val databaseAction by sharedViewModel.action

        ListScreen(
            action = databaseAction,
            navigateToTaskScreen = navigationToTaskScreen,
            sharedViewModel = sharedViewModel
        )

    }

}