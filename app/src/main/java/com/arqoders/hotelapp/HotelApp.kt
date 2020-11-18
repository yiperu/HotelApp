package com.arqoders.hotelapp

/**
 * Created by Marcos Salto on 18/11/2020.
 */

import android.app.Application

class HotelApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initDI()
    }
}