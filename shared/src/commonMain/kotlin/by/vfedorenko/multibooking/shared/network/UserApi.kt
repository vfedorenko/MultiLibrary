package by.vfedorenko.multibooking.shared.network

import by.vfedorenko.multibooking.shared.network.entities.NetworkResponse
import by.vfedorenko.multibooking.shared.network.entities.RemoteUser
import by.vfedorenko.multibooking.shared.network.entities.UserPayload
import io.ktor.client.request.*


private const val USER_ENDPOINT = "/users"
private const val LOGIN_ENDPOINT = "$BASE_ENDPOINT/login"

class UserApi : Api() {

    suspend fun register(mail: String, password: String): NetworkResponse<RemoteUser> =
        httpClient.post {
            addUrl(USER_ENDPOINT)
            body = UserPayload(mail, password)
        }

    suspend fun login(mail: String, password: String): NetworkResponse<String> =
        httpClient.post(LOGIN_ENDPOINT) {
            header("content-type", "application/json")
            body = UserPayload(mail, password)
        }
}
