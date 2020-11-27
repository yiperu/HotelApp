package com.arqoders.hotelapp.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Hotel(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String,
    val latitude: Double,
    val longitude: Double,
    val favorite: Boolean
)