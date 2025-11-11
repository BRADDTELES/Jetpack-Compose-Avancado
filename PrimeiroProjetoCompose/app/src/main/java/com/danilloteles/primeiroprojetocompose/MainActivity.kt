package com.danilloteles.primeiroprojetocompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.danilloteles.primeiroprojetocompose.listener.RespostaServidor
import com.danilloteles.primeiroprojetocompose.ui.theme.PrimeiroProjetoComposeTheme
import com.danilloteles.primeiroprojetocompose.ui.theme.Purple40
import com.danilloteles.primeiroprojetocompose.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PrimeiroProjetoComposeTheme {

                val viewModel: MainViewModel = hiltViewModel()
                val context = LocalContext.current

                // O Composable 'PrimeiraTela' agora recebe a função de login como parâmetro.
                // Isso remove a dependência direta do ViewModel, tornando-o mais testável e
                // permitindo que a visualização do preview funcione corretamente.
                PrimeiraTela(
                    onLoginClick = { email, senha ->
                        viewModel.login(email, senha, object : RespostaServidor {
                            override fun onSucess(mensagem: String) {
                                Toast.makeText(context, mensagem, Toast.LENGTH_SHORT).show()
                            }

                            override fun onFailure(erro: String) {
                                Toast.makeText(context, erro, Toast.LENGTH_SHORT).show()
                            }
                        })
                    }
                )
            }
        }
    }
}

// O Composable foi refatorado para não depender mais diretamente do MainViewModel.
// Em vez disso, ele recebe uma função lambda 'onLoginClick'.
// Essa abordagem de "state hoisting" (elevação de estado) torna o Composable mais
// reutilizável e fácil de testar, incluindo a renderização no modo Preview.
@Composable
fun PrimeiraTela(
    onLoginClick: (String, String) -> Unit
) {

    var email by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        TextField(
            value = email,
            onValueChange = {
                email = it
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp, 50.dp, 20.dp, 10.dp),
            label = {
                Text(text = "Email")
            },
            maxLines = 1
        )

        TextField(
            value = senha,
            onValueChange = {
                senha = it
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp, 0.dp, 20.dp, 10.dp),
            label = {
                Text(text = "Senha")
            },
            maxLines = 1
        )

        Button(
            onClick = {
                onLoginClick(email, senha)
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Purple40
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
                .background(
                    color = Purple40,
                    shape = RoundedCornerShape(5.dp)
                )
        ) {
            Text(text = "Entrar", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.White)
        }

    }

}

// A preview agora passa uma função lambda vazia para 'onLoginClick'.
// Isso resolve o erro de renderização, pois não tenta mais instanciar um ViewModel.
@Preview
@Composable
private fun PrimeiraTelaPreview() {
    PrimeiraTela(onLoginClick = { _, _ -> })
}