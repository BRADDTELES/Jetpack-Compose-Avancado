package com.danillotelescarneiro.agendadecontatos.componentes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.danillotelescarneiro.agendadecontatos.ui.theme.PURPLE_500
import com.danillotelescarneiro.agendadecontatos.ui.theme.WHITE

@Composable
fun Botao(
    onClick: () -> Unit,
    texto: String
) {

    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = PURPLE_500
        ),
        modifier = Modifier.fillMaxWidth().padding(20.dp).background(
            color = PURPLE_500,
            shape = RoundedCornerShape(5.dp)
        )
    ) {
        Text(
            text = texto,
            fontSize = 18.sp,
            color = WHITE
        )
    }

}