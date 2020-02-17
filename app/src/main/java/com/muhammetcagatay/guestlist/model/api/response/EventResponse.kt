package com.cagataymuhammet.guestlist.model
import com.google.gson.annotations.SerializedName

/**
 * Created by Muhammet ÇAĞATAY on 15,Şubat,2020
 */

data class EventResponse(
    @SerializedName("count")
    val count: Int,
    @SerializedName("next")
    val next: Any,
    @SerializedName("previous")
    val previous: Any,
    @SerializedName("results")
    val results: List<EventItem>
)

