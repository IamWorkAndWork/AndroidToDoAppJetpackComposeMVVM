package com.example.todoappjetpackcomposemvvm.ui.screens.list

import androidx.compose.runtime.Composable
import com.example.todoappjetpackcomposemvvm.data.models.Priority
import com.example.todoappjetpackcomposemvvm.data.models.ToDoTask
import com.example.todoappjetpackcomposemvvm.util.Action
import com.example.todoappjetpackcomposemvvm.util.RequestState
import com.example.todoappjetpackcomposemvvm.util.SearchAppBarState

@Composable
fun ListContent(
    allTasks: RequestState<List<ToDoTask>>,
    searchedTasks: RequestState<List<ToDoTask>>,
    lowPriorityTasks: List<ToDoTask>,
    highPriorityTasks: List<ToDoTask>,
    sortState: RequestState<Priority>,
    searchAppBarState: SearchAppBarState,
    onSwipeToDelete: (Action, ToDoTask) -> Unit,
    navigateToTaskScreen: (taskId: Int) -> Unit
) {



}