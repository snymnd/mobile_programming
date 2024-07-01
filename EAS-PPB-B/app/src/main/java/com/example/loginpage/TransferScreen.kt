package com.example.loginpage

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.Scaffold
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
import com.example.loginpage.ui.theme.BlueBrand


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TransferScreen(
    navController: NavController
) {
    // Mutable variabel yang digunakan untuk menyimpan input dari pengguna
    var bankNumber by remember {
        mutableStateOf("")
    }
    var nominal by remember {
        mutableStateOf("")
    }
    var keterangan by remember {
        mutableStateOf("")
    }
    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController)
        },
    ) {
        Column {
            UserProfile()

            Column(modifier = Modifier.padding(16.dp)) {
                TitleMenu(title = "Transfer Saldo")
                Spacer(modifier = Modifier.height(8.dp))
                Column (
                    modifier = Modifier
                        .fillMaxSize()
                ){
                    Spacer(modifier = Modifier.height(16.dp))

                    OutlinedTextField(value = bankNumber, onValueChange = {bankNumber = it}, modifier = Modifier.fillMaxWidth(), label = {
                        Text(text = "Nomor Rekening Penerima")
                    })

                    Spacer(modifier = Modifier.height(16.dp))

                    OutlinedTextField(value = nominal, onValueChange = {nominal = it}, modifier = Modifier.fillMaxWidth(), label = {
                        Text(text = "Nominal Transfer")
                    })

                    Spacer(modifier = Modifier.height(16.dp))

                    OutlinedTextField(value = keterangan, onValueChange = {keterangan = it}, modifier = Modifier.fillMaxWidth(), label = {
                        Text(text = "Keterangan")
                    })

                    Spacer(modifier = Modifier.height(16.dp))

                    Button(onClick ={ transferHandler(navController, bankNumber, nominal, keterangan) },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(BlueBrand)
                    ) {
                        Text(text = "Transfer", color = Color.White)
                    }

                    Button(onClick = { navController.navigate("transferMenuScreen") },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(Color.LightGray)
                    ) {
                        Text(text = "Kembali", color = Color.Black)
                    }

                }
            }
        }

    }
}

fun transferHandler(
    navController: NavController, bankNumber: String, nominal: String, keterangan: String
) {
    navController.navigate("confirmation")
    Log.i("mylogger", "NoRek Penerima: $bankNumber, Nominal: $nominal, Keterangan: $keterangan")
}



