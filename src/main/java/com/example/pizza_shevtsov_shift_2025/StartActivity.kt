package com.example.pizza_shevtsov_shift_2025

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.pizza_shevtsov_shift_2025.navigation.SetupNavGraph
import com.example.pizza_shevtsov_shift_2025.ui.theme.Pizzashevtsovshift2025Theme

class StartActivity : ComponentActivity() {

    lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            Pizzashevtsovshift2025Theme {
                navController = rememberNavController()
                SetupNavGraph(navController = navController)
            }
        }
    }
}