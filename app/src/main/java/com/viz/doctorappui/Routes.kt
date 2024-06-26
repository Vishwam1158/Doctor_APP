package com.viz.doctorappui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.ui.graphics.vector.ImageVector

data class NavPage(var name: String, var icon: ImageVector, var route: String)

object Routes {
    val doctorDetails = "doctorDetails"
    var homeScreen =   "homeScreen"
    var doctorList = "doctorList"
    val appointment = "appointment"
    val buttonClick = "buttonClick"
    val app = "app"
    val favorite = "favorite"

    //bottom nav
        val HomeScreen = NavPage("Home", Icons.Outlined.Home, "homeScreen")
        val DoctorList = NavPage("DoctorList", Icons.Outlined.Menu, "doctorList")
        val Appointment = NavPage("Appointment", Icons.Outlined.Email, "appointment")
        val Favorite = NavPage("favorite", Icons.Outlined.Favorite, "favorite")

//    var InfoPage =  NavPage("Info", Icons.Outlined.Info, "info")

        val pages = listOf(HomeScreen, DoctorList, Appointment, Favorite)

}

sealed class Screen(val route: String) {
    object App : Screen(Routes.app)
    object HomeScreen : Screen(Routes.homeScreen)
    object DoctorList : Screen(Routes.doctorList)
    object DoctorDetails : Screen(Routes.doctorDetails)
    object Appointment : Screen(Routes.appointment)
    object ButtonClick : Screen(Routes.buttonClick)
    object Favorite : Screen(Routes.favorite)


    fun withArgs(vararg args: Int): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}