package com.muhammetcagatay.guestlist.ui.guest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.muhammetcagatay.guestlist.R
import com.muhammetcagatay.guestlist.ui.base.BaseActivity

class GuestListActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guest_list)
    }
}
