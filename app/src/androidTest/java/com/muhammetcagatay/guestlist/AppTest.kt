package com.muhammetcagatay.guestlist

import com.cagataymuhammet.guestlist.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

/**
 * Created by Muhammet ÇAĞATAY on 17,Şubat,2020
 */

class AppTest: App() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.factory().create(this)
    }
}