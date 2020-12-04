package com.arqoders.hotelapp.ui.home

import com.arqoders.hotelapp.base.BaseViewModel

class HomeViewModel : BaseViewModel<HomeViewState>() {
    override fun getInitialViewState(): HomeViewState = HomeViewState()

    override fun initialize() {
    }
}