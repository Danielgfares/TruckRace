package daniel.essa.project2020.track_race.ac

import android.os.Handler
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import daniel.essa.project2020.track_race.ic.NaviInterface

abstract class MainNaviClass  : AppCompatActivity(),
    NaviInterface {

    override var doubleBackToExitPressedOnce: Boolean = false


    override fun setDoubleBack(bool:Boolean){
        this.doubleBackToExitPressedOnce = bool
    }
    override fun getDoubleBack() : Boolean {
        return doubleBackToExitPressedOnce
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