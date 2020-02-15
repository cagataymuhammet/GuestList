package com.cagatay.boomsetapp.model
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
    val results: List<Events>
)

data class Events(
    @SerializedName("created")
    val created: String,
    @SerializedName("group_id")
    val groupİd: Int,
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