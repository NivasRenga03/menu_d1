package com.example.menu_d.explore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ExploreViewModel : ViewModel() {

    private val _exploreText = MutableLiveData<String>().apply {
        value = "Welcome to the Explore Section!"
    }
    val exploreText: LiveData<String> = _exploreText
}
