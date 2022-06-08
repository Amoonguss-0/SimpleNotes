package com.example.simplnotes.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "Notes")
data class Notes (

    @PrimaryKey(autoGenerate = true)
    var id:Int,

    @ColumnInfo(name = "title")
    var title:String,

    @ColumnInfo(name = "description")
    var description:String
    ):Serializable {override fun toString():String{
        return "$title"
    }
}
