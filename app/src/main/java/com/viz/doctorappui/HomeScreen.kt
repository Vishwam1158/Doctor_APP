package com.viz.doctorappui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController

@Preview(showBackground = true)
@Composable
fun HomeScreen() {
    Scaffold(
        topBar = {
//            Spacer(modifier = Modifier.padding(8.dp))
            TopBar()
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            ) {
//                ContentBar(navController = NavHostController(LocalContext.current))
            Navigation()


            }


        }
    )
}



