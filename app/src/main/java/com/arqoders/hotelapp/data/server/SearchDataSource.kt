package com.arqoders.hotelapp.data.server

import com.arqoders.data.source.RemoteDataSource
import com.arqoders.domain.Group
import com.arqoders.hotelapp.data.toDomainGroup

class SearchDataSource(private val retrofitClientInstance: RetrofitClientInstance) : RemoteDataSource {
    override suspend fun getSuggestions(query: String, locale: String): List<Group> =
        retrofitClientInstance.service
            .listSuggestionsAsync(query, locale)
            .suggestions
            .map { it.toDomainGroup() }
}