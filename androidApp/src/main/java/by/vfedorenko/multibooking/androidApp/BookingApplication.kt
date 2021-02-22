package by.vfedorenko.multibooking.androidApp

import android.app.Application
import by.vfedorenko.multibooking.androidApp.login.LoginViewModel
import by.vfedorenko.multibooking.shared.di.commonModule
import by.vfedorenko.multibooking.shared.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin {
            androidLogger()
            androidContext(this@App)
            modules(viewModelsModule, commonModule)
        }
    }
}

val viewModelsModule = module {
//    viewModel {
//        LoginViewModel(get())
//    }
}