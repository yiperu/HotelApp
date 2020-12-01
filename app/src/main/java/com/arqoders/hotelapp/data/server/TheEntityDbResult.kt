package com.arqoders.hotelapp.data.server

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class EntitiesDbResult(
    val term: String,
    val suggestions: List<Group>
)

@Parcelize
data class Group(
    val group: String,
    val entities: List<Entity>
) : Parcelable

@Parcelize
data class Entity(
    @SerializedName("id") val destinationId: Int,
    val name: String,
    val type: String,
    val latitude: Double,
    val longitude: Double
) : Parcelable