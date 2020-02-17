package com.muhammetcagatay.guestlist.di.module

import android.content.Context
import com.muhammetcagatay.guestlist.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Muhammet ÇAĞATAY on 17,Şubat,2020
 */
class TestAppModule {
}


@Module
class AppModule {

    @Provides
    @Singleton
    fun provideContext(app: App): Context = app.applicationContext

}