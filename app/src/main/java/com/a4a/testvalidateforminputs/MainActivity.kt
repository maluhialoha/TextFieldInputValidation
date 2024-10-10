package com.a4a.testvalidateforminputs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.a4a.testvalidateforminputs.ui.theme.TestValidateFormInputsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TestValidateFormInputsTheme {
                val clientViewModel = ClientViewModel()

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        Modifier
                            .fillMaxSize()
                            .padding(40.dp)
                            .padding(top = 80.dp)
                    ) {
                        Text(
                            "Input validation",
                            fontSize = 40.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(Modifier.height(30.dp))

                        /*Text(
                            "Outlined Text Fields",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(Modifier.height(10.dp))
                        ClientAddEditFormWithOutlinedTextFields(
                            uiState = clientViewModel.clientUiState.value,
                            onValueUpdated = { input, element ->
                                clientViewModel.onValueUpdated(input, element)
                            }
                        )*/

                        Text(
                            "Basic Text Fields",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(Modifier.height(10.dp))
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
}


