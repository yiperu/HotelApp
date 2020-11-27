package com.arqoders.hotelapp.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Hotel::class], version = 1)
abstract class HotelDatabase : RoomDatabase() {

    companion object {
        fun build(context: Context) = Room.databaseBuilder(
            context,
            HotelDatabase::class.java,
            "hotel-db"
        ).build()
    }

    abstract fun hotelDao(): HotelDao
}