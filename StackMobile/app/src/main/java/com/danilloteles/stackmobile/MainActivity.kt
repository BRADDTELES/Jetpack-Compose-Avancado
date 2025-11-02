package com.danilloteles.stackmobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Home()
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun Home() {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text( text = "Stack Mobile" )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Green
                ),
                actions = {
                    Icon(
                        Icons.Rounded.Search,
                        null,
                        Modifier.padding(2.dp)
                    )
                    Icon(
                        Icons.Rounded.Home,
                        null,
                        Modifier.padding(16.dp)
                    )
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = Color.Green
            ) { }
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding( paddingValues ),
            Arrangement.Center,
            Alignment.CenterHorizontally
        ) {
            Text("Danillo", fontSize = 20.sp)
            Text("Danillo", fontSize = 20.sp)
            Text("Danillo", fontSize = 20.sp)
        }

    }

}
