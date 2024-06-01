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
//                    DoctorData(2, "Item 2", "Description of Item 2"),
//                    DoctorData(3, "Item 3", "Description of Item 3"),
//                    DoctorData(4, "Item 1", "Description of Item 1"),
//                    DoctorData(5, "Item 2", "Description of Item 2"),
//                    DoctorData(6, "Item 3", "Description of Item 3"),
//                    DoctorData(7, "Item 1", "Description of Item 1"),
//                    DoctorData(8, "Item 2", "Description of Item 2"),
                // Add more items here
            )


        val doctor = doctorsList.find { it.id == id } ?: return

        var currentIcon by mutableStateOf(Icons.Filled.FavoriteBorder)
//        val onClick = {
//            // Toggle the icon
//            currentIcon = if (currentIcon == Icons.Filled.Favorite) {
//                Icons.Filled.FavoriteBorder
//            } else {
//                Icons.Filled.Favorite
//            }
//        }
        Box(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
        ) {
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
                // Doctor details
//            val doctors = DoctorDetailsList().find { it.id == id } ?: return
//

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

@Preview(showBackground = true)
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