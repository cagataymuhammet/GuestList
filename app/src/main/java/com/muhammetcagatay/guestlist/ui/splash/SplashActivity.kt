package com.muhammetcagatay.guestlist.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.muhammetcagatay.guestlist.R
import com.muhammetcagatay.guestlist.ui.event.EventListActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        object : CountDownTimer(1000, 1000) {
            override fun onTick(millisUntilFinished: Long) {}
            override fun onFinish() { startEventListActiviy() }
        }.start()
    }


    fun startEventListActiviy() {
        val intent = Intent(this, EventListActivity::class.java)
        startActivity(intent)
        finish()
    }
}
