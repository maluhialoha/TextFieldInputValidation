package com.a4a.testvalidateforminputs

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class EmailViewModel : ViewModel() {
    var email by mutableStateOf("")
        private set


    fun updateEmail(input: String) {
        email = input
    }

    fun isValidEmail(email: String): Boolean {
        return  if (email.isNotEmpty()) {
            android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
        } else {
            false
        }
    }
}

