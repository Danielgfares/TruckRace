package daniel.essa.project2020.auto_scoop

object MySingleton {
    init { setLoggedin(false) }
    private var isLoggedin = false
    fun setLoggedin(value : Boolean) { isLoggedin = value }
    fun getLoggedin() : Boolean { return isLoggedin }

}