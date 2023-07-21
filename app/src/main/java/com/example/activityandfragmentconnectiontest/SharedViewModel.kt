package com.example.activityandfragmentconnectiontest

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.activityandfragmentconnectiontest.utils.Event

class SharedViewModel : ViewModel() {

    val showSnackBarEvent = EventLiveData<String>()

    fun showSnackBar(message: String) {
        showSnackBarEvent.value = Event(message)
    }


    protected fun <T> EventLiveData() = MutableLiveData<Event<T>>()
}