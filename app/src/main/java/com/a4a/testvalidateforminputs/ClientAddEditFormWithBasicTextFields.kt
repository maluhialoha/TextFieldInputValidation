package com.a4a.testvalidateforminputs

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
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
fun ClientAddEditFormWithBasicTextFields(
    uiState: ClientState,
    onValueUpdated: (String?, FormElement) -> Unit,
) {
    Column() {
        Text("Nom")
        ValidatingBasicTextField(
            onValueChange = { input ->
                onValueUpdated(input.text, FormElement.CLIENT_OR_ISSUER_NAME)
            },
            label = "Name",
            errorMessage = uiState.errors
                .firstOrNull { it.first == FormElement.CLIENT_OR_ISSUER_NAME }
                ?.second
        )

        Spacer(modifier = Modifier.height(10.dp))
        Text("Email")
        ValidatingBasicTextField(
            onValueChange = { input ->
                onValueUpdated(input.text, FormElement.CLIENT_OR_ISSUER_EMAIL)
            },
            label = "Email",
            errorMessage = uiState.errors
                .firstOrNull { it.first == FormElement.CLIENT_OR_ISSUER_EMAIL }
                ?.second
        )

        Spacer(modifier = Modifier.height(30.dp))
        Button(onClick = {
            onValueUpdated(null, FormElement.SUBMIT_BUTTON)
        }) {
            Text(
                modifier = Modifier.padding(0.dp),
                text = "Valider"
            )
        }
    }
}




