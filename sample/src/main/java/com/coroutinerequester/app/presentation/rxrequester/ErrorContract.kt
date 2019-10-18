package com.coroutinerequester.app.presentation.rxrequester

import com.sha.coroutinerequester.exception.ErrorMessage

data class ErrorContract(private val message: String): ErrorMessage {
    override fun errorMessage(): String {
        return message
    }
}