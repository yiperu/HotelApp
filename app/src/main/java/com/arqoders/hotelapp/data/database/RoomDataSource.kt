package com.arqoders.hotelapp.data.database

import com.arqoders.data.source.LocalDataSource
import com.arqoders.domain.Hotel
import com.arqoders.hotelapp.data.toDomainHotel
import com.arqoders.hotelapp.data.toRoomHotel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RoomDataSource(db: HotelDatabase) : LocalDataSource {

    private val hotelDao = db.hotelDao()

    override suspend fun isEmpty(): Boolean =
        withContext(Dispatchers.IO) { hotelDao.hotelCount() <= 0 }

    override suspend fun saveHotels(hotels: List<Hotel>) {
        withContext(Dispatchers.IO) { hotelDao.insertHotels(hotels.map { it.toRoomHotel() }) }
    }

    override suspend fun getHotels(): List<Hotel> = withContext(Dispatchers.IO) {
        hotelDao.getAll().map { it.toDomainHotel() }
    }

    override suspend fun findById(id: Int): Hotel = withContext(Dispatchers.IO) {
        hotelDao.findById(id).toDomainHotel()
    }

    override suspend fun update(hotel: Hotel) {
        withContext(Dispatchers.IO) { hotelDao.updateHotel(hotel.toRoomHotel()) }
    }
}