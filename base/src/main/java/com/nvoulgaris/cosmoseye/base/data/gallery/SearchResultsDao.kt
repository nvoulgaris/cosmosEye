package com.nvoulgaris.cosmoseye.base.data.gallery

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.nvoulgaris.cosmoseye.base.data.DbConstants
import io.reactivex.Flowable

@Dao
abstract class SearchResultsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(searchResults: List<SearchResultDb>)

    @Query("SELECT * FROM ${DbConstants.SEARCH_RESULTS_TABLE_NAME}")
    abstract fun dataStream(): Flowable<List<SearchResultDb>>

    @Query("DELETE FROM ${DbConstants.SEARCH_RESULTS_TABLE_NAME}")
    abstract fun nuke()
}
