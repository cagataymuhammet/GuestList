package com.cagataymuhammet.guestlist.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.cagataymuhammet.guestlist.db.entity.Event
import com.cagataymuhammet.guestlist.db.entity.Guest

/**
 * Created by Muhammet ÇAĞATAY on 15,Şubat,2020
 */

@Dao
interface GuestDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg guest: Guest)

    @Query("DELETE FROM guests")
    fun deleteAll()

    @Query("DELETE FROM guests where event==:eventId")
    fun deleteAllByEventId(eventId:Int)

    @Query("SELECT * from guests")
    fun getAllGuests() :MutableList<Guest>


    @Query("SELECT * from guests where event==:eventID")
    fun getAllGuestsByEventID(eventID:Int) :MutableList<Guest>

    @Query("SELECT COUNT(*) from guests")
    fun getAllGuestsCount() :Int

}