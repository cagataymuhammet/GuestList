package com.muhammetcagatay.guestlist.util

/**
 * Created by Muhammet ÇAĞATAY on 17,Şubat,2020
 */
import com.cagataymuhammet.guestlist.model.EventItem
import com.cagataymuhammet.guestlist.model.EventResponse
import com.google.gson.Gson
import java.io.File
import java.util.*

class TestModelsGenerator {
    private var eventResponse: EventResponse

    init {
        val gson = Gson()
        val jsonString = getJson("EventResponse.json")
        eventResponse = gson.fromJson(jsonString, EventResponse::class.java)
    }

    fun generateEventResponse(): EventResponse {
        return eventResponse
    }

    fun generateEventResponseItem(): EventItem {
        return eventResponse.results[0]
    }



    /**
     * Helper function which will load JSON from
     * the path specified
     *
     * @param path : Path of JSON file
     * @return json : JSON from file at given path
     */

    private fun getJson(path: String): String {
        // Load the JSON response
        val uri = this.javaClass.classLoader?.getResource(path)
        val file = File(uri?.path)
        return String(file.readBytes())
    }
}