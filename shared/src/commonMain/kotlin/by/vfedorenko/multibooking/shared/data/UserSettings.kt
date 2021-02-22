package by.vfedorenko.multibooking.shared.data

import com.russhwolf.settings.Settings
import com.russhwolf.settings.set


private const val KEY_TOKEN = "KEY_TOKEN"
private const val KEY_USER_ID = "KEY_USER_ID"

class UserSettings(private val settings: Settings) {

    var token: String?
        get() = settings.getStringOrNull(KEY_TOKEN)
        set(value) = settings.set(KEY_TOKEN, value)

    var currentUserId: Long?
        get() = settings.getLongOrNull(KEY_USER_ID)
        set(value) = settings.set(KEY_USER_ID, value)

}