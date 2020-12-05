package com.arqoders.hotelapp.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.arqoders.domain.Hotel
import com.arqoders.hotelapp.base.BaseViewModel
import com.arqoders.hotelapp.ui.common.ScopedViewModel
import com.arqoders.usecases.GetHotels
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch

class MainViewModel : BaseViewModel<MainViewState>() {
    override fun getInitialViewState(): MainViewState = MainViewState()

    override fun initialize() {
    }
}