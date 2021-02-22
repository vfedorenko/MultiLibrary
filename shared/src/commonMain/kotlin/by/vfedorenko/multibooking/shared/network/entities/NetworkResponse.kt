package by.vfedorenko.multibooking.shared.network.entities

import kotlinx.serialization.Serializable

@Serializable
data  class NetworkResponse<Type>(
    val code: Int,
    val status: String,
    val data: Type
) {
    val isSuccess: Boolean = code in 200..399
}
