package com.muhammetcagatay.guestlist.model.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.cagataymuhammet.guestlist.db.dao.EventDao
import com.cagataymuhammet.guestlist.db.dao.GuestDao
import com.cagataymuhammet.guestlist.db.entity.Event
import com.cagataymuhammet.guestlist.db.entity.Guest

/**
 * Created by Muhammet ÇAĞATAY on 15,Şubat,2020
 */

@Database(entities = arrayOf(Guest::class, Event::class), version = 1, exportSchema = false)
//@TypeConverters(DataConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun eventDao(): EventDao
    abstract fun guestDao(): GuestDao
}