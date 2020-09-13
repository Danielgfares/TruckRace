package daniel.essa.project2020.track_race.ui.signuser

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import android.util.Patterns
import daniel.essa.project2020.track_race.data.LoginRepository
import daniel.essa.project2020.track_race.data.Result

import daniel.essa.project2020.track_race.R

class MasterSignViewModel(private val loginRepository: LoginRepository) : ViewModel() {

    private val _loginForm = MutableLiveData<LoginFormState>()
    val loginFormState: LiveData<LoginFormState> = _loginForm

    private val _registerForm = MutableLiveData<RegisterFormState>()
    val registerFormState: LiveData<RegisterFormState> = _registerForm

    private val _loginResult = MutableLiveData<LoginResult>()
    val loginResult: LiveData<LoginResult> = _loginResult

    fun login(email: String, password: String) {
        // can be launched in a separate asynchronous job
        val result = loginRepository.login(email, password)

        if (result is Result.Success) {
            _loginResult.value =
                LoginResult(
                    success = LoggedInUserView(
                        displayName = result.data.displayName
                    )
                )
        } else {
            _loginResult.value =
                LoginResult(error = R.string.login_failed)
        }
    }

    fun loginDataChanged(email: String, password: String) {
        if (!isEmailValid(email)) {
            _loginForm.value =
                LoginFormState(
                    emailError = R.string.invalid_username
                )
        } else if (!isPasswordValid(password)) {
            _loginForm.value =
                LoginFormState(
                    passwordError = R.string.invalid_password
                )
        } else {
            _loginForm.value =
                LoginFormState(
                    isDataValid = true
                )
        }
    }

    fun register(email: String, password: String) {
        // can be launched in a separate asynchronous job
        val result = loginRepository.register(email, password)

        if (result is Result.Success) {
            _loginResult.value =
                LoginResult(
                    success = LoggedInUserView(
                        displayName = result.data.displayName
                    )
                )
        } else {
            _loginResult.value =
                LoginResult(error = R.string.login_failed)
        }
    }

    fun registerDataChanged(email: String, password: String) {
        if (!isEmailValid(email)) {
            _registerForm.value =
                RegisterFormState(
                    emailError = R.string.invalid_username
                )
        } else if (!isPasswordValid(password)) {
            _registerForm.value =
                RegisterFormState(
                    passwordError = R.string.invalid_password
                )
        } else {
            _registerForm.value =
                RegisterFormState(
                    isDataValid = true
                )
        }
    }

    // A placeholder username validation check
    private fun isUserNameValid(username: String): Boolean {
        return username.isNotBlank()
    }

    // A placeholder email validation check
    private fun isEmailValid(email: String): Boolean {
        return if (email.contains('@')) {
            Patterns.EMAIL_ADDRESS.matcher(email).matches()
        } else {
            false
        }
    }

    // A placeholder password validation check
    private fun isPasswordValid(password: String): Boolean {
        return password.length > 5
    }

    fun isLoggedIn(): Boolean{
        return loginRepository.isLoggedIn
    }

    fun logout(){
        if (isLoggedIn()){
            loginRepository.logout()
        }
    }


}
