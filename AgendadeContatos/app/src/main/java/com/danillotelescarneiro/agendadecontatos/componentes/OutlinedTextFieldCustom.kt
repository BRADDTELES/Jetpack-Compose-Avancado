package com.danillotelescarneiro.agendadecontatos.componentes

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.danillotelescarneiro.agendadecontatos.ui.theme.PURPLE_500
import com.danillotelescarneiro.agendadecontatos.ui.theme.WHITE

@Composable
fun OutlinedTextFieldCustom(
    value: String,
    onValueChange: (String) -> Unit,
    label: @Composable () -> Unit,
    keyboardOptions: KeyboardOptions,
    modifier: Modifier = Modifier
) {

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = label,
        keyboardOptions = keyboardOptions,
        colors = TextFieldDefaults.colors(
            cursorColor = PURPLE_500,
            focusedIndicatorColor = PURPLE_500,
            focusedContainerColor = WHITE,
            unfocusedContainerColor = WHITE
        ),
        maxLines = 1,
        modifier = modifier
    )

}

@Preview
@Composable
private fun OutlinedTextFieldCustomPreview(){
    OutlinedTextFieldCustom(
        value = "Nome",
        onValueChange = {it},
        label = { Text(text = "Nome") },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text
        )
    )
}