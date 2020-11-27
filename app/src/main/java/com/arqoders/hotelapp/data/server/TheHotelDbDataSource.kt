package com.arqoders.hotelapp.data.server

import com.arqoders.data.source.RemoteDataSource
import com.arqoders.domain.Hotel
import com.arqoders.hotelapp.data.toDomainHotel

class TheHotelDbDataSource(private val theHotelDb: TheHotelDb) : RemoteDataSource {
    override suspend fun getHotels(query: String, locale: String, apiKey: String, host: String): List<Hotel> =
        theHotelDb.service
            .listHotelsAsync(query, locale, apiKey, host)
            .suggestions
            .map { it.toDomainHotel() }
}