package com.muhammetcagatay.guestlist.di.component

/**
 * Created by Muhammet ÇAĞATAY on 17,Şubat,2020
 */
import android.app.Application
import com.cagataymuhammet.guestlist.di.component.AppComponent
import com.cagataymuhammet.guestlist.di.module.DatabaseModule
import com.cagataymuhammet.guestlist.di.module.NetworkModule
import com.cagataymuhammet.guestlist.di.module.ViewModelModule
import com.cagataymuhammet.guestlist.di.modules.ActivityBuilderModule
import com.cagataymuhammet.guestlist.di.modules.AppModule
import com.muhammetcagatay.guestlist.App
import com.muhammetcagatay.guestlist.di.module.TestAppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    TestAppModule::class,
    AndroidSupportInjectionModule::class,
    AppModule::class,
    ActivityBuilderModule::class,
    ViewModelModule::class,
    NetworkModule::class,
    DatabaseModule::class])
interface TestAppComponent : AppComponent {


    @Component.Factory
    abstract class Factory : AndroidInjector.Factory<App>


}

