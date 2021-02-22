package by.vfedorenko.multibooking.shared.network.entities

import kotlinx.serialization.Serializable

@Serializable
data class RemoteBook(
    val id: Long,
    val name: String,
    val owner_id: Long,
    val created_at: String,
    val updated_at: String,
    val status: String, //picked_up, reserved, in_library
    val dead_line: String?,
    val reader_user_id: Long?
)