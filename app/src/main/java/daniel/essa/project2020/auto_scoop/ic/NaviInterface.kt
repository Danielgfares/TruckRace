package daniel.essa.project2020.auto_scoop.ic

interface NaviInterface {
    var doubleBackToExitPressedOnce: Boolean
    fun setDoubleBack(bool:Boolean)
    fun getDoubleBack() : Boolean
    fun onBackPressed()
}