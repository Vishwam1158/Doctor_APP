package com.viz.doctorappui

object Routes {
    val doctorDetails = "doctorDetails"
    var homeScreen =   "HomeScreen"
    var doctorList = "doctorList"
    val appointment = "appointment"
    val buttonClick = "buttonClick"
}

sealed class Screen(val route: String) {
    object HomeScreen : Screen(Routes.homeScreen)
    object DoctorList : Screen(Routes.doctorList)
    object DoctorDetails : Screen(Routes.doctorDetails)
    object Appointment : Screen(Routes.appointment)
    object ButtonClick : Screen(Routes.buttonClick)


    fun withArgs(vararg args: Int): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}