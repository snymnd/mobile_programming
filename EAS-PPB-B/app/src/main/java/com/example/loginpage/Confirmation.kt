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
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
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
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.loginpage.ui.theme.BlueBrand


@Composable
fun Confirmation(
    navController: NavController
){

    // Mutable variabel yang digunakan untuk menyimpan input dari pengguna
    var pin by remember {
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
            .padding(10.dp, 10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ){

        ElevatedCard(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            ),
            modifier = Modifier
                .fillMaxWidth().height(300.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFF4F4F4))
        ) {
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp, 16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                Text(text = "Masukkan PIN", fontSize = 28.sp, fontWeight = FontWeight.Bold, )
                Spacer(modifier = Modifier.height(4.dp))

                Text(text = "Silakan masukkan PIN untuk konfirmasi transfer")

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(value = pin, onValueChange = {pin = it}, modifier = Modifier.fillMaxWidth(), label = {
                    Text(text = "PIN")
                }, visualTransformation = PasswordVisualTransformation())

                Spacer(modifier = Modifier.height(16.dp))

                Button(onClick ={ confirmationHandler(navController, pin) },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(BlueBrand)
                ) {
                    Text(text = "Transfer", color = Color.White)
                }

                Button(onClick = { navController.navigate("transferScreen") },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(Color.LightGray)
                ) {
                    Text(text = "Batal", color = Black)
                }

            }

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

fun confirmationHandler(
    navController: NavController, pin: String
) {
    Log.i("mylogger", "PIN: $pin")
    navController.navigate("mainMenuScreen")
}



