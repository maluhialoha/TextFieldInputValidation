package com.a4a.testvalidateforminputs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.a4a.testvalidateforminputs.ui.theme.TestValidateFormInputsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TestValidateFormInputsTheme {
                val clientViewModel = ClientViewModel()

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    /*ClientAddEditFormWithOutlinedTextFields(
                        uiState = clientViewModel.clientUiState.value,
                        onValueUpdated = { input, element ->
                            clientViewModel.onValueUpdated(input, element)
                        }
                    )*/
                    ClientAddEditFormWithBasicTextFields(
                        uiState = clientViewModel.clientUiState.value,
                        onValueUpdated = { input, element ->
                            clientViewModel.onValueUpdated(input, element)
                        }
                    )
                }
            }
        }
    }
}


