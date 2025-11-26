package com.danilloteles.buscadordecep

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.danilloteles.buscadordecep.ui.theme.view.BuscarCep
import com.danilloteles.buscadordecep.ui.theme.viewmodel.BuscarCepViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val navController: NavHostController = rememberNavController()
            val viewModel: BuscarCepViewModel = hiltViewModel()

            NavHost(
                navController = navController,
                startDestination = "buscarCep"
            ) {
                composable("buscarCep") {
                    BuscarCep(navController = navController, viewModel = viewModel)
                }
            }
        }
    }
}

