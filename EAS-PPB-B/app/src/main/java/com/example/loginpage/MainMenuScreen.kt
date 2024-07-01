package com.example.loginpage

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.loginpage.ui.theme.BlueBrand
import com.example.loginpage.ui.theme.DarkBlue


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainMenuScreen(
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

            Image(
                painter = painterResource(id = R.drawable.merchat_list),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth().height(250.dp).padding(16.dp),

            )
            Image(
                painter = painterResource(id = R.drawable.promo),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth().height(280.dp).padding(16.dp),
                )
        }
    }
}
@Composable
fun UserProfile() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.header_pattern),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(300.dp))

        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalAlignment = Alignment.Top
        ) {
            Image(
                painter = painterResource(id = R.drawable.avatar),
                contentDescription = null,
                modifier = Modifier
                    .size(46.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f))
            )

            Spacer(modifier = Modifier.width(4.dp))

            Column {
                Text(
                    text = "Selamat Pagi,",
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.White
                )
                Text(
                    text = "Mr. Yunus",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.White
                )
            }
        }
    }
}
@Composable
fun SaldoCard(saldo: String, navController: NavController  ) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color(0xFF4682B4), shape = RoundedCornerShape(16.dp))
            .padding(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_icon),
                contentDescription = null,
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(
                    text = "Saldo",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = saldo,
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconWithText(
                    text = "Riwayat",
                    icon = painterResource(id = R.drawable.ic_history),
                    onClick = {navController.navigate("historyScreen")}
                )
                Spacer(modifier = Modifier.width(16.dp))
                IconWithText(
                    text = "Transfer",
                    icon = painterResource(id = R.drawable.ic_transfer), onClick = { navController.navigate("transferMenuScreen")}
                )
                Spacer(modifier = Modifier.width(16.dp))
                IconWithText(
                    text = "Isi Saldo",
                    icon = painterResource(id = R.drawable.ic_add_balance),onClick = {}
                )
            }
        }
    }
}
@Composable
fun IconWithText(text: String, icon: Painter, onClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clickable(onClick = onClick)
    ) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(color = DarkBlue, shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = icon,
                contentDescription = text,
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = text,
            color = Color.White,
            fontSize = 12.sp
        )
    }
}
@Composable
fun BottomNavigationBar( navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color.White, shape = RoundedCornerShape(16.dp))
            .padding(vertical = 8.dp, horizontal = 16.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            NavigationIcon(
                text = "Home",
                icon = painterResource(id = R.drawable.ic_home), // Replace with your home icon resource
                onClick = {navController.navigate("mainMenuScreen")}
            )
            NavigationIcon(
                text = "Transfer",
                icon = painterResource(id = R.drawable.ic_data_transfer), // Replace with your transfer icon resource
                onClick = {navController.navigate("transferMenuScreen")}
            )
            NavigationIcon(
                text = "Bayar",
                icon = painterResource(id = R.drawable.ic_pay), // Replace with your pay icon resource
                onClick = {}
            )
            NavigationIcon(
                text = "QRIS",
                icon = painterResource(id = R.drawable.ic_qris), // Replace with your QRIS icon resource
                onClick = {}
            )
            NavigationIcon(
                text = "Profil",
                icon = painterResource(id = R.drawable.ic_profile), // Replace with your profile icon resource
                onClick = {}
            )
        }
    }
}
@Composable
fun NavigationIcon(text: String, icon: Painter, onClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable { onClick() }
    ) {
        Icon(
            painter = icon,
            contentDescription = text,
            tint = Color.Gray,
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = text,
            color = Color.Gray,
            fontSize = 12.sp
        )
    }
}
