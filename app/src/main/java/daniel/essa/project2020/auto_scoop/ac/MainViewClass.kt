package daniel.essa.project2020.auto_scoop.ac

import android.content.Intent
import android.os.Handler
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import daniel.essa.project2020.auto_scoop.*
import daniel.essa.project2020.auto_scoop.ic.NaviInterface
import daniel.essa.project2020.auto_scoop.ic.ViewInterface
import daniel.essa.project2020.auto_scoop.view.LoginActivity
import daniel.essa.project2020.auto_scoop.view.AboutActivity
import daniel.essa.project2020.auto_scoop.view.SettingsActivity

abstract class MainViewClass : AppCompatActivity(),
    ViewInterface, NaviInterface {

    override var doubleBackToExitPressedOnce: Boolean = false
    override var menu: Int = R.menu.option_menu_not_logged_in

    override fun setDoubleBack(bool:Boolean){
        this.doubleBackToExitPressedOnce = bool
    }

    override fun getDoubleBack() : Boolean {
        return doubleBackToExitPressedOnce
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

    override fun myMenuSettings() {
        if (MySingleton.getLoggedin()){
            menu =
                R.menu.option_menu_logged_in
        }else {
            menu =
                R.menu.option_menu_not_logged_in
        }
    }

    override fun actionBarSettings(toolbar: Int) {
        val actionToolbar = findViewById<androidx.appcompat.widget.Toolbar>(toolbar)
        setSupportActionBar(actionToolbar)
    }

    override fun fabSettings( fab : Int) {
        val floatingFab : FloatingActionButton = findViewById(fab)
        floatingFab.setOnClickListener { view ->
            Snackbar.make(view, "This are notification", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // settings menu action bar
        myMenuSettings()
        val inflater: MenuInflater = menuInflater
        inflater.inflate(this.menu, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return if (MySingleton.getLoggedin()){
            menuloggedin(item)
        }else {
            menunotloggedin(item)
        }
    }
    private fun menunotloggedin(item: MenuItem):Boolean {
        return when (item.itemId) {
            R.id.signup -> {
                // TODO if logged in you will not see this, if you need to sign up it will take to sign up page
                // for it will take you to the log in page or sign in page
                onLoginPressed()
                true
            }
            R.id.login -> {
                // to log in page and should ask if not signed up to sign up and then go back to main activity
                onLoginPressed()
                //Toast.makeText(this, R.string.login, Toast.LENGTH_SHORT).show()
                true
            }
            R.id.settings -> {
                onSettingsPressed()
                //Toast.makeText(this, R.string.sort_most_recent, Toast.LENGTH_SHORT).show()
                true
            }
            R.id.info -> {
                //TODO
                onAboutPressed()
                Toast.makeText(this,
                    R.string.sort_registration_year, Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun menuloggedin(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.my_account -> {
                //TODO
                Toast.makeText(this,
                    R.string.sort_price, Toast.LENGTH_SHORT).show()
                true
            }
            R.id.my_adds -> {
                //TODO
                Toast.makeText(this,
                    R.string.sort_most_recent, Toast.LENGTH_SHORT).show()
                true
            }
            R.id.recent_seen -> {
                //TODO
                Toast.makeText(this,
                    R.string.sort_registration_year, Toast.LENGTH_SHORT).show()
                true
            }
            R.id.recent_searches -> {
                //TODO
                Toast.makeText(this,
                    R.string.sort_mileag, Toast.LENGTH_SHORT).show()
                true
            }
            R.id.settings -> {
                onSettingsPressed()
                //Toast.makeText(this, R.string.sort_full_consumption, Toast.LENGTH_SHORT).show()
                true
            }
            R.id.info -> {
                onAboutPressed()
                //Toast.makeText(this, R.string.sort_vehicle_weight, Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
// funs for when buttons get pressed
    /**
     *
     *
     *
     *
     */
    private fun onLoginPressed(){
        val intent = Intent(this, LoginActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

    /**
     *
     *
     *
     */
    private fun onSettingsPressed(){
        val intent = Intent(this,
            SettingsActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }
    /**
     *
     *
     *
     */
    private fun onAboutPressed(){
        val intent = Intent(this,
            AboutActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }
}