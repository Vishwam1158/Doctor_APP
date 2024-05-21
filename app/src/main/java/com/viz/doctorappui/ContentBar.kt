package com.viz.doctorappui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun ContentBar(navController: NavHostController) {
    Column(
        modifier = Modifier
            .padding(start = 18.dp, top = 24.dp, end = 16.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {

        Row {
            Text(
                text = "Find ",
                fontSize = 32.sp,
                color = Color(0XFF25282B)
            )
            Text(
                text = "your Doctor",
                fontSize = 32.sp,
                color = Color(0XFFA0A4A8)
            )
        }

        Spacer(modifier = Modifier.padding(8.dp))
        SearchBar()

        Spacer(modifier = Modifier.padding(18.dp))
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                CustomImageButton(backgroundColor = Color(0xFF639AFF), icon = painterResource(id = R.drawable.stethoscope_01), title = "Consult")
                CustomImageButton(backgroundColor = Color(0xFFA584FF), icon = painterResource(id = R.drawable.teeth_02), title = "Dental")
                CustomImageButton(backgroundColor = Color(0xFFFF7854), icon = painterResource(id = R.drawable.heart_03), title = "Heart")
                CustomImageButton(backgroundColor = Color(0xFFFEA725), icon = painterResource(id = R.drawable.clinic_04), title = "Hospitals")
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                CustomImageButton(backgroundColor = Color(0xFF1AD37A), icon = painterResource(id = R.drawable.medicine_05), title = "Medicines")
                CustomImageButton(backgroundColor = Color(0xFF05D1ED), icon = painterResource(id = R.drawable.care_06), title = "Physician")
                CustomImageButton(backgroundColor = Color(0xFFFF71C6), icon = painterResource(id = R.drawable.bandage_07), title = "Skin")
                CustomImageButton(backgroundColor = Color(0xFFFF7070), icon = painterResource(id = R.drawable.syringe_08), title = "Surgeon")
            }
        }
        Spacer(modifier = Modifier.padding(18.dp))
        Column(
            modifier = Modifier.padding(start = 12.dp)
        ) {
            // Top doctor text n view all button
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Top Doctors", fontSize = 24.sp, color = Color(0XFF25282B))

//                val showDoctorList = remember { mutableStateOf(false) }

                Button(
                    onClick = {
                              navController.navigate(Routes.doctorList)
                    },
                    colors = ButtonDefaults.buttonColors( Color(0x00000000)),
                ) {
                    Text(
                        text = "view all",
                        style = TextStyle(color = Color(0xFF4485FD)),
                        fontSize = 16.sp,
                    )
                }



            }
            Spacer(modifier = Modifier.padding(12.dp))
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
        }
    }


}


@Preview(showBackground = true)
@Composable
private fun ContentBarPreview() {
ContentBar(navController = NavHostController(LocalContext.current))
}