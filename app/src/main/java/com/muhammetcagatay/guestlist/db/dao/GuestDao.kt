package com.cagatay.boomsetapp.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.cagatay.boomsetapp.db.entity.Event
import com.cagatay.boomsetapp.db.entity.Guest

/**
 * Created by Muhammet ÇAĞATAY on 15,Şubat,2020
 */

@Dao
interface GuestDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg anr: Guest)

    @Query("DELETE FROM guests")
    fun deleteAll()

    @Query("SELECT COUNT(*) from guests")
    fun getAllGuests() :MutableList<Guest>

    @Query("SELECT COUNT(*) from guests")
    fun getAllGuestsCount() :Int

}