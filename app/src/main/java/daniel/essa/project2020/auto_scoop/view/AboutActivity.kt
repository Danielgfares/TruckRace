package daniel.essa.project2020.auto_scoop.view

import android.os.Bundle
import daniel.essa.project2020.auto_scoop.R
import daniel.essa.project2020.auto_scoop.ac.MainViewClass

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
