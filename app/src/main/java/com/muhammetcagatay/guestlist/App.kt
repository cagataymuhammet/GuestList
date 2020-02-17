package com.muhammetcagatay.guestlist

import android.app.Activity
import android.app.Application
import com.cagataymuhammet.guestlist.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.DispatchingAndroidInjector
import javax.inject.Inject

/**
 * Created by Muhammet ÇAĞATAY on 15,Şubat,2020
 */

class App : DaggerApplication() {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    fun activityInjector() = dispatchingAndroidInjector

    override fun onCreate() {
        super.onCreate()
    }


    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.factory().create(this)
    }

}