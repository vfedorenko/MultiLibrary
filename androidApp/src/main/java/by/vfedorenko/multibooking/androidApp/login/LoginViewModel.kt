package by.vfedorenko.multibooking.androidApp.login

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.vfedorenko.multibooking.shared.data.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent
import org.koin.core.inject

class LoginViewModel : ViewModel(), KoinComponent {

    private val repository by inject<UserRepository>()

    val email: Flow<String> = MutableStateFlow("")
    val password: Flow<String> = MutableStateFlow("")

    val onLoginClick: (Credentials) -> Unit = { credentials ->
        viewModelScope.launch {
            try {
                val result = repository.loginUser(credentials.mail, credentials.password)
                Log.d("1111", "Login success $result")
            } catch (error: Exception) {
                Log.e("1111", "Login fail", error)
            }
        }
    }

    fun login(credentials: Credentials) {

    }

    init {
        Log.d("1111", "isUserLoggedIn = ${repository.isUserLoggedIn}")
    }
}