package com.cagataymuhammet.guestlist.di.modules

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import androidx.lifecycle.ViewModelProvider
import com.muhammetcagatay.guestlist.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideContext(app: App): Context = app.applicationContext

    @Provides
    @Singleton
    fun provideSharedPreferences(app: App): SharedPreferences = PreferenceManager.getDefaultSharedPreferences(app)

}

