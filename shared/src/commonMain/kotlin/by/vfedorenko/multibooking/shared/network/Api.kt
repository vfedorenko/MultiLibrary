package by.vfedorenko.multibooking.shared.network

import by.vfedorenko.multibooking.shared.network.entities.NetworkResponse
import by.vfedorenko.multibooking.shared.network.entities.RemoteUser
import by.vfedorenko.multibooking.shared.network.entities.UserPayload
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.http.auth.*
import kotlinx.serialization.json.Json


const val BASE_ENDPOINT = "https://powerful-citadel-31931.herokuapp.com/api/v1"

open class Api {
    protected val httpClient = HttpClient {
        defaultRequest {
            header("content-type", "application/json")
        }
//        headersOf(
//            "content-type" to "application/json"
//        )
        install(JsonFeature) {
            val json = Json { ignoreUnknownKeys = true }
            serializer = KotlinxSerializer(json)
        }
//        install(HttpAuthHeader)
//        install(HttpAuthHeader) {
//
//        }
//        install()
    }

    protected fun HttpRequestBuilder.addUrl(path: String) {
        url {
            takeFrom(BASE_ENDPOINT)
            encodedPath = path
        }
    }
}
