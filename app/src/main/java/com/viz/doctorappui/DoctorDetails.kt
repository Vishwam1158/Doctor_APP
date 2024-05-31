package com.viz.doctorappui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

data class DoctorData(
    val id : Int,
//    val image : Painter,
    val doctorName : String,
    val specilization : String,
//    val hospitalName : String,
//    val rating : Int,
)

//
//@Composable
//fun DoctorDetails(id: Int?, navController: NavHostController) {
//    Column(
//        modifier = Modifier.fillMaxWidth()
//    ) {
//        Column(
//            modifier = Modifier
//                .verticalScroll(rememberScrollState())
//                .padding(top = 52.dp, start = 4.dp)
//        ) {
//            Button(
//                onClick = {
//                    navController.popBackStack()
//                },
//                colors = ButtonDefaults.buttonColors(Color.Transparent)
//            ) {
//                Icon(
//                    imageVector = Icons.Filled.ArrowBack,
//                    tint = Color.Black,
//                    contentDescription = "Back"
//                )
//            }
//
//
//            Text(text = "Doctor Details")
//
//            // Doctor details
//
//            val doctors = remember {
//                listOf(
//                    DoctorData(1, "Item 1", "Description of Item 1"),
//                    DoctorData(2, "Item 2", "Description of Item 2"),
//                    DoctorData(3, "Item 3", "Description of Item 3"),
//                    DoctorData(4, "Item 1", "Description of Item 1"),
//                    DoctorData(5, "Item 2", "Description of Item 2"),
//                    DoctorData(6, "Item 3", "Description of Item 3"),
//                    DoctorData(7, "Item 1", "Description of Item 1"),
//                    DoctorData(8, "Item 2", "Description of Item 2"),
//                    // Add more items here
//                )
//            }
//
//            val doctor = doctors.find { it.id == id } ?: return
//
//            Column(modifier = Modifier.padding(16.dp)) {
//                Text(text = doctor.doctorName )
//                Text(text = doctor.specilization)
//            }
//
//
//
//
//        }
//    }
//}

//@Preview(showBackground = true)
//@Composable
//private fun Preview() {
//    DoctorDetails(navController = NavHostController(LocalContext.current))
//}


//For Testing
@Composable
fun DoctorDetails(name: String?, navController: NavHostController) {
    Column {
        Text(text = "hello $name")
    }
}