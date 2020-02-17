package com.cagataymuhammet.guestlist.di.module.event

import com.cagataymuhammet.guestlist.di.scope.ActivityScope
import com.cagataymuhammet.guestlist.model.EventResponse
import com.cagataymuhammet.guestlist.network.BoomsetApi
import com.cagataymuhammet.guestlist.ui.event.EventAdapter
import com.muhammetcagatay.guestlist.ui.event.EventListActivity
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

/**
 * Created by Muhammet ÇAĞATAY on 16,Şubat,2020
 */

@Module
class EventActivityModule {

    @ActivityScope
    @Provides
    fun provideBoomsetApi(retrofit: Retrofit): BoomsetApi = retrofit.create(BoomsetApi::class.java)

    @Provides
    fun provideActivityName(mainActivity: EventListActivity): String {
        return mainActivity.javaClass.name
    }
}