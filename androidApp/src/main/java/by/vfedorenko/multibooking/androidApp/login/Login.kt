package by.vfedorenko.multibooking.androidApp.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.viewModel
import androidx.ui.tooling.preview.Preview


data class Credentials(val mail: String, val password: String)

@Composable
fun LoginScreen(
    loginViewModel: LoginViewModel = viewModel()
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Login") }
            )
        },
        modifier = Modifier.fillMaxSize()
    ) {
        LoginContent(
//            modifier = Modifier.padding(innerPadding),
            loginClick = loginViewModel.onLoginClick
        )
    }
}

@Composable
fun LoginContent(
//    modifier: Modifier,
    loginClick: (Credentials) -> Unit
) {
//    Column(modifier = modifier) {
    CredentialsInput(onCredentialsComplete = loginClick)
}

@Composable
fun CredentialsInput(
    onCredentialsComplete: (Credentials) -> Unit
) {
    Column(
        Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        val (email, setEmail) = remember { mutableStateOf("") }
        val (password, setPassword) = remember { mutableStateOf("") }
        val submit = { onCredentialsComplete(Credentials(email, password)) }

        OutlinedTextField(email, setEmail, label = { Text(text = "Email") })
        OutlinedTextField(
            value = password,
            onValueChange = setPassword,
            modifier = Modifier.padding(top = 8.dp),
            label = { Text(text = "Password") }
        )
        Button(
            onClick = submit,
            modifier = Modifier.padding(top = 16.dp),
            enabled = email.isNotBlank() && password.length > 5
        ) {
            Text(text = "Login")
        }
    }
}

//@Composable
//fun ButtonWithLoading(
//    text: String,
//    onClick: () -> Unit
//) {
//    Button(
//        onClick = onClick
//    ) {
//        Text(text = text)
//    }
//}

@Preview
@Composable
fun LoginPreview() {
    LoginScreen()
}
