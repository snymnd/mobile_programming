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
import com.example.loginpage.ui.theme.YellowBrand


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
        horizontalAlignment = Alignment.Start
    ){
        Image(painter = painterResource(id = R.drawable.bglogin), contentDescription = "Background Image",
            modifier = Modifier.width(400.dp).height(130.dp), alignment = Alignment.BottomEnd)
    }

    Column (
        modifier = Modifier.fillMaxSize().padding(30.dp, 20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(painter = painterResource(id = R.drawable.logo), contentDescription = "BSI Logo Image",
            modifier = Modifier.width(300.dp).height(160.dp))

        Spacer(modifier = Modifier.height(20.dp))
        
        Text(text = "Selamat Datang", fontSize = 28.sp, fontWeight = FontWeight.Bold, )
        Spacer(modifier = Modifier.height(4.dp))

        Text(text = "Masuk ke BSI Mobile")

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(value = phoneNumber, modifier = Modifier.fillMaxWidth(), onValueChange = {phoneNumber = it}, label = {
            Text(text = "Nomor Telepon")
        })

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(value = password, modifier = Modifier.fillMaxWidth(), onValueChange = {password = it}, label = {
            Text(text = "Password")
        }, visualTransformation = PasswordVisualTransformation())

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {loginHandler(navController, phoneNumber, password)},
         modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(YellowBrand)
        ) {
            Text(text = "Masuk", color = Color.Black)
        }
    }

    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.Start
    ){
        Image(painter = painterResource(id = R.drawable.bgbot), contentDescription = "Background Image",
            modifier = Modifier.width(400.dp).height(67.dp), alignment = Alignment.BottomEnd)
    }
}

fun loginHandler(navController: NavController, email: String, password: String){
    navController.navigate("transferScreen")
    Log.i("mylogger", "Email: $email Password: $password")
}


