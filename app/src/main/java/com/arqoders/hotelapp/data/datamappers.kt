package com.arqoders.hotelapp.data

import com.arqoders.domain.Hotel
import com.arqoders.hotelapp.data.database.Hotel as DomainHotel
import com.arqoders.hotelapp.data.server.Hotel as ServerHotel

fun Hotel.toRoomHotel(): DomainHotel =
    DomainHotel(
        id,
        name,
        latitude,
        longitude,
        favorite
    )

fun DomainHotel.toDomainHotel(): Hotel = Hotel(
    id,
    name,
    latitude,
    longitude,
    favorite
)

fun ServerHotel.toDomainHotel(): Hotel =
    Hotel(
        0,
        name,
        latitude,
        longitude,
        false
    )