package com.danilloteles.stackmobile.componentes

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TextFieldCustom(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    modifier: Modifier = Modifier,
    keyboardOptions: KeyboardOptions = KeyboardOptions(),
    isPassword: Boolean = false
) {

    OutlinedTextField(
        value = value,
        onValueChange,
        label = {
            Text(text = label)
        },
        modifier = modifier,
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color.White,//Cor de fundo do campo de texto quando não está focado
            focusedContainerColor = Color.White,//Cor de fundo do campo de texto quando está focado
            focusedTextColor = Color.Blue,//Cor do texto quando está focado
            unfocusedTextColor = Color.Blue,//Cor do texto quando não está focado
            focusedLabelColor = Color.Blue,//Cor do rótulo quando está focado
            focusedIndicatorColor = Color.Blue,//Cor da borda quando está focado
            cursorColor = Color.Blue,//Cor do cursor
        ),
        keyboardOptions = keyboardOptions,
        maxLines = 1,
        visualTransformation = if ( !isPassword ) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        }

    )

}

@Preview
@Composable
private fun TextFieldCustomPreview() {

    var name = ""

    TextFieldCustom(
        value =  name,
        onValueChange = {
            name = it
        },
        label = "Email",
        modifier = Modifier.fillMaxWidth().padding(20.dp)
    )
}