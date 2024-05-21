package com.viz.doctorappui


import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController



@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.contentScreen)
    {
        composable(Routes.contentScreen) {
            ContentBar(navController)
        }
        composable(Routes.doctorList) {
            DoctorList(navController)
        }
    }
}


