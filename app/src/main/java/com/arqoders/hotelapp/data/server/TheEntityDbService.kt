package com.arqoders.hotelapp.data.server

import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface TheEntityDbService {
    @GET("https://hotels4.p.rapidapi.com/locations/search")
    suspend fun listHotelsAsync(
        @Header("x-rapidapi-key") api_key: String,
        @Header("x-rapidapi-host") host: String,
        @Query("query") query: String,
        @Query("locale") locale: String
    ): EntitiesDbResult
}

