package com.a4a.testvalidateforminputs

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

@Composable
fun ValidatingBasicTextField(
    label: String,
    onValueChange: (TextFieldValue) -> Unit,
    errorMessage: String?,
) {
    var text by remember {
        mutableStateOf(TextFieldValue(""))
    }
    BasicTextField(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .padding(10.dp),
        value = text,
        onValueChange = {
            text = it
            onValueChange(it)
        }
    )
    errorMessage?.let {
        Text(
            color = Color.Red,
            text = it
        )
    }
}