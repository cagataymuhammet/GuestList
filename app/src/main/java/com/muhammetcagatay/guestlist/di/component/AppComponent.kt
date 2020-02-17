package com.cagataymuhammet.guestlist.di.component


/*
@Singleton
@Component(modules = [ContextModule::class,
    ApplicationModule::class,
    AndroidSupportInjectionModule::class,
    ActivityBindingModule::class])



interface ApplicationComponent : AndroidInjector<DaggerApplication?> {


    fun inject(application: BaseApplication?)
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application?): Builder?

        fun build(): ApplicationComponent?
    }
}
*/


import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.cagataymuhammet.guestlist.di.module.DatabaseModule
import com.cagataymuhammet.guestlist.di.module.NetworkModule
import com.cagataymuhammet.guestlist.di.module.ViewModelModule
import com.cagataymuhammet.guestlist.di.modules.ActivityBuilderModule
import com.cagataymuhammet.guestlist.di.modules.AppModule
import com.muhammetcagatay.guestlist.App
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class,
    ActivityBuilderModule::class,
    ViewModelModule::class,
    NetworkModule::class,
    DatabaseModule::class])

interface AppComponent : AndroidInjector<App> {

    @Component.Factory
    abstract class Factory : AndroidInjector.Factory<App>


}

/*
//TODO TÜM MODÜLLER EKLE
@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class,
    ActivityBuilderModule::class,
    ViewModelModule::class,
    NetworkModule::class,
    DatabaseModule::class])

interface AppComponent : AndroidInjector<App> {

    @Component.Factory
    abstract class Factory : AndroidInjector.Factory<App>
}



*/

