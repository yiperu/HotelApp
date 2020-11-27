package com.arqoders.usecases

import com.arqoders.data.repository.HotelsRepository
import com.arqoders.domain.Hotel

class GetHotels(private val hotelsRepository: HotelsRepository) {
    suspend fun invoke(): List<Hotel> = hotelsRepository.getHotels()
}