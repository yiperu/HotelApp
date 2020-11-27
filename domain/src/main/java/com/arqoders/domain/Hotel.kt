package com.arqoders.domain

data class Hotel(
    val id: Int,
    val name: String,
    val latitude: Double,
    val longitude: Double,
    val favorite: Boolean
)