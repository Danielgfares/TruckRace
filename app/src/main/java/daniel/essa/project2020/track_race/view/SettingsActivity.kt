package daniel.essa.project2020.track_race.view

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import daniel.essa.project2020.track_race.R
import daniel.essa.project2020.track_race.ac.MainViewClass

class SettingsActivity : MainViewClass() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        // settings menu action bar
        myMenuSettings()
        // settings toolbar
        actionBarSettings(R.id.action_bar_settings)

        supportFragmentManager
            .beginTransaction()
            .replace(
                R.id.settings,
                SettingsFragment()
            )
            .commit()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    class SettingsFragment : PreferenceFragmentCompat() {
        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
            setPreferencesFromResource(R.xml.root_preferences, rootKey)
        }
    }
}