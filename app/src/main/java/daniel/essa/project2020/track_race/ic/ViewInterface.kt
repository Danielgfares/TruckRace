package daniel.essa.project2020.track_race.ic

import android.view.Menu

interface ViewInterface {
    var menu : Int
    // settings menu action bar
    fun myMenuSettings()
    // settings toolbar
    fun actionBarSettings(toolbar : Int)
    // settings fab foltante
    fun fabSettings(fab: Int)
    // menu tool bar
    fun onCreateOptionsMenu(menu: Menu?): Boolean
}