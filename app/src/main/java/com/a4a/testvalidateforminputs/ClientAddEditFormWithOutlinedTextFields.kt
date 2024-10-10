package com.a4a.testvalidateforminputs

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue

@Composable
fun ClientAddEditFormWithOutlinedTextFields(
    uiState: ClientState,
    onValueUpdated: (String?, FormElement) -> Unit,
) {
    Column {
        ValidatingOutlinedTextField(
            onValueChange = { input ->
                onValueUpdated(input, FormElement.CLIENT_OR_ISSUER_NAME)
            },
            label = "Name",
            isError = uiState.errors.firstOrNull { it.first == FormElement.CLIENT_OR_ISSUER_NAME }?.second != null,
            errorMessage = uiState.errors
                .firstOrNull { it.first == FormElement.CLIENT_OR_ISSUER_NAME }
                ?.second
        )
        ValidatingOutlinedTextField(
            onValueChange = { input ->
                onValueUpdated(input, FormElement.CLIENT_OR_ISSUER_EMAIL)
            },
            label = "Email",
            isError = uiState.errors.firstOrNull { it.first == FormElement.CLIENT_OR_ISSUER_EMAIL }?.second != null,
            errorMessage = uiState.errors
                .firstOrNull { it.first == FormElement.CLIENT_OR_ISSUER_EMAIL }
                ?.second
        )
        Button(onClick = {
            onValueUpdated(null, FormElement.SUBMIT_BUTTON)
        }) {
            Text(text = "Valider")
        }
    }
}




