package com.cagataymuhammet.guestlist.ui.guest

/**
 * Created by Muhammet ÇAĞATAY on 16,Şubat,2020
 */

import com.cagataymuhammet.guestlist.db.entity.Event
import com.cagataymuhammet.guestlist.db.entity.Guest
import com.cagataymuhammet.guestlist.model.EventItem
import com.cagataymuhammet.guestlist.model.GuestItem
import com.cagataymuhammet.guestlist.ui.base.BaseViewModel
import com.muhammetcagatay.guestlist.App
import com.muhammetcagatay.guestlist.db.AppDatabase
import javax.inject.Inject

class GuestViewModel @Inject internal constructor(val app: App, val db: AppDatabase) : BaseViewModel() {

    init {
        loadLocaleGuest()
    }

    fun addGuestResponseToLocale(eventRemoteResult: List<GuestItem>) {

        if( eventRemoteResult.size>0) {
            db.guestDao().deleteAll()
            eventRemoteResult.forEach { guestItem ->
                val guest = Guest(guestItem.firstName, guestItem.lastName, guestItem.company, guestItem.id,guestItem.jobTitle)
                db.guestDao().insert(guest)
            }
        }
    }


    private var guestLocaleData: MutableList<Guest>? = null

    fun getLocaleGuests(): List<Guest> {
        if (guestLocaleData == null) {
            guestLocaleData = mutableListOf<Guest>()
            loadLocaleGuest()
        }
        return guestLocaleData!!;
    }

    fun loadLocaleGuest() {
        guestLocaleData = db.guestDao().getAllGuests()
    }
}

