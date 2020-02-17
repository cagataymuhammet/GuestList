package com.cagataymuhammet.guestlist.di.modules

import com.cagataymuhammet.guestlist.di.module.event.EventActivityModule
import com.cagataymuhammet.guestlist.di.scope.ActivityScope
import com.muhammetcagatay.guestlist.ui.event.EventListActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBuilderModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [EventActivityModule::class])
    abstract  fun bindEventListActivity(): EventListActivity

    /*
    @PerActivity
    @ContributesAndroidInjector
    internal abstract fun contributeGuestListActivity(): GuestListActivity

    @PerActivity
    @ContributesAndroidInjector
    internal  abstract fun contributeSplashActivity(): SplashActivity

     */
}