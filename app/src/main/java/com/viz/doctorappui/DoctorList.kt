package com.viz.doctorappui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController

//class DoctorList {
//}

@Composable
fun DoctorList(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.verticalScroll(rememberScrollState())
        ) {

            Button(
                onClick = { navController.navigate(Routes.contentScreen) },
                colors = ButtonDefaults.buttonColors(Color.Transparent)
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    tint = Color.Black,
                    contentDescription = "Back"
                )
            }

            DoctorCard(
                image = painterResource(id = R.drawable.doctor1),
                doctorName = "dr. Gilang Segara Bening",
                specilization = "Heart",
                hospitalName = "Persahabatan Hospital",
                rating = 1221,
                status = "Open",
                onClick = {
                    DoctorDetails()
                }
            )
            DoctorCard(
                image = painterResource(id = R.drawable.doctor2),
                doctorName = "dr. Shabil Chan",
                specilization = "Dental",
                hospitalName = "Columbia Asia Hospital",
                rating = 964,
                status = "Open",
                onClick = {
                    DoctorDetails()
                }
            )
            DoctorCard(
                image = painterResource(id = R.drawable.doctor3),
                doctorName = "dr. Mustakim",
                specilization = "Eye",
                hospitalName = "Salemba Carolus Hospital",
                rating = 762,
                status = "Close",
                onClick = {
                    DoctorDetails()
                }
            )
            DoctorCard(
                image = painterResource(id = R.drawable.doctor4),
                doctorName = "dr. Suprihatini",
                specilization = "Heart",
                hospitalName = "Salemba Carolus Hospital",
                rating = 651,
                status = "Open",
                onClick = {
                    DoctorDetails()
                }
            )

            DoctorCard(
                image = painterResource(id = R.drawable.doctor2),
                doctorName = "dr. Maria Rodriguez",
                specilization = "Dental",
                hospitalName = "Persahabatan Hospital",
                rating = 603,
                status = "Open",
                onClick = {
                    DoctorDetails()
                }
            )
            DoctorCard(
                image = painterResource(id = R.drawable.doctor4),
                doctorName = "dr. Aisha Patel",
                specilization = "Eye",
                hospitalName = "Columbia Asia Hospital",
                rating = 571,
                status = "Close",
                onClick = {
                    DoctorDetails()
                }
            )
            DoctorCard(
                image = painterResource(id = R.drawable.doctor1),
                doctorName = "dr. John Smith",
                specilization = "Heart",
                hospitalName = "Salemba Carolus Hospital",
                rating = 505,
                status = "Open",
                onClick = {
                    DoctorDetails()
                }
            )
            DoctorCard(
                image = painterResource(id = R.drawable.doctor3),
                doctorName = "dr. Michael Jones",
                specilization = "Heart",
                hospitalName = "Salemba Carolus Hospital",
                rating = 473,
                status = "Close",
                onClick = {
                    DoctorDetails()
                }
            )
        }
    }
}