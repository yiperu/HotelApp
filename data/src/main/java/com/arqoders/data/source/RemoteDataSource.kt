package com.arqoders.data.source

import com.arqoders.domain.Entity

interface RemoteDataSource {
    suspend fun getHotels(query: String, locale: String, apiKey: String, host: String): List<Entity>
}