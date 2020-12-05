package com.arqoders.hotelapp.data.server

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Group(
    val group: String,
    val entities: List<Entity>
) : Parcelable