package com.cagatay.boomsetapp.network

import com.cagatay.boomsetapp.model.EventResponse
import com.cagatay.boomsetapp.model.GuestResponse
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by Muhammet ÇAĞATAY on 15,Şubat,2020
 */

class BoomsetService {

    private var boomsetApi: BoomsetApi? = null

    @Inject
    fun BoomsetService(boomsetApi: BoomsetApi?) {
        this.boomsetApi = boomsetApi
    }

    fun getEvents(): Observable<EventResponse?>? {
        return boomsetApi!!.getEvents()
    }

    fun getGuest(eventId: Int?): Observable<GuestResponse> {
        return boomsetApi!!.getGuests(eventId)
    }
}