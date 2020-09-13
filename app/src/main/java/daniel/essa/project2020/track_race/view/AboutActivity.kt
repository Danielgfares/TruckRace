package daniel.essa.project2020.track_race.view

import android.os.Bundle
import daniel.essa.project2020.track_race.R
import daniel.essa.project2020.track_race.ac.MainViewClass

class AboutActivity : MainViewClass() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        // settings menu action bar
        myMenuSettings()
        // settings toolbar
        actionBarSettings(R.id.action_bar_about)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}
