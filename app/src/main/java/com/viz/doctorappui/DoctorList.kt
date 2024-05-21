package com.viz.doctorappui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController

//class DoctorList {
//}

@Composable
fun DoctorList(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = "Doctor List is below")
        Button(onClick = { 
            navController.navigate(Routes.contentScreen)
        }) {
            Text(text = "Siomon Go Back")
        }
    }
}