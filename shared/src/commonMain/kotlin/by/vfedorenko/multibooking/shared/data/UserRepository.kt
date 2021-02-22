package by.vfedorenko.multibooking.shared.data

import by.vfedorenko.multibooking.shared.network.UserApi

class UserRepository(
    private val userApi: UserApi,
    private val userSettings: UserSettings
) {

    val isUserLoggedIn: Boolean
        get() = userSettings.token != null

    suspend fun registerUser(mail: String, password: String): Boolean {
        val response = userApi.register(mail, password)

        if (response.isSuccess) {
            userSettings.apply {
                token = response.data.token
                currentUserId = response.data.id
            }
        }

        return response.isSuccess
    }

    suspend fun loginUser(mail: String, password: String): Boolean {
        val response = userApi.login(mail, password)

        if (response.isSuccess) {
            userSettings.apply {
                token = response.data
            }
        }

        return response.isSuccess
    }
}
