package com.danilloteles.buscadordecep

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.danilloteles.buscadordecep.ui.theme.BuscadorDeCepTheme
import com.danilloteles.buscadordecep.view.BuscarCep

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BuscadorDeCepTheme {
                val navController: NavHostController = rememberNavController()

                NavHost(
                    navController = navController,
                    startDestination = "buscarCep"
                ){
                    composable("buscarCep"){
                        BuscarCep(navController = navController)
                    }
                }
            }
        }
    }
}

