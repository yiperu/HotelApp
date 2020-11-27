package com.arqoders.data.source

import com.arqoders.domain.Hotel

interface LocalDataSource {
    suspend fun isEmpty(): Boolean
    suspend fun saveHotels(movies: List<Hotel>)
    suspend fun getHotels(): List<Hotel>
    suspend fun findById(id: Int): Hotel
    suspend fun update(hotel: Hotel)
}