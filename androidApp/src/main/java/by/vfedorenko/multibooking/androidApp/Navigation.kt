package by.vfedorenko.multibooking.androidApp

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

/**
 * Class defining the screens we have in the app: home, article details and interests
 */
sealed class Screen(val title: String) {
    object Login : Screen("LOGIN")
    object Registration : Screen("REGISTRATION")
//    data class Article(val postId: String) : Screen(ARTICLE)
}

class NavigationViewModel() : ViewModel() {
//    /**
//     * Hold the current screen in an observable, restored from savedStateHandle after process
//     * death.
//     *
//     * mutableStateOf is an observable similar to LiveData that's designed to be read by compose. It
//     * supports observability via property delegate syntax as shown here.
//     */
//    var currentScreen: Screen by savedStateHandle.getMutableStateOf<Screen>(
//        key = SIS_SCREEN,
//        default = Home,
//        save = { it.toBundle() },
//        restore = { it.toScreen() }
//    )
//        private set // limit the writes to only inside this class.

}