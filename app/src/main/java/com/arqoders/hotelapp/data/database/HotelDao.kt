package com.arqoders.hotelapp.data.database

import androidx.room.*

@Dao
interface HotelDao {

    @Query("SELECT * FROM Hotel")
    fun getAll(): List<Hotel>

    @Query("SELECT * FROM Hotel WHERE id = :id")
    fun findById(id: Int): Hotel

    @Query("SELECT COUNT(id) FROM Hotel")
    fun hotelCount(): Int

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertHotels(hotels: List<Hotel>)

    @Update
    fun updateHotel(movie: Hotel)
}