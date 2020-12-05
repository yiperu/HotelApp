package com.arqoders.usecases

import com.arqoders.data.repository.HotelsRepository
import com.arqoders.domain.Hotel

class ToggleHotelFavorite(private val hotelsRepository: HotelsRepository) {
    suspend fun invoke(hotel: Hotel): Hotel = with(hotel) {
        copy(favorite = !favorite).also { hotelsRepository.update(it) }
    }
}