package com.muhammetcagatay.guestlist.ui.event

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.muhammetcagatay.guestlist.R
import com.muhammetcagatay.guestlist.ui.base.BaseActivity

class EventListActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_list)
    }
}
