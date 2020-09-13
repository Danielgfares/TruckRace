package daniel.essa.project2020.track_race.ic

interface NaviInterface {
    var doubleBackToExitPressedOnce: Boolean
    fun setDoubleBack(bool:Boolean)
    fun getDoubleBack() : Boolean
    fun onBackPressed()
}