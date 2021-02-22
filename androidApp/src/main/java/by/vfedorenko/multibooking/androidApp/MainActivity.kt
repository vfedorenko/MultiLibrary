package by.vfedorenko.multibooking.androidApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import by.vfedorenko.multibooking.androidApp.login.LoginScreen
import by.vfedorenko.multibooking.androidApp.login.LoginViewModel
import by.vfedorenko.multibooking.androidApp.resources.BookingTheme
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {

    private val loginViewModel by viewModel<LoginViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            BookingTheme(
                darkTheme = false
            ) {
                LoginScreen()
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    MaterialTheme {
//        Greeting("Android")
//    }
//}