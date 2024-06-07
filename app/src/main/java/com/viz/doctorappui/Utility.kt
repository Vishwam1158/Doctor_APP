package com.viz.doctorappui

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

// In this file we write codes for DoctorCard and ImageButton


@Composable
fun CustomImageButton(backgroundColor : Color, icon : Painter, title : String, navController: NavHostController) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            IconButton(
                onClick = {
                    navController.navigate(Screen.ButtonClick.route)
                },
                modifier = Modifier
                    .size(64.dp, 64.dp)
                    .clip(RoundedCornerShape(10.dp)) // must declare before the background color
                    .background(color = backgroundColor)
            ) {
                Icon(
                    painter = icon,
                    contentDescription = "Image Button of $title",
                    tint = Color.White
                )
            }
            Spacer(modifier = Modifier.padding(4.dp))
            Text(text = title, modifier = Modifier.align(Alignment.CenterHorizontally))
            Spacer(modifier = Modifier.padding(8.dp))
        }

}





@SuppressLint("InvalidColorHexValue")
@Composable
fun DoctorCard(
    id : Int,
    image : Painter,
    doctorName : String,
    specilization : String,
    hospitalName : String,
    rating : Int,
    status : String,
    navController: NavHostController
//    onClick: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp, bottom = 8.dp)
            .clickable(onClick = { navController.navigate(Screen.DoctorDetails.withArgs(id)) }),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            //left side - Image
            Image(
                painter = image,
                modifier = Modifier
                    .size(88.dp, 80.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color(0xFFEAEAEA)),
                        contentDescription = "Doctor Image")
            Spacer(modifier = Modifier.padding(8.dp))

            // right side part
            Column {
                //doctor name
                Text(
                    text = doctorName,
                    fontSize = 20.sp,
                    color = Color(0xFF404345)
                    )
                Spacer(modifier = Modifier.padding(1.dp))

                // specilization and hospital name
                Row {
                    Text(
                        text = specilization,
                        fontSize = 15.sp,
                        color = Color(0xFFAAAAAA)
                    )

                    Spacer(Modifier.height(8.dp))
                    Image(
                        painter = painterResource(id = R.drawable.circle),
                        contentDescription = "circle",
                        modifier = Modifier
                            .padding(top = 9.dp)
                            .size(4.dp, 4.dp),
                    )

                    Spacer(Modifier.height(8.dp))
                    Text(
                        text = hospitalName,
                        fontSize = 15.sp,
                        color = Color(0xFFAAAAAA)
                    )
                }

                // rating and status
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(painter = painterResource(id = R.drawable.rating_5_star), contentDescription = "5 star rating")
                    Spacer(modifier = Modifier.padding(5.dp))
                    Text(
                        text = "($rating)",
                        fontSize = 15.sp,
                        color = Color(0xFFAAAAAA))

                    Spacer(modifier = Modifier.padding(12.dp))
                    if (status == "Open") {
                        Button(
                            onClick = {  },
                            shape = RoundedCornerShape(12.dp),
                            colors = ButtonDefaults.buttonColors(Color(0xFFCCF5E1)),
                        ) {
                            Text(
                                text = "Open",
                                style = TextStyle(color = Color(0xFF00CC6A)),
                                fontSize = 16.sp,
                            )
                        }
                    }
                    else {
                        Button(
                            onClick = {  },
                            shape = RoundedCornerShape(12.dp),
                            colors = ButtonDefaults.buttonColors(Color(0xFFFF7E4D9)),
                        ) {
                            Text(
                                text = "Close",
                                style = TextStyle(color = Color(0xFFCC4900)),
                                fontSize = 16.sp,
                            )
                        }
                    }
                }
            }
        }
    }
}


//Appointment slot button
@Composable
fun SlotButton(time : String) {
    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier.padding(4.dp),
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(Color(0xffffffff)),
        border = ButtonDefaults.outlinedButtonBorder
    ) {
        Text(text = time, color = Color(0xFF404345), fontSize = 16.sp)
    }
}

//
//@Preview(showBackground = true)
//@Composable
//private fun Preview() {
////    CustomImageButton(
////        backgroundColor = Color(0xFF639AFF),
////        icon = painterResource(id = R.drawable.menu),
////        title = "Menu"
////    )
//
//    DoctorCard(
//        id = 1,
//        image = painterResource(id = R.drawable.doctor1),
//        doctorName = "dr. Golang Segura Beaning",
//        specilization = "Heart",
//        hospitalName = "Supernatants Hospital",
//        rating = 1221,
//        status = "Open",
//        onClick = {
//            DoctorDetails(navController)
//        })
//  
//    SlotButton(time = "10:00 AM")
//}


// CustomImageButton's optional code
//@Preview
//@Composable
//private fun CustomButton() {
//    Button(onClick = {},
//        shape = RoundedCornerShape(10.dp),
//        modifier = Modifier
//            .size(64.dp, 64.dp)
//            .clip(RoundedCornerShape(10.dp)) // must declare before the background color
//            .height(64.dp)
//            .width(64.dp)
//
//    ) {
//            Icon(
//                painter = painterResource(id = R.drawable.heart_03),
//                modifier = Modifier
//                    .height(32.dp)
//                    .width(32.dp),
//                contentDescription = "Image Button of ",
//                tint = Color.White
//            )
//
//    }
//
//}


