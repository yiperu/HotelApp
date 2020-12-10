package com.arqoders.hotelapp.data.server

import com.arqoders.hotelapp.util.API_BASE_URL
import com.arqoders.hotelapp.util.API_HOST
import com.arqoders.hotelapp.util.API_KEY
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {
    @Headers(
        "x-rapidapi-key: $API_KEY",
        "x-rapidapi-host: $API_HOST"
    )
    @GET("$API_BASE_URL/locations/search")
    suspend fun listSuggestionsAsync(
        @Query("query") query: String,
        @Query("locale") locale: String
    ): SearchResponse
}

