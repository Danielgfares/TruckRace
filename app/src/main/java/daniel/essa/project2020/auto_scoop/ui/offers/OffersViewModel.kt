package daniel.essa.project2020.auto_scoop.ui.offers

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OffersViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is my offers Fragment"
    }
    val text: LiveData<String> = _text
}