package com.arqoders.data.source

import com.arqoders.domain.Group

interface RemoteDataSource {
    suspend fun getSuggestions(query: String, locale: String): List<Group>
}