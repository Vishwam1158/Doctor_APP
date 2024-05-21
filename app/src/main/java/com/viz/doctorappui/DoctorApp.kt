package com.viz.doctorappui//package com.viz.doctorappui
//
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.shape.CircleShape
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.outlined.AccountCircle
//import androidx.compose.material.icons.outlined.Menu
//import androidx.compose.material.icons.outlined.Search
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.compose.ui.draw.clip
////import androidx.compose.ui.graphics.vector.ImageVector
////import androidx.compose.ui.res.vectorResource
////import com.example.app.R
//
////@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun SearchBar() {
//    var text by remember { mutableStateOf("") }
//
//    Surface(
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(56.dp),
//        shape = RoundedCornerShape(8.dp),
//        color = Color(0xFFF5F5F5)
//    ) {
//        Row(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(horizontal = 16.dp),
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            TextField(
//                value = text,
//                onValueChange = { text = it },
//                placeholder = { Text(text = "Search doctor, medicines etc", color = Color(0xFFC1C1C1)) },
////                colors = TextFieldDefaults.textFieldColors(
////                    backgroundColor = Color.Transparent,
////                    focusedIndicatorColor = Color.Transparent,
////                    unfocusedIndicatorColor = Color.Transparent,
////                    cursorColor = Color(0xFF25282B)
////                ),
//                modifier = Modifier.weight(1f)
//            )
//            Icon(
//                imageVector = Icons.Outlined.Search,
//                contentDescription = "Search Icon",
//                tint = Color(0xFF25282B),
//                modifier = Modifier.size(24.dp)
//            )
//        }
//    }
//}
//
//@Composable
//fun IconButtonSection() {
//    val icons = listOf(
//        IconItem("Consultation", R.drawable.menu),
//        IconItem("Dental", R.drawable.menu),
//        IconItem("Heart", R.drawable.menu),
//        IconItem("Hospitals", R.drawable.menu),
//        IconItem("Medicines", R.drawable.menu),
//        IconItem("Physician", R.drawable.menu),
//        IconItem("Skin", R.drawable.menu),
//        IconItem("Surgeon", R.drawable.menu)
//    )
//
//    Column {
//        icons.chunked(4).forEach { rowItems ->
//            Row(
//                modifier = Modifier.fillMaxWidth(),
//                horizontalArrangement = Arrangement.SpaceBetween,
//                verticalAlignment = Alignment.CenterVertically
//            ) {
//                rowItems.forEach { (label, iconRes) ->
//                    IconButton(onClick = { /* Handle icon click */ }) {
//                        Column(
//                            horizontalAlignment = Alignment.CenterHorizontally,
//                            verticalArrangement = Arrangement.Center
//                        ) {
//                            Icon(
//                                painter = painterResource(id = iconRes),
//                                contentDescription = label,
//                                modifier = Modifier
//                                    .size(48.dp)
//                                    .clip(RoundedCornerShape(8.dp))
//                                    .background(Color(0xFFF5F5F5))
//                                    .padding(8.dp)
//                            )
//                            Text(text = label, fontSize = 12.sp, fontWeight = FontWeight.Medium)
//                        }
//                    }
//                }
//            }
//        }
//    }
//}
//
//@Composable
//fun TopDoctorsSection() {
//    val doctors = listOf(
//        Triple("dr. Gilang Segara Bening", "Heart - Persahabatan Hospital", "Open"),
//        Triple("dr. Shabil Chan", "Dental - Columbia Asia Hospital", "Open"),
//        Triple("dr. Mustakim", "Eye - Salemba Carolus Hospital", "Close")
//    )
//
//    Column {
//        Text(
//            text = "Top Doctors",
//            fontSize = 20.sp,
//            fontWeight = FontWeight.Bold,
//            modifier = Modifier.padding(vertical = 8.dp)
//        )
//        Text(
//            text = "View all",
//            fontSize = 16.sp,
//            color = Color.Blue,
//            modifier = Modifier
//                .padding(vertical = 8.dp)
//                .align(Alignment.End)
//        )
//
//        doctors.forEach { (name, specialization, status) ->
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(vertical = 8.dp),
//                verticalAlignment = Alignment.CenterVertically
//            ) {
//                Image(
//                    imageVector = Icons.Outlined.Search,
//                    contentDescription = name,
//                    modifier = Modifier
//                        .size(56.dp)
//                        .clip(CircleShape)
//                        .background(Color.Gray)
//                )
//                Spacer(modifier = Modifier.width(8.dp))
//                Column(modifier = Modifier.weight(1f)) {
//                    Text(text = name, fontSize = 16.sp, fontWeight = FontWeight.Bold)
//                    Text(text = specialization, fontSize = 14.sp, color = Color.Gray)
//                }
//                Button(
//                    onClick = { /* Handle button click */ },
//                    colors = ButtonDefaults.buttonColors(
////                        backgroundColor = if (status == "Open") Color.Green else Color.Red
//                    )
//                ) {
//                    Text(text = status, color = Color.White)
//                }
//            }
//        }
//    }
//}
//
//@Composable
//fun MainScreen() {
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp)
//    ) {
//        Row(
//            modifier = Modifier.fillMaxWidth(),
//            horizontalArrangement = Arrangement.SpaceBetween,
//            verticalAlignment = Alignment.CenterVertically
//        ) {
//            IconButton(onClick = { /* Handle menu click */ }) {
//                Icon(
//                    imageVector = Icons.Outlined.Menu,
//                    contentDescription = "Menu"
//                )
//            }
//            Text(
//                text = "Find your doctor",
//                fontSize = 28.sp,
//                fontWeight = FontWeight.Bold
//            )
//            Image(
//                imageVector = Icons.Outlined.AccountCircle,
//                contentDescription = "User Avatar",
//                modifier = Modifier
//                    .size(40.dp)
//                    .clip(CircleShape)
//            )
//        }
//        Spacer(modifier = Modifier.height(16.dp))
//        SearchBar()
//        Spacer(modifier = Modifier.height(16.dp))
//        IconButtonSection()
//        Spacer(modifier = Modifier.height(16.dp))
//        TopDoctorsSection()
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun DoctorApp() {
//    MaterialTheme {
//        MainScreen()
//    }
//}
//
//
//data class IconItem(val name: String, val drawableId: Int)
