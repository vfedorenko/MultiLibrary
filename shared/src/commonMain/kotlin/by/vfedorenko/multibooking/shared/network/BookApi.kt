package by.vfedorenko.multibooking.shared.network

import by.vfedorenko.multibooking.shared.network.entities.NetworkResponse
import by.vfedorenko.multibooking.shared.network.entities.RemoteBook
import by.vfedorenko.multibooking.shared.network.entities.RemoteUser
import by.vfedorenko.multibooking.shared.network.entities.UserPayload
import io.ktor.client.request.*


private const val BOOKS_ENDPOINT = "$BASE_ENDPOINT/books/"
//private const val LOGIN_ENDPOINT = "${BASE_ENDPOINT}login"

class BookApi : Api() {

    suspend fun getAllBooks(): NetworkResponse<List<RemoteBook>> =
        httpClient.get(BOOKS_ENDPOINT) {
            header("content-type", "application/json")
        }

    suspend fun getBook(id: Long): NetworkResponse<RemoteBook> =
        httpClient.get("$BOOKS_ENDPOINT/$id") {
            header("content-type", "application/json")
        }

}