package com.example.activityandfragmentconnectiontest

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.activityandfragmentconnectiontest.utils.Event

class SharedViewModel : ViewModel() {

    val showSnackBarEvent = EventLiveData<String>()
    val updateNavController = EventLiveData<NavController>()

    fun showSnackBar(message: String) {
        showSnackBarEvent.value = Event(message)
    }

    fun updateNavController(controller: NavController) {
        updateNavController.value = Event(controller)
    }


    protected fun <T> EventLiveData() = MutableLiveData<Event<T>>()
}