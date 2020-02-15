package com.cagatay.boomsetapp.network

import com.cagatay.boomsetapp.model.EventResponse
import com.cagatay.boomsetapp.model.GuestResponse
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by Muhammet ÇAĞATAY on 15,Şubat,2020
 */


interface BoomsetApi {

    //https://api.boomset.com/events
    @GET("events")
    fun getEvents(): Observable<EventResponse?>


    //https://api.boomset.com/events/71790/guests
    @GET("events/{eventId}/guests")
    fun getGuests(@Path("eventId") eventId: Int?): Observable<GuestResponse>

}