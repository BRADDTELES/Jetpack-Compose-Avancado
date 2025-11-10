package com.danillotelescarneiro.listagemdedados.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.danillotelescarneiro.listagemdedados.ui.theme.White

@Composable
fun Home() {

    var fruitList = arrayOf(
        "Abacate", "Abacaxi", "Açaí", "Amora", "Banana", "Maçã",
        "Framboesa", "Goiaba", "Jaca", "Uva", "Laranja", "Kiwi"
    )

    Column(
        modifier = Modifier.fillMaxSize().background(White)
    ) {

        LazyColumn(
            
        ) {
            itemsIndexed(fruitList){ position, fruit ->
                Text(text = fruit)
            }
        }
    }

}

@Preview
@Composable
private fun HomePreview(){
    Home()
}
