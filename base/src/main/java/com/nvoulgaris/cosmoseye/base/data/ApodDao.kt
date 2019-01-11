package com.nvoulgaris.cosmoseye.base.data

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import io.reactivex.Flowable

@Dao
abstract class ApodDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(apods: List<ApodDb>)

    @Query("SELECT * FROM ${DbConstants.APOD_TABLE_NAME}")
    abstract fun dataStream(): Flowable<List<ApodDb>>

    @Query("DELETE FROM ${DbConstants.APOD_TABLE_NAME}")
    abstract fun nuke()
}
