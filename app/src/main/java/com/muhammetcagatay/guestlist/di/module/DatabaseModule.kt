package com.cagataymuhammet.guestlist.di.module

import androidx.room.Room
import com.cagataymuhammet.guestlist.db.dao.EventDao
import com.cagataymuhammet.guestlist.db.dao.GuestDao
import com.muhammetcagatay.guestlist.App
import com.muhammetcagatay.guestlist.model.db.AppDatabase

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule{

    @Provides
    @Singleton
    fun provideAppDatabase(app: App): AppDatabase {
        return Room.databaseBuilder(app, AppDatabase::class.java, "boomset.db")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    @Provides
    @Singleton
    fun provideEventDao(appDatabase: AppDatabase): EventDao = appDatabase.eventDao()

    @Provides
    @Singleton
    fun provideGuestDao(appDatabase: AppDatabase): GuestDao = appDatabase.guestDao()
}