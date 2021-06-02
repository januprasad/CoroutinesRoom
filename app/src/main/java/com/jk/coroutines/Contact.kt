package com.jk.coroutines

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contact_table")
data class Contact(@ColumnInfo(name = "name") val name:String,
                   @ColumnInfo(name = "number") val number:String,
                   @ColumnInfo(name = "pic") val pic:String) {
    @PrimaryKey(autoGenerate = true) var id: Int = 0
}

