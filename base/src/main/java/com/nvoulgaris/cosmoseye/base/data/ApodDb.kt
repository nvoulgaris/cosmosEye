package com.nvoulgaris.cosmoseye.base.data

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = DbConstants.APOD_TABLE_NAME)
data class ApodDb(
    val copyright: String,
    @PrimaryKey val date: String,
    val explanation: String,
    val hdUrl: String,
    val mediaType: String,
    val serviceVersion: String,
    val title: String,
    val url: String
)
