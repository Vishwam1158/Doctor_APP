package com.viz.doctorappui

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.maxkeppeker.sheets.core.models.base.rememberSheetState
import com.maxkeppeler.sheets.calendar.CalendarDialog
import com.maxkeppeler.sheets.calendar.models.CalendarConfig
import com.maxkeppeler.sheets.calendar.models.CalendarSelection


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Appointment(navController : NavHostController) {
    val localContext = LocalContext.current

    var patientName by rememberSaveable { mutableStateOf("")}
    var patientSurname by rememberSaveable { mutableStateOf("")}
    var patientAddress by rememberSaveable { mutableStateOf("")}
    var patientWeight by rememberSaveable { mutableStateOf("")}
    var patientHeight by rememberSaveable { mutableStateOf("")}

    var selectedDate by remember { mutableStateOf("Select Date") }
    val calendarState = rememberSheetState()

    CalendarDialog(
        state = calendarState,
        config = CalendarConfig(

        ),
        selection = CalendarSelection.Date{ date->
            // Parse and format the date to dd-MM-yyyy
//            val parsedDate = LocalDate.parse(date.toString())
//            val formattedDate = parsedDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
            // Update the selected date state
//            selectedDate = formattedDate
            selectedDate = date.toString()
        } )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 34.dp, start = 4.dp)
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
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    tint = Color.Black,
                    contentDescription = "Back"
                )
            }
            Spacer(modifier = Modifier.width(26.dp))
            Text(
                text = "Make an Appointment",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = Color(0xFF404345)
            )
        }

        // Details

        Column(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
//                .fillMaxWidth()
        ) {
            Text(text = "Enter the Patient Details : ", fontWeight = FontWeight.SemiBold, fontSize = 16.sp)
            Spacer(modifier = Modifier.height(12.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                OutlinedTextField(
                    modifier = Modifier.weight(1f),
                    value = patientName,
                    onValueChange = {patientName = it},
                    label = { Text(text = "Name") }
                )
                Spacer(modifier = Modifier.width(20.dp))
                OutlinedTextField(
                    modifier = Modifier.weight(1f),
                    value = patientSurname,
                    onValueChange = {patientSurname = it},
                    label = { Text(text = "Surname") }
                )
            }

            Spacer(modifier = Modifier.height(12.dp))
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = patientAddress,
                onValueChange = {patientAddress = it},
                label = { Text(text = "Address") }
            )
            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                OutlinedTextField(
                    modifier = Modifier.weight(1f),
                    value = patientWeight,
                    onValueChange = {patientWeight = it},
                    label = { Text(text = "Weight")},
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    suffix = { Text(text = "Kg")}
                )
                Spacer(modifier = Modifier.width(20.dp))
                OutlinedTextField(
                    modifier = Modifier.weight(1f),
                    value = patientHeight ,
                    onValueChange = {patientHeight = it},
                    label = { Text(text = "Height") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    suffix = { Text(text = "Cm")}
                )
            }
            Spacer(modifier = Modifier.height(12.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = { calendarState.show()  },
                    colors = ButtonDefaults.buttonColors(Color.White),
                    border = ButtonDefaults.outlinedButtonBorder,
                    shape = RoundedCornerShape(6.dp)
                ) {
                    Text(text = selectedDate, color = Color.Black, fontSize = 16.sp)
                    Spacer(modifier = Modifier.width(10.dp))
                    Icon(imageVector = Icons.Outlined.ShoppingCart, contentDescription = "Back", tint = Color.Black)
                }
            }
        }

        //Time slots
        Spacer(modifier = Modifier.width(10.dp))
        Column(
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp)
        ) {

            Text(text = "Time slots", fontSize = 16.sp)
            SlotButtonGroup(
                times = listOf(
                    "09:00 AM", "10:00 AM", "11:00 AM", "12:00 PM", "03:00 PM", "04:00 PM", "05:00 PM", "06:00 PM"
                )
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                modifier = Modifier.width(220.dp),
                onClick = {
                    if (patientName.isEmpty() || patientSurname.isEmpty() || patientAddress.isEmpty() || patientWeight.isEmpty() || patientHeight.isEmpty()) {
                        Toast.makeText(localContext, "Fill All the details", Toast.LENGTH_SHORT).show()
                    }
                    else {
                        Toast.makeText(localContext, "Appointment Booked Successfully", Toast.LENGTH_SHORT).show()
                    }
                },
                colors = ButtonDefaults.buttonColors(Color(0xff00CC6A)),
                border = ButtonDefaults.outlinedButtonBorder,
                shape = RoundedCornerShape(6.dp)
            ) {
                Text(text = "Next", color = Color(0xFF25282B), fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
private fun AppointmentPreview() {
    Appointment(navController = NavHostController(LocalContext.current))
}