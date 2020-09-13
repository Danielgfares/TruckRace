package daniel.essa.project2020.track_race.data

import daniel.essa.project2020.track_race.data.model.LoggedInUser
import java.io.IOException

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource {

    fun login(email: String, password: String): Result<LoggedInUser> {
        try {
            // TODO: handle loggedInUser authentication
            val fakeUser = LoggedInUser(java.util.UUID.randomUUID().toString(), email)
            return Result.Success(fakeUser)
        } catch (e: Throwable) {
            return Result.Error(IOException("Error logging in", e))
        }
    }

    fun register(email: String, password: String): Result<LoggedInUser> {
        return login(email,password)
    }

    fun logout() {
        // TODO: revoke authentication
    }
}

