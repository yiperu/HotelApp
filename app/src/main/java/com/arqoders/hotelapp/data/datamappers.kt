package com.arqoders.hotelapp.data

import com.arqoders.domain.Entity
import com.arqoders.domain.Group
import com.arqoders.domain.Hotel
import com.arqoders.hotelapp.data.database.Hotel as DomainHotel
import com.arqoders.hotelapp.data.server.Entity as ServerEntity
import com.arqoders.hotelapp.data.server.Group as ServerGroup

fun Hotel.toRoomHotel(): DomainHotel =
    DomainHotel(
        id,
        name,
        latitude,
        longitude,
        favorite
    )

fun ServerGroup.toDomainGroup(): Group =
    Group(
        group,
        entities
    )

fun ServerEntity.toDomainEntity(): Entity =
    Entity(
        0,
        name,
        type,
        latitude,
        longitude
    )

fun DomainHotel.toDomainHotel(): Hotel = Hotel(
    id,
    name,
    latitude,
    longitude,
    favorite
)
