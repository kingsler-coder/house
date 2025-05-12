package com.kingsler.manyumba.data

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.onCompletion

// Use sealed interface for AuthResult
sealed interface AuthResult {
    data class Success(val userId: String) : AuthResult
    data class Error(val message: String) : AuthResult
    object Loading : AuthResult
    object Idle : AuthResult
}

class AuthViewModel : ViewModel() {
    private val _authResult = mutableStateOf<AuthResult>(AuthResult.Idle)
    val authResult: State<AuthResult> = _authResult

    fun login(email: String, password: String) {
        viewModelScope.launch {
            _authResult.value = AuthResult.Loading
            flow {
                delay(1000)
                if (email == "test@example.com" && password == "password") {
                    emit("user123")
                } else {
                    throw Exception("Invalid credentials")
                }
            }
                .catch { e ->
                    _authResult.value = AuthResult.Error(e.message ?: "An error occurred during login")
                }
                .onCompletion { _authResult.value = AuthResult.Idle } // Ensure Idle on completion
                .collect { userId ->
                    _authResult.value = AuthResult.Success(userId)
                }
        }
    }

    fun register(email: String, password: String) {
        viewModelScope.launch {
            _authResult.value = AuthResult.Loading
            flow {
                delay(1500)
                if (email.isNotBlank() && password.length >= 8) {
                    emit("newUser456")
                } else {
                    throw Exception("Invalid registration details")
                }
            }
                .catch { e ->
                    _authResult.value = AuthResult.Error(e.message ?: "An error occurred during registration")
                }
                .onCompletion { _authResult.value = AuthResult.Idle } //  Ensure Idle on completion
                .collect { newUserId ->
                    _authResult.value = AuthResult.Success(newUserId)
                }
        }
    }

    fun resetAuthResult() {
        _authResult.value = AuthResult.Idle
    }
}
