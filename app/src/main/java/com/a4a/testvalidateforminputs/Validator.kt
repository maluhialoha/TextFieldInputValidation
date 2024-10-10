package com.a4a.testvalidateforminputs

object Validator {
    fun validateName(input: String?): String? {
        return if(input.isNullOrEmpty())
            "Le nom est obligatoire"
        else null
    }

    fun validateEmail(input: String?): String? {
        return if (input.isNullOrEmpty())
            "Entrez un email"
        else if(!android.util.Patterns.EMAIL_ADDRESS.matcher(input).matches())
            "L'e-mail n'est pas valide"
        else null
    }
}