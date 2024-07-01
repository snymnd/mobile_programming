package com.example.loginpage

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.loginpage.ui.theme.BlueBrand


@Composable
fun LoginScreen(
    navController: NavController
){

    // Mutable variabel yang digunakan untuk menyimpan input dari pengguna
    var phoneNumber by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }

    Column (
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.End
    ){
        Image(painter = painterResource(id = R.drawable.bgtop), contentDescription = "Background Image",
            modifier = Modifier
                .width(400.dp)
                .height(130.dp), alignment = Alignment.TopStart)
    }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp, 20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(painter = painterResource(id = R.drawable.logo), contentDescription = "my-dompet Logo Image",
            modifier = Modifier
                .width(300.dp)
                .height(110.dp))

        Spacer(modifier = Modifier.height(20.dp))
        
        Text(text = "Selamat Datang", fontSize = 28.sp, fontWeight = FontWeight.Bold, )
        Spacer(modifier = Modifier.height(4.dp))

        Text(text = "Masuk ke my-dompet")

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(value = phoneNumber, modifier = Modifier.fillMaxWidth(), onValueChange = {phoneNumber = it}, label = {
            Text(text = "Nomor Telepon/Email")
        })

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(value = password, modifier = Modifier.fillMaxWidth(), onValueChange = {password = it}, label = {
            Text(text = "Password")
        }, visualTransformation = PasswordVisualTransformation())

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {loginHandler(navController, phoneNumber, password)},
         modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(BlueBrand)
        ) {
            Text(text = "Masuk", color = Color.White)
        }

        Spacer(modifier = Modifier.height(16.dp))

        TextButton(onClick = {  navController.navigate("registerScreen")}) {
            Text(text = "Daftar", color = Color.Black)
        }
    }

    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.Start
    ){
        Image(painter = painterResource(id = R.drawable.bgbot), contentDescription = "Background Image",
            modifier = Modifier
                .width(400.dp)
                .height(67.dp), alignment = Alignment.BottomEnd)
    }
}

fun loginHandler(navController: NavController, email: String, password: String){
    navController.navigate("mainMenuScreen")
    Log.i("mylogger", "Email: $email Password: $password")
}


