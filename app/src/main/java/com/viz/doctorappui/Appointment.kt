package com.viz.doctorappui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController


@Composable
fun Appointment(navController : NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 28.dp, start = 4.dp)
            .verticalScroll(rememberScrollState())
    ) {
        //Back button row
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = { navController.navigate(Screen.HomeScreen.route) },
                colors = ButtonDefaults.buttonColors(Color.Transparent)
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    tint = Color.Black,
                    contentDescription = "Back"
                )
            }
            Spacer(modifier = Modifier.width(26.dp))
            Text(text = "Make an Appointment", fontSize = 24.sp)
        }

        //Calender

        //Time slots
        Spacer(modifier = Modifier.width(10.dp))
        Column(
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp)
        ) {
            Text(text = "Time slots", fontSize = 16.sp)
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                SlotButton(time = "09:00 AM")
                SlotButton(time = "10:00 AM")
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                SlotButton(time = "11:00 AM")
                SlotButton(time = "12:00 AM")
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                SlotButton(time = "03:00 PM")
                SlotButton(time = "04:00 PM")
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                SlotButton(time = "05:00 PM")
                SlotButton(time = "06:00 PM")
            }
        }

        Row(
            horizontalArrangement = Arrangement.Absolute.Center
        ) {
            SlotButton(time = "Next")
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AppointmentPreview() {
    Appointment(navController = NavHostController(LocalContext.current))
}