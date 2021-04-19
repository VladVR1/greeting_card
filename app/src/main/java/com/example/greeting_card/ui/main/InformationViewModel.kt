package com.example.greeting_card.ui.main

import android.content.SharedPreferences
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InformationViewModel : ViewModel() {

    var name = MutableLiveData<String>()
    var title = MutableLiveData<String>()
    var text = MutableLiveData<String>()

    fun savePreferences(preferences: SharedPreferences, name: String, title: String, text: String) {
        val editor = preferences.edit()
        editor.putString("name", name)
        editor.putString("title", title)
        editor.putString("text", text)
        editor.apply()
    }
}