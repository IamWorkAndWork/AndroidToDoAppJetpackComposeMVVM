import androidx.navigation.NavHostController
import com.example.todoappjetpackcomposemvvm.util.Action
import com.example.todoappjetpackcomposemvvm.util.Constants
import com.example.todoappjetpackcomposemvvm.util.Constants.LIST_SCREEN


class Screens(navController: NavHostController) {

    val splash: () -> Unit = {
        navController.navigate(route = "list/${Action.NO_ACTION}") {
            popUpTo(Constants.SPLASH_SCREEN) {
                inclusive = true
            }
        }
    }

    val list: (Int) -> Unit = { taskId ->
        navController.navigate(route = "task/${taskId}")
    }

    val task: (Action) -> Unit = { action ->
        navController.navigate(route = "list/${action}") {
            popUpTo(LIST_SCREEN) {
                inclusive = true
            }
        }
    }

}