package com.arqoders.hotelapp.base

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel<V> : ViewModel() {
    val resourceViewState: MediatorLiveData<V> =
        MediatorLiveData<V>().apply { postValue(getInitialViewState()) }

    abstract fun getInitialViewState(): V
    abstract fun initialize()
}