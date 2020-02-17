package com.cagataymuhammet.guestlist.di.modules

import com.cagataymuhammet.guestlist.di.module.event.EventActivityModule
import com.cagataymuhammet.guestlist.di.module.event.GuestActivityModule
import com.cagataymuhammet.guestlist.di.scope.ActivityScope
import com.muhammetcagatay.guestlist.ui.event.EventListActivity
import com.muhammetcagatay.guestlist.ui.guest.GuestListActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBuilderModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [EventActivityModule::class])
    abstract  fun bindEventListActivity(): EventListActivity


    @ActivityScope
    @ContributesAndroidInjector(modules = [GuestActivityModule::class])
    abstract  fun bindGuestListActivity():GuestListActivity

    /*
    @PerActivity
    @ContributesAndroidInjector
    internal  abstract fun contributeSplashActivity(): SplashActivity

     */
}