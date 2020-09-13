package daniel.essa.project2020.track_race.view

import android.content.Intent
import android.os.Bundle
import daniel.essa.project2020.track_race.MySingleton
import daniel.essa.project2020.track_race.R
import daniel.essa.project2020.track_race.ac.MainNaviClass

class StarterActivity : MainNaviClass() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_starter)
        isLoggedIn()
        onCreateActivity()
    }

    private fun onCreateActivity(){
        val intent = Intent(this,
            MainViewActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }
    // recover data and see if user is logged in or not
    // change is logged in by what its discover
    private fun isLoggedIn(){
        // TODO
        MySingleton.setLoggedin(false)
    }
}