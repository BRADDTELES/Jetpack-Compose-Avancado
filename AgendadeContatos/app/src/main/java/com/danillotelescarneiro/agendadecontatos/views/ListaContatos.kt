package com.danillotelescarneiro.agendadecontatos.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.danillotelescarneiro.agendadecontatos.AppDatabase
import com.danillotelescarneiro.agendadecontatos.itemlista.ContatoItem
import com.danillotelescarneiro.agendadecontatos.model.Contato
import com.danillotelescarneiro.agendadecontatos.ui.theme.PURPLE_500
import com.danillotelescarneiro.agendadecontatos.ui.theme.WHITE

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListaContatos(
    navController: NavController
) {

    val listaContatos = remember { mutableStateListOf<Contato>() }

    val context = LocalContext.current

    LaunchedEffect(Unit) {
        val contatoDao = AppDatabase.getInstance(context).contatoDao()
        val contatosDoBanco = contatoDao.getContatos()

        listaContatos.clear()
        listaContatos.addAll(contatosDoBanco)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Agenda de Contatos")
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = PURPLE_500,
                    titleContentColor = WHITE
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate("salvarContato")
                },
                containerColor = PURPLE_500,
                contentColor = WHITE,
                modifier = Modifier.clip(CircleShape)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Ícone de adicionar contato"
                )
            }
        }
    ) { paddingValues ->

        LazyColumn(
            modifier = Modifier.fillMaxSize().background(Color.LightGray)
                .padding(paddingValues)
        ) {
            itemsIndexed(listaContatos){ _, contato ->
                ContatoItem(contato = contato, navController = navController)
            }
        }

    }

}

@Preview
@Composable
private fun ListaContatosPreview(){
    ListaContatos(
        navController = rememberNavController()
    )
}