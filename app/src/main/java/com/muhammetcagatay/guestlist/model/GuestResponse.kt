package com.cagatay.boomsetapp.model
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
    val results: List<Guests>,
    @SerializedName("start_time")
    val startTime: String,
    @SerializedName("timestamp")
    val timestamp: Any
)

data class Guests(
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
    @SerializedName("custom_questions")
    val customQuestions: List<CustomQuestion>,
    @SerializedName("email")
    val email: String,
    @SerializedName("event")
    val event: Int,
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("job_title")
    val jobTitle: Any,
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

data class CustomQuestion(
    @SerializedName("answer")
    val answer: List<Answer>,
    @SerializedName("objstatus")
    val objstatus: String,
    @SerializedName("question_text")
    val questionText: String,
    @SerializedName("question_id")
    val questionİd: Int
)

data class Answer(
    @SerializedName("answer")
    val answer: String,
    @SerializedName("id")
    val id: Any
)