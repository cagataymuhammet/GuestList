package com.cagatay.boomsetapp.db.entity


import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Muhammet ÇAĞATAY on 15,Şubat,2020
 */

/*
 {
        "id": 71790,
        "name": "Demo Event 3 (More Guests)",
        "group_id": 59578,
        "timezone": "US/Eastern",
        "starts": "2018-05-01T14:28:00",
        "ends": "2018-05-05T14:28:00",
    },
 */



@Entity(tableName = "events")
data class Event(@ColumnInfo(name = "id") var id: Int?,
                 @ColumnInfo(name = "name") var name: String?,
                 @ColumnInfo(name = "group_id") var group_id: Int?,
                 @ColumnInfo(name = "timezone") var timezone: String?,
                 @ColumnInfo(name = "starts") var starts: String?,
                 @ColumnInfo(name = "ends") var ends: Float?,
                 @ColumnInfo(name = "is_beacon_live") var is_beacon_live: Boolean?) {

    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0
}
