package daniel.essa.project2020.track_race.ui.signuser

/**
 * Data validation state of the login form.
 */
data class RegisterFormState(
    val emailError: Int? = null,
    val passwordError: Int? = null,
    val passwordConfirmError: Int? = null,
    val companyError: Int? = null,
    val nameError: Int? = null,
    val nick_nameError: Int? = null,
    val birth_dateError: Int? = null,
    val locationError: Int? = null,
    val phoneError: Int? = null,
    val isDataValid: Boolean = false
)
