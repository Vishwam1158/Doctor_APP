package com.viz.doctorappui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BottomBar(selectedRoute: String = Routes.HomeScreen.route, onChange: (String)->Unit = {}) {
    Row(
        modifier = Modifier
            .background(Color(0xFFCCF5E1))
            .padding(start = 12.dp, end = 12.dp, top = 8.dp, bottom = 18.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        for (page in Routes.pages) {
            NavBarItem(
                page = page,
                selected = selectedRoute == page.route,
//                selected = navController.currentDestination?.route == page.route,
                modifier = Modifier
                    .clickable {
                        onChange(page.route)
                    }
            )
        }
    }
}

@Composable
fun NavBarItem(page: NavPage, selected: Boolean = false, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(horizontal = 12.dp)
    ) {
        Image(
            imageVector = page.icon,
            contentDescription = page.name,
            colorFilter = ColorFilter.tint(
                if (selected) Color(0xFF639AFF) else Color(0xFF00CC6A)
            ),
            modifier = Modifier
                .padding(bottom = 8.dp)
                .size(24.dp)
        )
        Text(page.name,
            fontSize = 12.sp,
            color = if (selected) Color(0xFF639AFF) else Color(0xFF00CC6A)

        )
    }
}


@Preview
@Composable
private fun BottomBarPreview() {
    BottomBar(onChange = {})
}