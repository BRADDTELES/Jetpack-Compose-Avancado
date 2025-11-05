package com.danillotelescarneiro.appcomdatastore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.danillotelescarneiro.appcomdatastore.datasource.UserPrerences
import com.danillotelescarneiro.appcomdatastore.ui.theme.Teal50
import com.danillotelescarneiro.appcomdatastore.ui.theme.Teal900
import com.danillotelescarneiro.appcomdatastore.ui.theme.TealA700
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Home()
        }
    }
}

@Preview
@Composable
private fun HomePreview() {
    Home()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home() {

    var email by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }
    val context = LocalContext.current
    val scope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        UserPrerences.getEmail(context).collect {
            result = it
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text( text = "App com DataStore")
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Teal900,
                    titleContentColor = Teal50
                )
            )
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier.fillMaxSize().background(Color.White)
                .padding(paddingValues),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            
            OutlinedTextField(
                value = email,
                onValueChange = {
                    email = it
                },
                label = {
                    Text(
                        text = "E-mail",
                        color = Teal900 //cor do Label E-mail focado e não focado
                    )
                },
                maxLines = 1,
                textStyle = TextStyle(
                    color = Teal900,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium
                ),
                colors = TextFieldDefaults.colors(
                    cursorColor = Teal900,//cor do Cursor piscando
                    focusedContainerColor = Teal50,//cor do fundo da caixa focado
                    unfocusedContainerColor = Teal50,// cor do fundo da caixa não focado
                    focusedIndicatorColor = TealA700, //cor da borda focado
                    unfocusedIndicatorColor = TealA700, //cor da borda não focado
                ),
                modifier = Modifier.width(300.dp)
            )


            Button(
                onClick = {
                    scope.launch {
                        if (  email.isNotEmpty()  ) {
                            UserPrerences.saveEmail(context, email)
                        }
                    }
                },
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .width(320.dp)
                    .padding(10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Teal900
                ),
                border = BorderStroke(
                    width = 2.dp,
                    color = Teal900
                ),
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 2.dp,
                    pressedElevation = 4.dp,
                    disabledElevation = 0.dp
                )
            ) {
                Text(
                    text = "Salvar"
                )
            }


            Text(
                text = result,
                fontSize = 16.sp,
                color = Teal900,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(10.dp)
            )


        }
    }


}