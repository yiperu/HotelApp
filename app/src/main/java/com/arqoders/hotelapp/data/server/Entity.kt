package com.arqoders.hotelapp.data.server

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Entity(
    @SerializedName("geo_id") val geoId: String,
    @SerializedName("id") val destinationId: String,
    @SerializedName("landmark_city_destination_id") val landmarkCityDestinationId: String,
    val type: String,
    val caption: String,
    @SerializedName("redirect_page") val redirectPage: String,
    val latitude: Double,
    val longitude: Double,
    val name: String
) : Parcelable