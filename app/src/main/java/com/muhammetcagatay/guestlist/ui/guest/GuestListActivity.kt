package com.muhammetcagatay.guestlist.ui.guest

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cagataymuhammet.guestlist.db.entity.Guest
import com.cagataymuhammet.guestlist.model.GuestItem
import com.cagataymuhammet.guestlist.ui.base.BaseActivity
import com.cagataymuhammet.guestlist.ui.guest.GuestAdapter
import com.cagataymuhammet.guestlist.ui.guest.GuestViewModel
import com.muhammetcagatay.guestlist.R
import com.muhammetcagatay.guestlist.databinding.ActivityGuestListBinding
import com.muhammetcagatay.guestlist.util.NetworkUtils
import dagger.android.DispatchingAndroidInjector
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class GuestListActivity : BaseActivity<GuestViewModel, ActivityGuestListBinding>(GuestViewModel::class.java) {

    override fun initViewModel(viewModel: GuestViewModel) {
        binding.viewModel = viewModel
    }

    override fun getLayoutRes(): Int = R.layout.activity_guest_list

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setSupportActionBar(binding.toolbar)
        //  supportActionBar?.setDisplayHomeAsUpEnabled(false)

        // setTransparentStatusBar()

        getRemoteGuestAndSave()
        bindLocaleGuest()
    }


    fun getRemoteGuestAndSave() {
        if (NetworkUtils.isConnectedToInternet(applicationContext)) {
            showLoading()

            serviceClient.getGuests(71787)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { result ->
                        viewModel.addGuestResponseToLocale(result.results)
                        hideLoading()
                        bindLocaleGuest()
                    },
                    {

                        hideLoading()
                    }
                )
        }

    }

    fun bindLocaleGuest() {
        if (viewModel.getLocaleGuests().size > 0) {
            bindToList(viewModel.getLocaleGuests())
        }
    }

    @SuppressLint("WrongConstant")
    fun bindToList(guestList: List<Guest>) {
        val recyclerView = findViewById<RecyclerView>(R.id.rv_guest_list)
        recyclerView.layoutManager =
            LinearLayoutManager(this@GuestListActivity, LinearLayout.VERTICAL, false)

        val recyclerViewAdapter =
            GuestAdapter(guestList, object : GuestAdapter.OnItemClickListener {

                override fun onLongClick(guestItem: Guest, position: Int): Boolean {
                    return true
                }

                override fun onClick(guestItem: Guest) {

                }
            })

        recyclerView.adapter = recyclerViewAdapter
    }
}

