package com.muhammetcagatay.guestlist.ui.guest

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.SearchView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.cagataymuhammet.guestlist.db.entity.Guest
import com.cagataymuhammet.guestlist.model.GuestItem
import com.cagataymuhammet.guestlist.ui.base.BaseActivity
import com.cagataymuhammet.guestlist.ui.guest.GuestAdapter
import com.cagataymuhammet.guestlist.ui.guest.GuestViewModel
import com.muhammetcagatay.guestlist.R
import com.muhammetcagatay.guestlist.databinding.ActivityGuestListBinding
import com.muhammetcagatay.guestlist.util.Constants
import com.muhammetcagatay.guestlist.util.NetworkUtils
import dagger.android.DispatchingAndroidInjector
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class GuestListActivity : BaseActivity<GuestViewModel, ActivityGuestListBinding>(GuestViewModel::class.java),SwipeRefreshLayout.OnRefreshListener {

    private val mSwipeRefreshLayout: SwipeRefreshLayout by lazy {
        findViewById(R.id.swipeRefresh) as SwipeRefreshLayout
    }

    override fun initViewModel(viewModel: GuestViewModel) {
        binding.viewModel = viewModel
    }

    override fun getLayoutRes(): Int = R.layout.activity_guest_list

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    fun init()
    {
        val actionbar = supportActionBar
        actionbar!!.setDisplayHomeAsUpEnabled(true)

        val moveStr:String =intent.getStringExtra(Constants.EXTRA_NAME_EVENT_ID)
        eventId=Integer.parseInt(moveStr)

        bindLocaleGuest()
        getRemoteGuestAndSave()
        mSwipeRefreshLayout.setOnRefreshListener(this)
        initSearchView()
    }


    fun initSearchView()
    {
        val edtSearch :EditText=findViewById(R.id.srcGuests)
        edtSearch.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {

            }
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                searhQuery=p0.toString()
                searcTimer.cancel();
                searcTimer.start();
            }
        })
    }


    var guestListFiltered: List<Guest>?=null
    fun doSearch()
    {
        if (viewModel.getLocaleGuests(eventId).size>0) {
            guestListFiltered  = viewModel.getLocaleGuests(eventId).filter { guestList -> guestList.first_name!!.contains(searhQuery) }

            if (guestListFiltered!!.size>0) {
                bindToList(guestListFiltered!!)
            }
        }
    }

    var searhQuery: String = ""
    val searcTimer = object:CountDownTimer(1000, 1000) {
        override fun onTick(millisUntilFinished: Long) {

        }
        override fun onFinish() {
            doSearch()
        }
    }


    fun getRemoteGuestAndSave() {

        if (NetworkUtils.isConnectedToInternet(applicationContext)) {
            showLoading()
            serviceClient.getGuests(eventId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    {  result ->
                        viewModel.addGuestResponseToLocale(eventId,result.results)

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

    fun bindLocaleGuest() {
        if (viewModel.getLocaleGuests(eventId).size > 0) {
            bindToList(viewModel.getLocaleGuests(eventId))
        }
    }

    @SuppressLint("WrongConstant")
    fun bindToList(guestList: List<Guest>) {
        val recyclerView = findViewById<RecyclerView>(R.id.rv_guest_list)
        recyclerView.layoutManager = LinearLayoutManager(this@GuestListActivity, LinearLayout.VERTICAL, false)

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


    override fun onRefresh() {
        getRemoteGuestAndSave()
        mSwipeRefreshLayout.isRefreshing = false
    }

}

