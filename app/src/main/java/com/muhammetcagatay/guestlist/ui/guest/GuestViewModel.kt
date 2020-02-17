package com.cagataymuhammet.guestlist.ui.guest

/**
 * Created by Muhammet ÇAĞATAY on 16,Şubat,2020
 */

import android.app.DownloadManager
import android.util.Log
import com.cagataymuhammet.guestlist.db.entity.Guest
import com.cagataymuhammet.guestlist.model.GuestItem
import com.cagataymuhammet.guestlist.ui.base.BaseViewModel
import com.muhammetcagatay.guestlist.App
import com.muhammetcagatay.guestlist.model.db.AppDatabase
import javax.inject.Inject

class GuestViewModel @Inject internal constructor(val app: App, val db: AppDatabase) : BaseViewModel() {

    fun addGuestResponseToLocale(eventId:Int,  guestResult: List<GuestItem>) {

        if(guestResult.size>0)
        {
            db.guestDao().deleteAllByEventId(eventId)
            guestResult.forEach { guestItem ->
                val guest = Guest(guestItem.firstName, guestItem.lastName, guestItem.company, guestItem.event,guestItem.jobTitle)
                db.guestDao().insert(guest)
            }
        }
    }

    private var guestLocaleData: MutableList<Guest>? = null

    fun getLocaleGuests(eventId:Int): List<Guest> {
        if (guestLocaleData == null) {
            guestLocaleData = mutableListOf<Guest>()
            loadLocaleGuest(eventId)
        }
        return guestLocaleData!!;
    }

    fun loadLocaleGuest(eventId:Int) {

        guestLocaleData = db.guestDao().getAllGuestsByEventID(eventId)
    }

}

