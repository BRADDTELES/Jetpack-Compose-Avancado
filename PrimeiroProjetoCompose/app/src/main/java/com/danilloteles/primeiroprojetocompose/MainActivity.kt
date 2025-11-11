package com.danilloteles.primeiroprojetocompose

import android.os.Bundle
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
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.danilloteles.primeiroprojetocompose.ui.theme.PrimeiroProjetoComposeTheme
import com.danilloteles.primeiroprojetocompose.ui.theme.Purple40
import com.danilloteles.primeiroprojetocompose.ui.theme.Purple500

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PrimeiraTela()
        }
    }
}

@Composable
fun PrimeiraTela() {

    var email by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize().background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        TextField(
            value = email,
            onValueChange = {
                email = it
            },
            modifier = Modifier.fillMaxWidth()
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
            modifier = Modifier.fillMaxWidth()
                .padding(20.dp, 0.dp, 20.dp, 10.dp),
            label = {
                Text(text = "Senha")
            },
            maxLines = 1
        )

        Button(
            onClick = {

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

@Preview
@Composable
private fun PrimeiraTelaPreview(){
    PrimeiraTela()
}