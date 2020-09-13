package daniel.essa.project2020.track_race.view

import android.app.Activity
import android.content.Intent
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import daniel.essa.project2020.track_race.MySingleton
import daniel.essa.project2020.track_race.R
import daniel.essa.project2020.track_race.afterTextChanged
import daniel.essa.project2020.track_race.ui.signuser.LoggedInUserView
import daniel.essa.project2020.track_race.ui.signuser.MasterSignViewModel
import daniel.essa.project2020.track_race.ui.signuser.MasterSignViewModelFactory

class RegisterActivity : AppCompatActivity() {

    private lateinit var masterSignViewModel: MasterSignViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        // input
        val email = findViewById<EditText>(R.id.email_register)
        val company = findViewById<EditText>(R.id.company_name_register)
        val password = findViewById<EditText>(R.id.password_register)
        val passwordConfirm = findViewById<EditText>(R.id.password_register_confirm)
        val name = findViewById<EditText>(R.id.name)
        val nickName= findViewById<EditText>(R.id.nick_name)
        val birthDate= findViewById<EditText>(R.id.birth_date)
        val location = findViewById<EditText>(R.id.location)
        val phone = findViewById<EditText>(R.id.phone_number)
        val register = findViewById<Button>(R.id.Register)
        val loading = findViewById<ProgressBar>(R.id.loading_register)

        masterSignViewModel = ViewModelProvider(this,
            MasterSignViewModelFactory()
        )
            .get(MasterSignViewModel::class.java)

        masterSignViewModel.registerFormState.observe(this@RegisterActivity, Observer {
            val registerState = it ?: return@Observer

            // disable login button unless both username / password is valid
            register.isEnabled = registerState.isDataValid

            if (registerState.emailError != null) {
                email.error = getString(registerState.emailError)
            }
            if (registerState.passwordError != null) {
                password.error = getString(registerState.passwordError)
            }
            if (registerState.passwordConfirmError != null) {
                passwordConfirm.error = getString(registerState.passwordConfirmError)
            }
            if (registerState.companyError != null) {
                company.error = getString(registerState.companyError)
            }
            if (registerState.nameError != null) {
                name.error = getString(registerState.nameError)
            }
            if (registerState.nick_nameError != null) {
                nickName.error = getString(registerState.nick_nameError)
            }
            if (registerState.birth_dateError != null) {
                birthDate.error = getString(registerState.birth_dateError)
            }
            if (registerState.locationError != null) {
                location.error = getString(registerState.locationError)
            }
            if (registerState.phoneError != null) {
                phone.error = getString(registerState.phoneError)
            }
        })

        masterSignViewModel.loginResult.observe(this@RegisterActivity, Observer {
            val loginResult = it ?: return@Observer

            loading.visibility = View.GONE
            if (loginResult.error != null) {
                showRegisterFailed(loginResult.error)
            }
            if (loginResult.success != null) {
                updateUiWithUser(loginResult.success)

            }
            setResult(Activity.RESULT_OK)
            onRegisterButtonPressed()
        })

        email.afterTextChanged {
            masterSignViewModel.registerDataChanged(
                email.text.toString(),
                password.text.toString()
            )
        }

        password.apply {
            afterTextChanged {
                masterSignViewModel.registerDataChanged(
                    email.text.toString(),
                    password.text.toString()
                )
            }

            setOnEditorActionListener { _, actionId, _ ->
                when (actionId) {
                    EditorInfo.IME_ACTION_DONE ->
                        masterSignViewModel.register(
                            email.text.toString(),
                            password.text.toString()
                        )
                }
                false
            }

            register.setOnClickListener {
                loading.visibility = View.VISIBLE
                masterSignViewModel.register(email.text.toString(), password.text.toString())
            }
        }
    }

    private fun updateUiWithUser(model: LoggedInUserView) {
        val welcome = getString(R.string.welcome)
        val displayName = model.displayName
        // TODO
        Toast.makeText(
            applicationContext,
            "$welcome $displayName",
            Toast.LENGTH_LONG
        ).show()
        if(masterSignViewModel.isLoggedIn()){
            MySingleton.setLoggedin(true)
        }
    }

    private fun showRegisterFailed(@StringRes errorString: Int) {
        Toast.makeText(applicationContext, errorString, Toast.LENGTH_SHORT).show()
    }

    private fun onRegisterButtonPressed(){
        val intent = Intent(this,
            MainViewActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
    }
}