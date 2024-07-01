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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
fun TransferScreen(
    navController: NavController
){

    // Mutable variabel yang digunakan untuk menyimpan input dari pengguna
    var bankName by remember {
        mutableStateOf("")
    }
    var bankNumber by remember {
        mutableStateOf("")
    }
    var nominal by remember {
        mutableStateOf("")
    }


    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 20.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ){
        Image(painter = painterResource(id = R.drawable.bgtop), contentDescription = "Background Image",
            modifier = Modifier
                .width(400.dp)
                .height(67.dp), alignment = Alignment.BottomEnd)
    }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp, 30.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ){
        Text(text = "Transfer Antarbank", fontSize = 28.sp, fontWeight = FontWeight.Bold, )
        Spacer(modifier = Modifier.height(4.dp))

        Text(text = "Transfer uang antarbank")

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(value = bankName, onValueChange = {bankName = it}, modifier = Modifier.fillMaxWidth(), label = {
            Text(text = "Nama Bank")
        })

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(value = bankNumber, onValueChange = {bankNumber = it}, modifier = Modifier.fillMaxWidth(), label = {
            Text(text = "Nomor Rekening Penerima")
        })

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(value = nominal, onValueChange = {nominal = it}, modifier = Modifier.fillMaxWidth(), label = {
            Text(text = "Nominal Transfer")
        }, visualTransformation = PasswordVisualTransformation())

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick ={ transferHandler(navController, bankName, bankNumber, nominal) },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(YellowBrand)
        ) {
            Text(text = "Transfer", color = Color.Black)
        }

        Button(onClick = { navController.navigate("loginScreen") },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(Color.LightGray)
        ) {
            Text(text = "Kembali", color = Color.Black)
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

fun transferHandler(
    navController: NavController, bankName: String, bankNumber: String, nominal: String
) {
    navController.navigate("confirmation")
    Log.i("mylogger", "Nama Bank: $bankName, NoRek Penerima: $bankNumber, Nominal: $nominal")
}



