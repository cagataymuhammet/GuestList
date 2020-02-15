package com.cagatay.boomsetapp.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Muhammet ÇAĞATAY on 15,Şubat,2020
 */

/*

For attendees, show prefix, first_name, last_name under contact and title, company under work_info parameters.

             "prefix": null,
            "first_name": "Smith",
            "last_name": "Abe",
            "id": 32363960,
            "company": "Boomset",
            "job_title": null
 */


@Entity(tableName = "guests")
data class Guest(@ColumnInfo(name = "id") var id: Int?,
                 @ColumnInfo(name = "prefix") var prefix: String?,
                 @ColumnInfo(name = "first_name") var first_name: String?,
                 @ColumnInfo(name = "last_name") var last_name: String?,
                 @ColumnInfo(name = "company") var company: String?,
                 @ColumnInfo(name = "job_title") var job_title: String?) {

    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0
}
