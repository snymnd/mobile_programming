package com.example.loginpage

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.loginpage.ui.theme.BlueBrand


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TransferMenuScreen(
    navController: NavController
){
    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController)
        },
        ) {
            Column  {
                UserProfile()

                Column (modifier = Modifier.padding(16.dp)) {
                    TitleMenu(title = "Transfer Saldo")
                    Spacer(modifier = Modifier.height(16.dp))
                    Column {
                        Image(
                            painter = painterResource(id = R.drawable.option_bank),
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxWidth().clickable { navController.navigate("transferScreen") },

                        )
                        Image(
                            painter = painterResource(id = R.drawable.bank_list),
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxWidth()
                        )
                    }
                }

            }
        }
}

@Composable
fun TitleMenu(title: String){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_icon),
            contentDescription = null,
            modifier = Modifier
                .size(50.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = title,
            color = Color.Black,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
    }
}