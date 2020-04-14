package daniel.essa.project2020.auto_scoop.ic

import android.view.Menu
import com.google.android.material.floatingactionbutton.FloatingActionButton
import daniel.essa.project2020.auto_scoop.R

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