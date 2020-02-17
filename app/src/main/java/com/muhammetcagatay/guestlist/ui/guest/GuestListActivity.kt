package com.muhammetcagatay.guestlist.ui.guest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil.setContentView
import com.cagataymuhammet.guestlist.ui.base.BaseActivity
import com.muhammetcagatay.guestlist.R

class GuestListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guest_list)
    }
}
