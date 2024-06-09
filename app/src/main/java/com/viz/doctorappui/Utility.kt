package com.viz.doctorappui

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import kotlin.random.Random

// In this file we write codes for DoctorCard and ImageButton
@Preview(showBackground = true)
@Composable
fun SearchBar() {
    var text by remember { mutableStateOf("") }

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(end = 16.dp),
        shape = RoundedCornerShape(8.dp),
        color = Color(0xFFF5F5F5)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextField(
                value = text,
                onValueChange = { text = it },
                placeholder = { Text(text = "Search doctor, medicines etc", color = Color(0xFFC1C1C1)) },
//                colors = TextFieldDefaults.textFieldColors(
//                    backgroundColor = Color.Transparent,
//                    focusedIndicatorColor = Color.Transparent,
//                    unfocusedIndicatorColor = Color.Transparent,
//                    cursorColor = Color(0xFF25282B)
//                ),
                modifier = Modifier.weight(1f)
            )
            Icon(
                imageVector = Icons.Outlined.Search, // Ensure you have the search icon drawable
                contentDescription = "Search Icon",
                tint = Color(0xFF25282B),
                modifier = Modifier.size(24.dp)
            )
        }
    }
}




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
            Text(text = title, modifier = Modifier.align(Alignment.CenterHorizontally), fontSize = 12.sp)
            Spacer(modifier = Modifier.padding(8.dp))
        }

}





//@SuppressLint("InvalidColorHexValue")
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


@Composable
fun SlotButton(
    time: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    enabled: Boolean
) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .padding(4.dp)
            .size(120.dp, 60.dp),
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.White,
            containerColor = if (isSelected) Color(0xFF639AFF) else Color.White,
            disabledContainerColor = Color.Gray
        ),
        enabled = enabled,
        border = BorderStroke(1.dp, Color.Gray)
    ) {
        Text(
            text = time,
            color = if (enabled) Color(0xFF404345) else Color.LightGray,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun SlotButtonGroup(times: List<String>) {
    var selectedButton by remember { mutableStateOf(-1) }

    val randomStatus = times.map { Random.nextBoolean() }

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        itemsIndexed(times) { index, time ->
            SlotButton(
                time = time,
                isSelected = index == selectedButton,
                onClick = { selectedButton = index },
                enabled = randomStatus[index]
            )
        }
    }
}
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
