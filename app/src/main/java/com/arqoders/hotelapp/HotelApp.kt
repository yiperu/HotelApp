package com.arqoders.hotelapp

import android.app.Application

class HotelApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initDI()
    }
}