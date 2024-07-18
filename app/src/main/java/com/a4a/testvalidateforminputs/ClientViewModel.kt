package com.a4a.testvalidateforminputs

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ClientViewModel : ViewModel() {

    private val _uiState =
        mutableStateOf(ClientState())
    val clientUiState: State<ClientState> = _uiState

    init {
        _uiState.value = ClientState()
    }

    fun onValueUpdated(input: String?, element: FormElement) {
        when (element) {
            FormElement.CLIENT_OR_ISSUER_EMAIL -> {
                _uiState.value = _uiState.value.copy(
                    email = input
                )
            }

            FormElement.CLIENT_OR_ISSUER_NAME -> {
                _uiState.value = _uiState.value.copy(
                    name = input ?: ""
                )
            }

            FormElement.SUBMIT_BUTTON -> {
                validateInputs()
            }

            else -> {}
        }
    }

    private fun validateInputs() {
        val listOfErrors: MutableList<Pair<FormElement, String?>> = mutableListOf()

        listOfErrors.add(Pair(FormElement.CLIENT_OR_ISSUER_NAME, Validator.validateName(_uiState.value.name)))
        listOfErrors.add(Pair(FormElement.CLIENT_OR_ISSUER_EMAIL, Validator.validateEmail(_uiState.value.email)))

        _uiState.value = _uiState.value.copy(
            errors = listOfErrors,
        )
    }
}

data class ClientState(
    var id: Int? = null,
    var firstName: String? = null,
    var name: String? = null,
    var email: String? = null,
    var errors: MutableList<Pair<FormElement, String?>> = mutableListOf(),
)