package com.viz.doctorappui


import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument


@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.HomeScreen.route)
    {
        composable(Screen.HomeScreen.route) {
            HomeScreen(navController)
        }
        composable(Screen.DoctorList.route) {
            DoctorList(navController)
        }
        composable(
            Screen.DoctorDetails.route + "/{name}", // for option argument use "?id={id}" instead of "/{id}"
            listOf(
                navArgument("name") {
                    type = NavType.StringType
                    defaultValue = "No Name"
//                    nullable = true
                }
            )
        ) { backStackEntry ->
            DoctorDetails(name = backStackEntry.arguments?.getString("name"), navController)
//            val id = backStackEntry.arguments?.getString("id")?.toInt() ?: 0
//            DoctorDetails(id, navController)

    }

//    NavHost(navController = navController, startDestination = R) {

    }

}



