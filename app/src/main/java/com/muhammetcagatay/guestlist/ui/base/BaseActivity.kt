package com.cagataymuhammet.guestlist.ui.base

import android.app.ProgressDialog
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.cagataymuhammet.guestlist.network.BoomsetApi
import com.muhammetcagatay.guestlist.util.Utils
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

/**
 * Created by Muhammet ÇAĞATAY on 16,Şubat,2020
 */
abstract class BaseActivity<VM : BaseViewModel, VDB : ViewDataBinding>(private val mViewModelClass: Class<VM>): DaggerAppCompatActivity(){

    val serviceClient by lazy {
        BoomsetApi.create()
    }

    @Inject
    internal lateinit var viewModelFactory: ViewModelProvider.Factory

    @LayoutRes
    abstract fun getLayoutRes(): Int

    val binding by lazy {
        DataBindingUtil.setContentView(this, getLayoutRes()) as VDB
    }


    val viewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(mViewModelClass)
    }

    /**
     * If you want to inject Dependency Injection
     * on your activity, you can override this.
     */
    open fun onInject() {}

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        initViewModel(viewModel)
        onInject()
        setupBindingLifecycleOwner()
    }

    /**
     *
     *  You need override this method.
     *  And you need to set viewModel to binding: binding.viewModel = viewModel
     *
     */

    abstract fun initViewModel(viewModel: VM)

    private fun setupBindingLifecycleOwner() {
        binding.lifecycleOwner = this
    }

    var progressDialog: ProgressDialog? = null

    fun showMessage(message: String) {
        Toast.makeText(this@BaseActivity, message, Toast.LENGTH_LONG).show()
    }

    fun showLoading() {
        progressDialog = Utils.showLoadingDialog(this@BaseActivity)
    }


    fun hideLoading() {
        if (progressDialog != null) {
            if (progressDialog!!.isShowing) {
                progressDialog!!.dismiss()

            }
        }
    }

}