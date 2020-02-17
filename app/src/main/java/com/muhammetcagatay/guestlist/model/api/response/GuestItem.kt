package com.cagataymuhammet.guestlist.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Muhammet ÇAĞATAY on 17,Şubat,2020
 */
data class GuestItem(
    @SerializedName("barcode")
    val barcode: String,
    @SerializedName("blog")
    val blog: Any,
    @SerializedName("cell_phone")
    val cellPhone: Any,
    @SerializedName("company")
    val company: String,
    @SerializedName("created")
    val created: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("event")
    val event: Int,
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("job_title")
    val jobTitle: String,
    @SerializedName("last_name")
    val lastName: String,
    @SerializedName("modified")
    val modified: String,
    @SerializedName("nfc_tag")
    val nfcTag: Any,
    @SerializedName("objstatus")
    val objstatus: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("prefix")
    val prefix: Any,
    @SerializedName("registration_type")
    val registrationType: Int,
    @SerializedName("selfie")
    val selfie: String,
    @SerializedName("source")
    val source: String,
    @SerializedName("suffix")
    val suffix: Any,
    @SerializedName("website")
    val website: Any,
    @SerializedName("work_phone")
    val workPhone: Any
)
