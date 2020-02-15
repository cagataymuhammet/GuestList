package com.muhammetcagatay.guestlist.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.cagatay.boomsetapp.db.dao.EventDao
import com.cagatay.boomsetapp.db.dao.GuestDao
import com.cagatay.boomsetapp.db.entity.Event
import com.cagatay.boomsetapp.db.entity.Guest

/**
 * Created by Muhammet ÇAĞATAY on 15,Şubat,2020
 */

@Database(entities = arrayOf(Guest::class, Event::class), version = 1, exportSchema = false)
//@TypeConverters(DataConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract val eventDao: EventDao
    abstract val guestDao: GuestDao
}