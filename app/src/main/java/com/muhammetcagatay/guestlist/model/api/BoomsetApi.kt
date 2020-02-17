package com.cagataymuhammet.guestlist.network

import com.cagataymuhammet.guestlist.model.EventResponse
import com.cagataymuhammet.guestlist.model.GuestResponse
import com.muhammetcagatay.guestlist.util.Constants
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by Muhammet ÇAĞATAY on 15,Şubat,2020
 */


interface BoomsetApi {

    //https://api.boomset.com/events
    @Headers(
        "Accept: application/json",
        "Authorization: Token ebe8f608760d192750ec73eecd76e0d2"
    )
    @GET("events")
    fun getEvents(): Single<EventResponse>



    //https://api.boomset.com/events/71790/guests
    @Headers(
        "Accept: application/json",
        "Authorization: Token ebe8f608760d192750ec73eecd76e0d2"
    )
    @GET("events/{eventId}/guests")
    fun getGuests(@Path("eventId") eventId: Int?): Single<GuestResponse>

    companion object {

        fun create(): BoomsetApi {

            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.API_BASE_URL)
                .build()

            return retrofit.create(BoomsetApi::class.java)

        }
    }
}