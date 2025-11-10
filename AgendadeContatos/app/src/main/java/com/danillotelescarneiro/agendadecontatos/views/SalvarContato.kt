package com.danillotelescarneiro.agendadecontatos.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.danillotelescarneiro.agendadecontatos.ui.theme.PURPLE_500
import com.danillotelescarneiro.agendadecontatos.ui.theme.WHITE

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SalvarContato() {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Salvar novo Contato")
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = PURPLE_500,
                    titleContentColor = WHITE
                )
            )
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues)
        ) {
            Text(text = "Salvar Contato")
        }
    }

}

@Preview
@Composable
private fun SalvarContatoPreview(){
    SalvarContato()
}