package com.viz.doctorappui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview(showBackground = true)
@Composable
fun TopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 64.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
        ) {
            Spacer(modifier = Modifier.padding(start = 24.dp))
            Icon(
                painter = painterResource(id = R.drawable.menu),
                contentDescription = "Menu Button",
                modifier = Modifier
                    .size(24.dp, 24.dp)
                    .align(alignment = Alignment.CenterVertically)
            )


        }

        Row(
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 24.dp)

        ) {
            Icon(
                imageVector = Icons.Rounded.AccountCircle,
                contentDescription = "Menu Button",
                modifier = Modifier
                    .size(36.dp,36.dp)

            )
        }
    }
}