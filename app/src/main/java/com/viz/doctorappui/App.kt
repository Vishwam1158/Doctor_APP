package com.viz.doctorappui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController

@Composable
fun App(navController: NavHostController) {
    val selectedRoute = remember {
        mutableStateOf(Routes.HomeScreen.route)
    }
    Scaffold(
        topBar = {
            TopBar()
        },
        bottomBar = {
            BottomBar(
                selectedRoute = selectedRoute.value,
                onChange = { route ->
                    selectedRoute.value = route
                    selectedRoute.value = route
                }
            )
        }

    ) {
        Column(modifier = Modifier.padding(it)) {
            when(selectedRoute.value) {
                Routes.HomeScreen.route -> HomeScreen(navController)
                Routes.DoctorList.route -> DoctorList(navController)
                Routes.Appointment.route -> Appointment(navController)
//                Routes.Favorite.route -> Favorite(navController)

            }
        }
    }
}

@Preview
@Composable
private fun AppPreview() {
    App(navController = NavHostController(LocalContext.current))
}