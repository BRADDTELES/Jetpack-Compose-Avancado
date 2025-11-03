package com.danilloteles.stackmobile

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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.danilloteles.stackmobile.componentes.TextFieldCustom

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Login()
        }
    }
}


@Composable
fun Login() {

    var email by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }
    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize().background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Usando o botão de Login para alterar o texto do nome,
        // para usuario autenticado, quando for clicado.
        // Alterando o valor da variável name.
        // Gerenciamento de Estado (State)

        Text(
            text = "Login Page",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(30.dp)
        )

        // Caixas de Texto
        TextFieldCustom(
            value = email,
            onValueChange = {
                email = it
            },
            label = "Email",
            modifier = Modifier.fillMaxWidth().padding(20.dp, 0.dp),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            )
        )

        TextFieldCustom(
            value = senha,
            onValueChange = {
                senha = it
            },
            label = "Senha",
            modifier = Modifier.fillMaxWidth().padding(20.dp, 0.dp),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            isPassword = true
        )

        Button(
            onClick = {
                if ( email.isEmpty() || senha.isEmpty() ) {
                    Toast.makeText(context, "Preencha todos os campos!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "Login efetuado com sucesso!", Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier.padding(10.dp)
        ) {
            Text(text = "Login")
        }


    }

}

@Preview(name = "LoginPreview")
@Composable
fun LoginPreview() {
    Login()
}
