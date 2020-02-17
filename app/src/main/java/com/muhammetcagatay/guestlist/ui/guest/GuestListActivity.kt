package com.muhammetcagatay.guestlist.ui.guest

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
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

    var eventId:Int = -1

    override fun getLayoutRes(): Int = R.layout.activity_guest_list

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //actionbar
        val actionbar = supportActionBar
        //set actionbar title
        actionbar!!.title = "New Activity"
        //set back button
        actionbar.setDisplayHomeAsUpEnabled(true)

        val moveStr:String =intent.getStringExtra("extra_event_id")
        eventId=Integer.parseInt(moveStr)


        // setSupportActionBar(binding.toolbar)
        //  supportActionBar?.setDisplayHomeAsUpEnabled(false)

        // setTransparentStatusBar()

        getRemoteGuestAndSave()
        bindLocaleGuest()
    }


    fun getRemoteGuestAndSave() {

        if (NetworkUtils.isConnectedToInternet(applicationContext)) {
            showLoading()

            serviceClient.getGuests(eventId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {  result ->
                        viewModel.addGuestResponseToLocale(result.results)

                        hideLoading()
                        bindLocaleGuest()
                    },
                    {
                         error -> Log.e("CAGATAYSE", error.message)
                        hideLoading()
                    }
                )
        }

    }

    fun bindLocaleGuest()
    {
        if (viewModel.getLocaleGuests(eventId).size > 0) {
            bindToList(viewModel.getLocaleGuests(eventId))
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

