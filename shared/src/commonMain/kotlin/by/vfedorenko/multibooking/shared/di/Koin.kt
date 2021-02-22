package by.vfedorenko.multibooking.shared.di

import by.vfedorenko.multibooking.shared.data.UserRepository
import by.vfedorenko.multibooking.shared.data.UserSettings
import by.vfedorenko.multibooking.shared.network.UserApi
import com.russhwolf.settings.Settings
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module


fun initKoin(appDeclaration: KoinAppDeclaration = {}) = startKoin {
    appDeclaration()
    modules(commonModule)
}

// called by iOS etc
fun initKoin() = initKoin{}

val commonModule = module {
    single { UserRepository(get(), get()) }
    single { UserApi() }

    single { UserSettings(get()) }
    single { Settings() }
}