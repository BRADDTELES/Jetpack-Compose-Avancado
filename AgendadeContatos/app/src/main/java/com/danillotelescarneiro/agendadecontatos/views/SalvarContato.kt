package com.danillotelescarneiro.agendadecontatos.views

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.danillotelescarneiro.agendadecontatos.AppDatabase
import com.danillotelescarneiro.agendadecontatos.componentes.Botao
import com.danillotelescarneiro.agendadecontatos.componentes.OutlinedTextFieldCustom
import com.danillotelescarneiro.agendadecontatos.dao.ContatoDao
import com.danillotelescarneiro.agendadecontatos.model.Contato
import com.danillotelescarneiro.agendadecontatos.ui.theme.PURPLE_500
import com.danillotelescarneiro.agendadecontatos.ui.theme.WHITE
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

private lateinit var contatoDao: ContatoDao

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SalvarContato(
    navController: NavController
) {

    var nome by remember { mutableStateOf("") }
    var sobrenome by remember { mutableStateOf("") }
    var idade by remember { mutableStateOf("") }
    var celular by remember { mutableStateOf("") }

    var mensagem by remember { mutableStateOf(false) }

    val context = LocalContext.current

    val scope = rememberCoroutineScope()

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
            modifier = Modifier.fillMaxSize().padding(paddingValues).background(WHITE)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            OutlinedTextFieldCustom(
                value = nome,
                onValueChange = {
                    nome = it
                },
                label = {
                    Text(text = "Nome")
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text
                ),
                modifier = Modifier.fillMaxWidth().padding(20.dp, 0.dp, 20.dp, 10.dp)
            )

            OutlinedTextFieldCustom(
                value = sobrenome,
                onValueChange = {
                    sobrenome = it
                },
                label = {
                    Text(text = "Sobrenome")
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text
                ),
                modifier = Modifier.fillMaxWidth().padding(20.dp, 0.dp, 20.dp, 10.dp)
            )

            OutlinedTextFieldCustom(
                value = idade,
                onValueChange = {
                    idade = it
                },
                label = {
                    Text(text = "Idade")
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                modifier = Modifier.fillMaxWidth().padding(20.dp, 0.dp, 20.dp, 10.dp)
            )

            OutlinedTextFieldCustom(
                value = celular,
                onValueChange = {
                    celular = it
                },
                label = {
                    Text(text = "Celular")
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Phone
                ),
                modifier = Modifier.fillMaxWidth().padding(20.dp, 0.dp, 20.dp, 10.dp)
            )

            Botao(
                onClick = {
                    scope.launch(Dispatchers.IO){
                        if (nome.isEmpty() || sobrenome.isEmpty() || idade.isEmpty() || celular.isEmpty()){
                            mensagem = false
                        } else {
                            mensagem = true
                            val contato = Contato(nome = nome, sobrenome = sobrenome, idade = idade, celular = celular)
                            contatoDao = AppDatabase.getInstance(context).contatoDao()
                            contatoDao.gravar(contato)
                        }
                    }

                    scope.launch(Dispatchers.Main) {
                        if (mensagem){
                            Toast.makeText(context, "Sucesso ao salvar contato", Toast.LENGTH_SHORT).show()
                            navController.navigate("listaContatos")
                        } else {
                            Toast.makeText(context, "Preencha todos os campos!", Toast.LENGTH_SHORT).show()
                        }
                    }
                },
                texto = "Salvar"
            )

        }
    }

}

@Preview
@Composable
private fun SalvarContatoPreview(){
    SalvarContato(
        navController = rememberNavController()
    )
}