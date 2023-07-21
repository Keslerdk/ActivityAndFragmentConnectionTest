package com.example.activityandfragmentconnectiontest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {
    private val _counter = MutableLiveData(0)
    val counter get() = _counter as LiveData<Int>

    fun incrementCounter() {
        _counter.value = _counter.value?.plus(1)
    }
}