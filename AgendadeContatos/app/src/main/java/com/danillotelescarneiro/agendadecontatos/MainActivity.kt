package com.danillotelescarneiro.agendadecontatos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.danillotelescarneiro.agendadecontatos.views.AtualizarContato
import com.danillotelescarneiro.agendadecontatos.views.ListaContatos
import com.danillotelescarneiro.agendadecontatos.views.SalvarContato

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = "listaContatos"
            ){
                composable(
                    route = "listaContatos"
                ) {
                    ListaContatos(navController = navController)
                }

                composable(
                    route = "salvarContato"
                ) {
                    SalvarContato(navController = navController)
                }

                composable(
                    route = "atualizarContato/{uid}/{nome}/{sobrenome}/{idade}/{celular}",
                    arguments = listOf(
                        navArgument(name = "uid"){},
                        navArgument(name = "nome"){},
                        navArgument(name = "sobrenome"){},
                        navArgument(name = "idade"){},
                        navArgument(name = "celular"){},
                    )
                ) {
                    AtualizarContato(
                        navController = navController,
                        uid = it.arguments?.getString("uid").toString(),
                        nome = it.arguments?.getString("nome").toString(),
                        sobrenome = it.arguments?.getString("sobrenome").toString(),
                        idade = it.arguments?.getString("idade").toString(),
                        celular = it.arguments?.getString("celular").toString(),
                    )
                }
            }

        }
    }
}
