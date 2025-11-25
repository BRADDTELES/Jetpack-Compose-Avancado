package com.danilloteles.buscadordecep.ui.theme.componentes

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.danilloteles.buscadordecep.ui.theme.Teal700
import com.danilloteles.buscadordecep.ui.theme.WHITE

@Composable
fun CaixaTexto(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    modifier: Modifier = Modifier,
    keyboardOptions: KeyboardOptions
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = {
            Text(text = label)
        },
        colors = TextFieldDefaults.colors(
            focusedLabelColor = Teal700,
            cursorColor = Teal700,
            focusedIndicatorColor = Teal700, // Cor da Borda
            focusedPlaceholderColor = Teal700,
            unfocusedIndicatorColor = Teal700,
            focusedContainerColor = WHITE,
            unfocusedContainerColor = WHITE
        ),
        modifier = modifier,
        keyboardOptions = keyboardOptions,
        maxLines = 1
    )
}

@Preview
@Composable
private fun CaixaTextoPreview(){
    CaixaTexto(
        value = "",
        onValueChange = {},
        label = "",
        keyboardOptions = KeyboardOptions.Default
    )
}