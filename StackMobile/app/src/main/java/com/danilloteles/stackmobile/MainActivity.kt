package com.danilloteles.stackmobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.danilloteles.stackmobile.ui.theme.Blue
import com.danilloteles.stackmobile.ui.theme.Blue200
import com.danilloteles.stackmobile.ui.theme.Orange

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Home()
        }
    }
}


@Composable
fun Home() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                // color = Color.White
                // color = Color(158, 123, 181)
                // color = Color(0xFF9e7bb5)
                // color = Orange
                color = Blue200
            ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {



    }

}

@Preview()
@Composable
fun HomePreview() {
    Home()
}
