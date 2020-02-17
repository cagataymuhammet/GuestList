package com.cagataymuhammet.guestlist.model
import com.google.gson.annotations.SerializedName

/**
 * Created by Muhammet ÇAĞATAY on 15,Şubat,2020
 */

data class GuestResponse(
    @SerializedName("count")
    val count: Int,
    @SerializedName("end_time")
    val endTime: String,
    @SerializedName("next")
    val next: String,
    @SerializedName("only_checkins")
    val onlyCheckins: Boolean,
    @SerializedName("page")
    val page: Int,
    @SerializedName("previous")
    val previous: Any,
    @SerializedName("results")
    val results: List<GuestItem>,
    @SerializedName("start_time")
    val startTime: String,
    @SerializedName("timestamp")
    val timestamp: Any
)
