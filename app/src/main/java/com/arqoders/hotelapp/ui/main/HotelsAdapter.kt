package com.arqoders.hotelapp.ui.main

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arqoders.domain.Hotel
import com.arqoders.hotelapp.R
import com.arqoders.hotelapp.databinding.ViewHotelBinding
import com.arqoders.hotelapp.ui.common.basicDiffUtil
import com.arqoders.hotelapp.ui.common.inflate
import kotlinx.android.synthetic.main.view_hotel.view.*

class HotelsAdapter(private val listener: (Hotel) -> Unit) :
    RecyclerView.Adapter<HotelsAdapter.ViewHolder>() {

    var hotels: List<Hotel> by basicDiffUtil(
        emptyList(),
        areItemsTheSame = { old, new -> old.id == new.id }
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = parent.inflate(R.layout.view_hotel, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = hotels.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val hotel = hotels[position]
        holder.bind(hotel)
        holder.itemView.setOnClickListener { listener(hotel) }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ViewHotelBinding.bind(view)
        fun bind(hotel: Hotel) {
            itemView.hotelTitle.text = hotel.name
        }
    }
}