package by.vfedorenko.multibooking.shared.network.entities

import kotlinx.serialization.Serializable


@Serializable
data class RemoteUser (
    val id: Long,
    val mail: String,
    val token: String
)

@Serializable
data class UserPayload (
    val mail: String,
    val password: String
)
