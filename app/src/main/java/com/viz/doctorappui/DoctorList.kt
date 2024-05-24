package com.viz.doctorappui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController


@Composable
fun DoctorList(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(top = 52.dp, start = 4.dp)
        ) {

            Button(
                onClick = { navController.navigate(Routes.homeScreen) },
                colors = ButtonDefaults.buttonColors(Color.Transparent)
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    tint = Color.Black,
                    contentDescription = "Back"
                )
            }

            Spacer(modifier = Modifier.padding(top = 8.dp))
           
            TopDoctors(navController = navController)

            DoctorCard(
                id = 5,
                image = painterResource(id = R.drawable.doctor2),
                doctorName = "dr. Maria Rodriguez",
                specilization = "Heart",
                hospitalName = "Supernatants Hospital",
                rating = 603,
                status = "Open",
                navController = navController
            )
            DoctorCard(
                id = 6,
                image = painterResource(id = R.drawable.doctor4),
                doctorName = "dr. Aisha Patel",
                specilization = "Eye",
                hospitalName = "Columbia Asia Hospital",
                rating = 571,
                status = "Close",
                navController = navController
            )
            DoctorCard(
                id = 7,
                image = painterResource(id = R.drawable.doctor1),
                doctorName = "dr. John Smith",
                specilization = "Heart",
                hospitalName = "Salemba Carolus Hospital",
                rating = 505,
                status = "Open",
                navController = navController
            )
            DoctorCard(
                id = 8,
                image = painterResource(id = R.drawable.doctor3),
                doctorName = "dr. Michael Jones",
                specilization = "Dental",
                hospitalName = "Salemba Carolus Hospital",
                rating = 473,
                status = "Close",
                navController = navController
            )
        }
    }
}


@Composable
fun TopDoctors(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {



        DoctorCard(
            id = 1,
            image = painterResource(id = R.drawable.doctor1),
            doctorName = "dr. Gilang Segara Bening",
            specilization = "Heart",
            hospitalName = "Persahabatan Hospital",
            rating = 1221,
            status = "Open",
            navController = navController
        )
        DoctorCard(
            id = 2,
            image = painterResource(id = R.drawable.doctor2),
            doctorName = "dr. Shabil Chan",
            specilization = "Dental",
            hospitalName = "Columbia Asia Hospital",
            rating = 964,
            status = "Open",
            navController = navController
        )
        DoctorCard(
            id = 3,
            image = painterResource(id = R.drawable.doctor3),
            doctorName = "dr. Mustakim",
            specilization = "Eye",
            hospitalName = "Salemba Carolus Hospital",
            rating = 762,
            status = "Close",
            navController = navController
        )
        DoctorCard(
            id = 4,
            image = painterResource(id = R.drawable.doctor4),
            doctorName = "dr. Suprihatini",
            specilization = "Heart",
            hospitalName = "Salemba Carolus Hospital",
            rating = 651,
            status = "Open",
            navController = navController
        )
    }
}
