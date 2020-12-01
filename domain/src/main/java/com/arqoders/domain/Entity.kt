package com.arqoders.domain

data class Entity(
    val destinationId: Int,
    val name: String,
    val type: String,
    val latitude: Double,
    val longitude: Double
)