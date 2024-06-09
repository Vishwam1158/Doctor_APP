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
import androidx.compose.material3.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
fun HomeScreen(navController: NavHostController) {

    Column(
modifier = Modifier.fillMaxSize()
            ) {
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
                            CustomImageButton(backgroundColor = Color(0xFF639AFF), icon = painterResource(id = R.drawable.stethoscope_01), title = "Consultant", navController = navController)
                            CustomImageButton(backgroundColor = Color(0xFFA584FF), icon = painterResource(id = R.drawable.teeth_02), title = "Dental", navController = navController)
                            CustomImageButton(backgroundColor = Color(0xFFFF7854), icon = painterResource(id = R.drawable.heart_03), title = "Heart", navController = navController)
                            CustomImageButton(backgroundColor = Color(0xFFFEA725), icon = painterResource(id = R.drawable.clinic_04), title = "Hospitals", navController = navController)
                        }

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            CustomImageButton(backgroundColor = Color(0xFF1AD37A), icon = painterResource(id = R.drawable.medicine_05), title = "Medicines ", navController = navController)
                            CustomImageButton(backgroundColor = Color(0xFF05D1ED), icon = painterResource(id = R.drawable.care_06), title = "Physician", navController = navController)
                            CustomImageButton(backgroundColor = Color(0xFFFF71C6), icon = painterResource(id = R.drawable.bandage_07), title = "Skin", navController = navController)
                            CustomImageButton(backgroundColor = Color(0xFFFF7070), icon = painterResource(id = R.drawable.syringe_08), title = "Surgeon", navController = navController)
                        }
                    }
                    Spacer(modifier = Modifier.padding(18.dp))
                    // Top doctor text n view all button
                    Column(
                        modifier = Modifier.padding(start = 12.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(text = "Top Doctors", fontSize = 24.sp, color = Color(0XFF25282B))
                            Button(
                                onClick = {
                                    navController.navigate(Routes.DoctorList.route)
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
                        TopDoctors(navController = navController)
                    }
                }
            }
}
@Preview
@Composable
private fun HomeScreenPreview() {
    HomeScreen(navController = NavHostController(LocalContext.current))
}

//NavHostController(LocalContext.current)