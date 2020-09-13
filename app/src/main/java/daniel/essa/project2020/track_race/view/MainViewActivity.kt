package daniel.essa.project2020.track_race.view

import android.os.Bundle
import android.os.Handler
import android.view.MenuItem
import android.widget.ImageButton
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import daniel.essa.project2020.track_race.R
import daniel.essa.project2020.track_race.ac.MainViewClass

class MainViewActivity : MainViewClass() {

    private var sortingOrder: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // settings menu action bar
        myMenuSettings()
        // settings toolbar
        actionBarSettings()
        // settings fab foltante
        fabSettings(R.id.fab_main)
        // settings button menu foltante
        floatMenuSettings()
        // settings changing sotring
        sortingSettings()
    }

    private fun actionBarSettings(){
        super.actionBarSettings(R.id.action_bar_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
            R.id.navigation_home,
            R.id.navigation_favorite,
            R.id.navigation_offers
        ))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    private fun floatMenuSettings(){
        val button1 = findViewById<ImageButton>(R.id.menu_button1)
        button1.setOnClickListener {
            val popupMenu: android.widget.PopupMenu =
                android.widget.PopupMenu(this, button1)
            popupMenu.menuInflater.inflate(R.menu.upper_viewpager_menu,popupMenu.menu)
            popupMenu.setOnMenuItemClickListener { item ->
                menuSort(item)
            }
            popupMenu.show()
        }
    }

    private fun sortingSettings(){
        val ascedening:ImageButton = findViewById(R.id.button_ascending)
        ascedening.setOnClickListener{
            sortingOrder = if (sortingOrder){
                ascedening.setImageResource(R.drawable.ic_sort_descending)
                false
            }else{
                ascedening.setImageResource(R.drawable.ic_sort_ascending)
                true
            }
            onClickButtonSorting()
        }
    }

    private fun onClickButtonSorting(){
        //TODO when you have data
    }

    private fun menuSort(item: MenuItem):Boolean {
        return when (item.itemId) {
            R.id.price -> {
                //TODO
                Toast.makeText(this,
                    R.string.sort_price, Toast.LENGTH_SHORT).show()
                true
            }
            R.id.most_recent -> {
                //TODO
                Toast.makeText(this,
                    R.string.sort_most_recent, Toast.LENGTH_SHORT).show()
                true
            }
            R.id.registration_year -> {
                //TODO
                Toast.makeText(this,
                    R.string.sort_registration_year, Toast.LENGTH_SHORT).show()
                true
            }
            R.id.mileag -> {
                //TODO
                Toast.makeText(this,
                    R.string.sort_mileag, Toast.LENGTH_SHORT).show()
                true
            }
            R.id.fule_consumption -> {
                //TODO
                Toast.makeText(this,
                    R.string.sort_full_consumption, Toast.LENGTH_SHORT).show()
                true
            }
            R.id.vehicle_weight -> {
                //TODO
                Toast.makeText(this,
                    R.string.sort_vehicle_weight, Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onBackPressed() {
        if (getDoubleBack()) {
            super.onBackPressed()
            return
        }
        setDoubleBack(true)
        Toast.makeText(this, "Press again to exit", Toast.LENGTH_SHORT).show()
        Handler().postDelayed({ setDoubleBack(false) }, 2000)
    }
}
