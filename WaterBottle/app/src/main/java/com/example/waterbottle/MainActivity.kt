package com.example.waterbottle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import com.example.waterbottle.ui.theme.WaterBottleTheme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.waterbottel.WatterBottle


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WaterBottleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var usedWaterAmount by remember {
                        mutableStateOf(100)
                    }
                    val totalWaterAmount = remember {
                        2500
                    }
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {

                        WatterBottle(
                            totalWaterAmount = totalWaterAmount,
                            unit = "ml",
                            usedWaterAmount = usedWaterAmount
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        Text(
                            text = "Total Amount is : $totalWaterAmount",
                            textAlign = TextAlign.Center
                        )
                        Button(
                            onClick = { usedWaterAmount += 200 },
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xff9D79FB))
                        ) {
                            Text(text = "Drink")
                        }

                        Spacer(modifier = Modifier.height(26.dp))
                        Text(
                            text = "Muhammad Yunus - 5025201171",
                            textAlign = TextAlign.Center,
                            color = Color(0xff9D79FB)
                        )
                    }
                }
            }
        }
    }
}
