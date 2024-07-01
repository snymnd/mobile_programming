package com.example.loginpage

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HistoryScreen(
    navController: NavController
){
    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController)
        },

        ) {
        Column {
            UserProfile()
            SaldoCard(saldo = "Rp.50.000", navController)

            TransactionList()
        }

    }
}
@Composable
fun TransactionItem(
    avatar: Int,
    name: String,
    date: String,
    time: String,
    amount: String,
    type: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = avatar),
            contentDescription = "Avatar",
            modifier = Modifier
                .size(60.dp),
            contentScale = ContentScale.Crop,
        )

        Spacer(modifier = Modifier.width(8.dp))

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = name,
                style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                fontSize = 16.sp
            )
            Row {
                Text(
                    text = date,
                    style = MaterialTheme.typography.bodySmall,
                    fontSize = 12.sp
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = time,
                    style = MaterialTheme.typography.bodySmall,
                    fontSize = 12.sp
                )
            }
        }

        if (type == "+") {
            Text(
                text = "$type $amount",
                color = Color.Green,
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
                fontSize = 16.sp
            )
        } else {
            Text(
                text = "$type $amount",
                color = Color.Red,
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Bold),
                fontSize = 16.sp
            )
        }
    }
}
@Composable
fun TransactionList() {
    Column (modifier = Modifier.padding(10.dp)) {
        TransactionItem(
            avatar = R.drawable.ic_avatar_placeholder, // Replace with your actual avatar resource
            name = "Ino Yamanakan",
            date = "22 Jan 2024",
            time = "03:23AM",
            amount = "Rp10.00",
            type = "+".toString(),
        )
        TransactionItem(
            avatar = R.drawable.ic_avatar_placeholder, // Replace with your actual avatar resource
            name = "Couji",
            date = "21 Jan 2024",
            time = "10:23AM",
            amount = "Rp5.000",
            type = "-".toString(),
        )
//        create more dummy
        TransactionItem(
            avatar = R.drawable.ic_avatar_placeholder, // Replace with your actual avatar resource
            name = "Sakura Haruno",
            date = "20 Jan 2024",
            time = "09:23AM",
            amount = "Rp15.000",
            type = "-".toString(),
        )
        TransactionItem(
            avatar = R.drawable.ic_avatar_placeholder, // Replace with your actual avatar resource
            name = "Naruto Uzumaki",
            date = "19 Jan 2024",
            time = "08:23AM",
            amount = "Rp20.000",
            type = "-".toString(),
        )
        TransactionItem(
            avatar = R.drawable.ic_avatar_placeholder, // Replace with your actual avatar resource
            name = "Sasuke Uchiha",
            date = "18 Jan 2024",
            time = "07:23AM",
            amount = "Rp100.000",
            type = "+".toString(),
        )
        // Add more items if needed
    }
}