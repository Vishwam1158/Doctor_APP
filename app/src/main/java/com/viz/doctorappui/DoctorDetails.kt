package com.viz.doctorappui

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

data class DoctorData(
    val id : Int,
    val image : Painter,
    val doctorName : String,
    val specilization : String,
    val hospitalName : String,
    val description : String,
    val patient : Int,
    val status : String
)



@SuppressLint("UnrememberedMutableState")
@Composable
fun DoctorDetails(id: Int?, navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 28.dp, start = 4.dp)
            .verticalScroll(rememberScrollState())
    ) {
        val doctorsList =
            listOf(
                DoctorData(
                    id = 1,
                    image = painterResource(id = R.drawable.doctor1),
                    doctorName = "dr. Gilang Segara Bening",
                    specilization = "Heart",
                    hospitalName = "Persahabatan Hospital",
                    description = "dr. Gilang is one of the best doctors in the Persahabatan Hospital. He has saved more than 1000 patients in the past 3 years. He has also received many awards from domestic and abroad as the best doctors. He is available on a private or schedule. ",
                    patient = 1221,
                    status = "Open",
                ),
                DoctorData(
                    id = 2,
                    image = painterResource(id = R.drawable.doctor2),
                    doctorName = "dr. Shabil Chan",
                    specilization = "Dental",
                    hospitalName = "Columbia Asia Hospital",
                    description = "dr. Gilang is one of the best doctors in the Persahabatan Hospital. He has saved more than 1000 patients in the past 3 years. He has also received many awards from domestic and abroad as the best doctors. He is available on a private or schedule. ",
                    patient = 964,
                    status = "Open",
                ),
                DoctorData(
                    id = 3,
                    image = painterResource(id = R.drawable.doctor3),
                    doctorName = "dr. Mustakim",
                    specilization = "Eye",
                    hospitalName = "alemba Carolus Hospital",
                    description = "dr. Gilang is one of the best doctors in the Persahabatan Hospital. He has saved more than 1000 patients in the past 3 years. He has also received many awards from domestic and abroad as the best doctors. He is available on a private or schedule. ",
                    patient = 762,
                    status = "Close",
                ),
                DoctorData(
                    id = 4,
                    image = painterResource(id = R.drawable.doctor4),
                    doctorName = "dr. Suprihatini",
                    specilization = "Heart",
                    hospitalName = "Salemba Carolus  Hospital",
                    description = "dr. Gilang is one of the best doctors in the Persahabatan Hospital. He has saved more than 1000 patients in the past 3 years. He has also received many awards from domestic and abroad as the best doctors. He is available on a private or schedule. ",
                    patient = 651,
                    status = "Open",
                ),
                DoctorData(
                    id = 5,
                    image = painterResource(id = R.drawable.doctor2),
                    doctorName = "dr. Maria Rodriguez",
                    specilization = "Heart",
                    hospitalName = "Supernatants Hospital",
                    description = "dr. Gilang is one of the best doctors in the Persahabatan Hospital. He has saved more than 1000 patients in the past 3 years. He has also received many awards from domestic and abroad as the best doctors. He is available on a private or schedule. ",
                    patient = 603,
                    status = "Open",
                ),
                DoctorData(
                    id = 6,
                    image = painterResource(id = R.drawable.doctor4),
                    doctorName = "dr. Aisha Patel",
                    specilization = "Eye",
                    hospitalName = "Columbia Asia  Hospital",
                    description = "dr. Gilang is one of the best doctors in the Persahabatan Hospital. He has saved more than 1000 patients in the past 3 years. He has also received many awards from domestic and abroad as the best doctors. He is available on a private or schedule. ",
                    patient = 571,
                    status = "Close",
                ),
                DoctorData(
                    id = 7,
                    image = painterResource(id = R.drawable.doctor1),
                    doctorName = "dr. John Smith",
                    specilization = "Heart",
                    hospitalName = "Salemba Carolus  Hospital",
                    description = "dr. Gilang is one of the best doctors in the Persahabatan Hospital. He has saved more than 1000 patients in the past 3 years. He has also received many awards from domestic and abroad as the best doctors. He is available on a private or schedule. ",
                    patient = 505,
                    status = "Open",
                ),
                DoctorData(
                    id = 8,
                    image = painterResource(id = R.drawable.doctor3),
                    doctorName = "dr. Michael Jones",
                    specilization = "Dental",
                    hospitalName = "Salemba Carolus Hospital",
                    description = "dr. Gilang is one of the best doctors in the Persahabatan Hospital. He has saved more than 1000 patients in the past 3 years. He has also received many awards from domestic and abroad as the best doctors. He is available on a private or schedule. ",
                    patient = 473,
                    status = "Close",
                ),
            )


        val doctor = doctorsList.find { it.id == id } ?: return
        var currentIcon by mutableStateOf(Icons.Filled.FavoriteBorder)

        Box {
            Image(
                painter = doctor.image,
                contentDescription = "Doctor Image",
                modifier = Modifier.size(height = 475.dp, width = 475.dp)
            )

            Button(
                onClick = { navController.popBackStack() },
                colors = ButtonDefaults.buttonColors(Color.Transparent)
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    tint = Color.Black,
                    contentDescription = "Back"
                )
            }

            Button(
                onClick = {
                    currentIcon = if (currentIcon == Icons.Filled.Favorite) {
                        Icons.Filled.FavoriteBorder
                    } else {
                        Icons.Filled.Favorite
                    }
//                          navController.popBackStack()
                },
                modifier = Modifier.align(Alignment.TopEnd),
                colors = ButtonDefaults.buttonColors(Color.Transparent)
            ) {
                Icon(
//                    imageVector = Icons.Filled.FavoriteBorder,
                    imageVector = currentIcon,
                    tint = Color.Black,
                    contentDescription = "Bookmark")
            }
        }

        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = doctor.doctorName,
                color = Color(color = 0xFF25282B),
                fontSize = 32.sp,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Row(
                modifier = Modifier.padding(top = 16.dp, bottom = 16.dp)
            ){
                Text(
                    text = doctor.specilization,
                    fontSize = 15.sp,
                    color = Color(0xFFAAAAAA)
                )

                Spacer(Modifier.width(8.dp))
                Image(
                    painter = painterResource(id = R.drawable.circle),
                    contentDescription = "circle",
                    modifier = Modifier
                        .padding(top = 9.dp)
                        .size(4.dp, 4.dp),
                )

                Spacer(Modifier.width(8.dp))
                Text(
                    text = doctor.hospitalName,
                    fontSize = 15.sp,
                    color = Color(0xFFAAAAAA)
                )
            }

            Spacer(Modifier.height(8.dp))
            Text(
                text = doctor.description,
                fontSize = 15.sp,
                color = Color(0xFFAAAAAA),
                textAlign = TextAlign.Justify
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    "Experience",
                    color = Color(color = 0xFF25282B),
                    fontSize = 24.sp,
                )

                Row(
                    modifier = Modifier.padding(top = 16.dp)
                ) {
                    Text(text = "3", fontSize = 32.sp, color = Color(color = 0xFF2B92E4))
                    Text(
                        text = "yr",
                        modifier = Modifier.padding(start = 6.dp,top = 10.dp),
                        fontSize = 20.sp,
                        color = Color(0xFFAAAAAA)
                    )
                }
            }

            VerticalLine()

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    "Patient",
                    color = Color(color = 0xFF25282B),
                    fontSize = 24.sp,
                )

                Row(
                    modifier = Modifier.padding(top = 16.dp)
                ) {
                    Text(text = doctor.patient.toString(), fontSize = 32.sp, color = Color(color = 0xFF2B92E4))
                    Text(
                        text = "ps",
                        modifier = Modifier.padding(start = 6.dp,top = 10.dp),
                        fontSize = 20.sp,
                        color = Color(0xFFAAAAAA)
                    )
                }
            }

            VerticalLine()
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    "Rating",
                    color = Color(color = 0xFF25282B),
                    fontSize = 24.sp,
                )
                Row(
                    modifier = Modifier.padding(top = 16.dp)
                ) {
                    if(doctor.id % 2 != 0) {
                        Text(text = "5.0", fontSize = 32.sp, color = Color(color = 0xFF2B92E4))
                    } else {
                        Text(text = "4.8", fontSize = 32.sp, color = Color(color = 0xFF2B92E4))
                    }
                }
            }

        }
        Spacer(Modifier.height(12.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
        ) {
            CustomImageButton(backgroundColor = Color(0xff4485FD), icon = painterResource(id = R.drawable.icons_comment), title = "", navController = navController)

            Button(onClick = {
                             navController.navigate(Screen.Appointment.route)
            },
                colors = ButtonDefaults.buttonColors(Color(0xff00CC6A)),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp)
                    .height(64.dp)
            ) {
                Text(text = "Make an Appointment", fontSize = 20.sp)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun Preview() {
    DoctorDetails(id=1,navController = NavHostController(LocalContext.current))

}


////For Testing
//@Composable
//fun DoctorDetails(id: Int?, navController: NavHostController) {
//    Column {
//        Text(text = "hello $id")
//    }
//}

@Composable
fun VerticalLine(
    color: Color = Color(0XFFCACCCF),
    width: Dp = 1.dp,
    height: Dp = 100.dp
) {
    Box(
        modifier = Modifier
            .padding(start = 8.dp, end = 4.dp)
            .width(width)
            .height(height)
            .background(color)
    )
}