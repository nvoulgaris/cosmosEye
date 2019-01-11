package com.nvoulgaris.cosmoseye.base.data

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
abstract class ApodDao {

    @Insert
    abstract fun insert(apods: ApodDb)

    @Query("DELETE FROM ${DbConstants.APOD_TABLE_NAME}")
    abstract fun nuke()
}
