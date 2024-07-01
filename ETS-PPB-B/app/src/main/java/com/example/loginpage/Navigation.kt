package com.example.loginpage

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MyApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "loginScreen") {
        composable("loginScreen") { LoginScreen(navController = navController) }
        composable("transferScreen") { TransferScreen(navController = navController) }
        composable("confirmation") { Confirmation(navController = navController) }
    }
}