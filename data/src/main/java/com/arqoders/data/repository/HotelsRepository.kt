package com.arqoders.data.repository

import com.arqoders.data.source.LocalDataSource
import com.arqoders.data.source.RemoteDataSource
import com.arqoders.domain.Hotel

class HotelsRepository(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource,
    private val regionRepository: RegionRepository,
    private val query: String,
    private val locale: String
) {

    suspend fun getHotels(): List<Hotel> {

        if (localDataSource.isEmpty()) {
            val entities = remoteDataSource.getSuggestions(query, locale)
            //localDataSource.saveHotels(entities)
        }

        return localDataSource.getHotels()
    }

    suspend fun findById(id: Int): Hotel = localDataSource.findById(id)

    suspend fun update(hotel: Hotel) = localDataSource.update(hotel)
}