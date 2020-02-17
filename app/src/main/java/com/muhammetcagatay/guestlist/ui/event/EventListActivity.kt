package com.muhammetcagatay.guestlist.ui.event

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.cagataymuhammet.guestlist.db.entity.Event
import com.cagataymuhammet.guestlist.ui.base.BaseActivity
import com.cagataymuhammet.guestlist.ui.event.EventAdapter
import com.cagataymuhammet.guestlist.ui.event.EventViewModel
import com.muhammetcagatay.guestlist.R
import com.muhammetcagatay.guestlist.ui.guest.GuestListActivity
import com.muhammetcagatay.guestlist.databinding.ActivityEventListBinding
import com.muhammetcagatay.guestlist.util.Constants
import com.muhammetcagatay.guestlist.util.NetworkUtils
import dagger.android.DispatchingAndroidInjector
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class EventListActivity : BaseActivity<EventViewModel, ActivityEventListBinding>(EventViewModel::class.java),SwipeRefreshLayout.OnRefreshListener {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun initViewModel(viewModel: EventViewModel) {
        binding.viewModel = viewModel
    }

    override fun getLayoutRes(): Int = R.layout.activity_event_list

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }


    private val mSwipeRefreshLayout: SwipeRefreshLayout by lazy {
        findViewById(R.id.swipeRefresh) as SwipeRefreshLayout
    }

    fun init() {
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        bindLocaleEvents()
        getRemoteEventsAndSave()
        mSwipeRefreshLayout.setOnRefreshListener(this)
    }

    fun getRemoteEventsAndSave() {
        if (NetworkUtils.isConnectedToInternet(applicationContext)) {
            showLoading()
            serviceClient.getEvents()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { result ->
                        viewModel.addEventResponseToLocale(result.results)
                        hideLoading()
                        bindLocaleEvents()
                    },
                    {
                        hideLoading()
                    }
                )
        }
    }

    fun bindLocaleEvents() {
        if (viewModel.getLocaleEvents().size > 0) {
            bindToList(viewModel.getLocaleEvents())
        }
    }

    @SuppressLint("WrongConstant")
    fun bindToList(eventList: List<Event>) {
        val recyclerView = findViewById<RecyclerView>(R.id.rv_event_list)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
        val recyclerViewAdapter =
            EventAdapter(eventList, object : EventAdapter.OnItemClickListener {
                override fun onLongClick(eventItem: Event, position: Int): Boolean {
                    return true
                }

                override fun onClick(eventItem: Event) {
                    val intent = Intent(this@EventListActivity, GuestListActivity::class.java)
                    intent.putExtra(Constants.EXTRA_NAME_EVENT_ID, eventItem.event_id.toString())
                    startActivity(intent)
                }
            })
        recyclerView.adapter = recyclerViewAdapter
    }


    override fun onRefresh() {
        getRemoteEventsAndSave()
        mSwipeRefreshLayout.isRefreshing = false
    }


}