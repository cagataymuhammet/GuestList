package com.cagataymuhammet.guestlist.di.module
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cagataymuhammet.guestlist.di.key.ViewModelKey
import com.cagataymuhammet.guestlist.ui.event.EventViewModel
import com.muhammetcagatay.guestlist.util.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


/**
 * Created by Muhammet ÇAĞATAY on 16,Şubat,2020
 */

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(EventViewModel::class)
    internal abstract fun bindEventViewModel(viewModel: EventViewModel): ViewModel


}