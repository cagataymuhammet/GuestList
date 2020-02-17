package com.cagataymuhammet.guestlist.ui.base

import android.app.Application
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import java.util.logging.ErrorManager

/**
 * Created by Muhammet ÇAĞATAY on 15,Şubat,2020
 */


abstract class BaseViewModel() : ViewModel() {

    /**Inject Singlton ErrorManager
     * Use this errorManager to get the Errors
     */
    //abstract val errorManager: ErrorManager

}