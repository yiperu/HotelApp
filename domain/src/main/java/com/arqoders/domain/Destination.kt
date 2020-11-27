package com.arqoders.domain

data class Destination (
    val geoId: String,
    val destinationId: String,
    val landmarkCityDestinationId: String,
    val type: String,
    val caption: String,
    val redirectPage: String,
    val latitude: Double,
    val longitude: Double,
    val name: String
)