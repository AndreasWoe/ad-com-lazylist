package at.htlwels.lazylist

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    var items = mutableStateListOf<String>()
    var selectedPayment : String by mutableStateOf("Keine Auswahl")
        private set

    init {
        items += "One"
        items += "Two"
        items += "Three"
        items.add("Four")
    }

    fun selectPayment(option: String) {
        selectedPayment = option
    }

    fun addItem(item: String) {
        items += item
    }
}