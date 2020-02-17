package com.cagataymuhammet.guestlist.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.cagataymuhammet.guestlist.db.entity.Event

/**
 * Created by Muhammet ÇAĞATAY on 15,Şubat,2020
 */


@Dao
interface EventDao {

    @Insert(onConflict = REPLACE)
    fun insert(vararg anr: Event)

    @Query("DELETE FROM events")
    fun deleteAll()

    @Query("SELECT * from events")
    fun getAllEvents() :MutableList<Event>

    @Query("SELECT COUNT(*) from events")
    fun getAllEventsCount() :Int

}