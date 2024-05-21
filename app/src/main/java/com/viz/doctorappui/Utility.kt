package com.viz.doctorappui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.core.widgets.Rectangle as Rectangle1

// In this file we write codes for Searchbar and ImageButton

//@Composable
//fun SerchBar() {
//
//}

@Composable
fun CustomImageButton(backgroundColor : Color, icon : Painter, title : String ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .size(64.dp, 64.dp)
                    .clip(RoundedCornerShape(10.dp)) // must declare brfore the background coloe
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





@Composable
fun DoctorCard(
    image : Painter,
    doctorName : String,
    specilization : String,
    hospitalName : String,
    rating : Int,
    status : String,
    onClick: @Composable () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp, bottom = 5.dp)
            .clickable { onClick },
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
            Column(
            ) {
                //doctor name
                Text(
                    text = doctorName,
                    fontSize = 20.sp,
                    color = Color(0xFF404345)
                    )
                Spacer(modifier = Modifier.padding(1.dp))

                // specilization and hospital name
                Row() {
                    Text(
                        text = specilization,
                        fontSize = 15.sp,
                        color = Color(0xFFAAAAAA)
                    )

                    Spacer(modifier = Modifier.padding(8.dp))
                    Image(
                        painter = painterResource(id = R.drawable.circle),
                        contentDescription = "circle",
                        modifier = Modifier
                            .padding(top = 9.dp)
                            .size(4.dp, 4.dp),
                    )

                    Spacer(modifier = Modifier.padding(8.dp))
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
//                        RoundedCornerButton(text = "Open", btnColor = Color(0xFFCCF5E1), txtColor = Color(0xFF00CC6A), onClick = {})
                        Button(
                            onClick = {  },
                            shape = RoundedCornerShape(12.dp), // Adjust the corner radius as needed
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
//                        RoundedCornerButton(text = "Close", btnColor = Color(0xFFFF7E4D9), txtColor = Color(0xFFCC4900), onClick = {})
                        Button(
                            onClick = {  },
                            shape = RoundedCornerShape(12.dp), // Adjust the corner radius as needed
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


@Preview(showBackground = true)
@Composable
private fun Preview() {
//    CustomImageButton(
//        backgroundColor = Color(0xFF639AFF),
//        icon = painterResource(id = R.drawable.menu),
//        title = "Menu"
//    )

    DoctorCard(
        image = painterResource(id = R.drawable.doctor1),
        doctorName = "dr. Gilang Segara Bening",
        specilization = "Heart",
        hospitalName = "Persahabatan Hospital",
        rating = 1221,
        status = "Open",
        onClick = {
            DoctorDetails()
        })


}


