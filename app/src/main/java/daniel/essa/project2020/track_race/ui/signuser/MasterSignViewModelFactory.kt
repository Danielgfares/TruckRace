package daniel.essa.project2020.track_race.ui.signuser

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import daniel.essa.project2020.track_race.data.LoginDataSource
import daniel.essa.project2020.track_race.data.LoginRepository

/**
 * ViewModel provider factory to instantiate LoginViewModel.
 * Required given LoginViewModel has a non-empty constructor
 */
class MasterSignViewModelFactory : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MasterSignViewModel::class.java)) {
            return MasterSignViewModel(
                loginRepository = LoginRepository(
                    dataSource = LoginDataSource()
                )
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
