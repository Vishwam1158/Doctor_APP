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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

data class Doctor(
    val id: Int,
    val image: Int,
    val doctorName: String,
    val specilization: String,
    val hospitalName: String,
    val rating: Int,
    val status : String,
    val navController: NavHostController
)

// OLD CODE
@Composable
fun DoctorList(navController: NavHostController) {
    val doctors = listOf(
        Doctor(5, R.drawable.doctor2, "dr. Maria Rodriguez", "Heart", "Supernatants Hospital", 603,  "Open", navController),
        Doctor(6, R.drawable.doctor4, "dr. Aisha Patel", "Eye", "Columbia Asia Hospitall", 571,  "Close", navController),
        Doctor(7, R.drawable.doctor1, "dr. John Smith", "Heart", "Salemba Carolus Hospital", 505,  "Open", navController),
        Doctor(8, R.drawable.doctor3, "dr. Michael Jones", "Dental", "St. Mary's Hospital", 473,  "Close", navController),
        )

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(top = 24.dp, start = 4.dp)
        ) {

//            Button(
//                onClick = { navController.navigate(Screen.HomeScreen.route) },  //Screen.DoctorDetails.withArgs("5")
//                colors = ButtonDefaults.buttonColors(Color.Transparent)
//            ) {
//                Icon(
//                    imageVector = Icons.Filled.ArrowBack,
//                    tint = Color.Black,
//                    contentDescription = "Back"
//                )
//            }

            Spacer(modifier = Modifier.padding(top = 8.dp))

            TopDoctors(navController = navController)
            doctors.forEach { doctor ->
                DoctorCard(
                    id = doctor.id,
                    image = painterResource(id = doctor.image),
                    doctorName = doctor.doctorName,
                    specilization = doctor.specilization,
                    hospitalName = doctor.hospitalName,
                    rating = doctor.rating,
                    status = doctor.status,
                    navController = navController,
                )
            }
        }
    }
}


@Composable
fun TopDoctors(navController: NavHostController) {
    val doctors = listOf(
        Doctor(1, R.drawable.doctor1, "dr. Gilang Segara Bening", "Heart", "Persahabatan Hospital", 5, "Open", navController),
        Doctor(2, R.drawable.doctor2, "dr. Shabil Chan", "Dental", "Columbia Asia Hospital", 964,  "Open", navController),
        Doctor(3, R.drawable.doctor3, "dr. Mustakim", "Eye", "Salemba Carolus Hospital", 762,  "Close", navController),
        Doctor(4, R.drawable.doctor4, "dr. Suprihatini", "Heart", "Salemba Carolus Hospital", 651,  "Open", navController),
    )
        Column(
        modifier = Modifier.fillMaxWidth()
    ) {
            doctors.forEach { doctor ->
                DoctorCard(
                    id = doctor.id,
                    image = painterResource(id = doctor.image),
                    doctorName = doctor.doctorName,
                    specilization = doctor.specilization,
                    hospitalName = doctor.hospitalName,
                    rating = doctor.rating,
                    status = doctor.status,
                    navController = navController,
                )
            }
    }
}


@Composable
fun ButtonClick(navController: NavHostController) {
    Text(text = "This is a --- page")
}