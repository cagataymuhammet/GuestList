package com.cagataymuhammet.guestlist.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Muhammet ÇAĞATAY on 16,Şubat,2020
 */
data class EventItem(
    @SerializedName("created")
    val created: String,
    @SerializedName("group_id")
    val groupId: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("modified")
    val modified: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("starts")
    val starts: String,
    @SerializedName("ends")
    val ends: String,
    @SerializedName("timezone")
    val timezone: String,
    @SerializedName("venue")
    val venue: Any
)