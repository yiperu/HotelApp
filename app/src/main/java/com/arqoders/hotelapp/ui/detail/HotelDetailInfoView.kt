package com.arqoders.hotelapp.ui.detail

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.text.bold
import androidx.core.text.buildSpannedString
import com.arqoders.domain.Hotel

class HotelDetailInfoView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatTextView(context, attrs, defStyleAttr) {

    fun setHotel(hotel: Hotel) = with(hotel) {
        text = buildSpannedString {

            bold { append("Latitude: ") }
            appendLine(latitude.toString())

            bold { append("Longitude: ") }
            appendLine(longitude.toString())
        }
    }
}