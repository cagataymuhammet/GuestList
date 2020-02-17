package com.cagataymuhammet.guestlist.ui.event

import com.cagataymuhammet.guestlist.db.entity.Event

/**
 * Created by Muhammet ÇAĞATAY on 16,Şubat,2020
 */

import com.cagataymuhammet.guestlist.model.EventItem
import com.cagataymuhammet.guestlist.ui.base.BaseViewModel
import com.muhammetcagatay.guestlist.App
import com.muhammetcagatay.guestlist.model.db.AppDatabase
import javax.inject.Inject

class EventViewModel @Inject internal constructor(val app: App, val db: AppDatabase) : BaseViewModel() {

    init {
        loadLocaleEvents()
    }

    fun addEventResponseToLocale(eventRemoteResult: List<EventItem>) {

        if( eventRemoteResult.size>0) {
            db.eventDao().deleteAll()
            eventRemoteResult.forEach { eventItem ->
                val eventEntity = Event(eventItem.id, eventItem.name, eventItem.timezone, eventItem.starts,eventItem.ends)
                db.eventDao().insert(eventEntity)
            }
        }
    }


    private var eventsLocaleData: MutableList<Event>? = null

    fun getLocaleEvents(): List<Event> {
        if (eventsLocaleData == null) {
            eventsLocaleData = mutableListOf<Event>()
            loadLocaleEvents()
        }
        return eventsLocaleData!!;
    }

    fun loadLocaleEvents() {
        eventsLocaleData = db.eventDao().getAllEvents()
    }
}



