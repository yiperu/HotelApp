package com.arqoders.usecases

import com.arqoders.data.repository.HotelsRepository
import com.arqoders.domain.Hotel

class FindHotelById(private val hotelsRepository: HotelsRepository) {
    suspend fun invoke(id: Int): Hotel = hotelsRepository.findById(id)
}