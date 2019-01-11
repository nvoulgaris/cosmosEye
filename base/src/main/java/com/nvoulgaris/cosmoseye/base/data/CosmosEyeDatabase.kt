package com.nvoulgaris.cosmoseye.base.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = [ApodDb::class], version = 1)
abstract class CosmosEyeDatabase : RoomDatabase() {

    abstract fun apodDao(): ApodDao

    companion object {

        @Volatile
        private var instance: CosmosEyeDatabase? = null

        fun getInstance(context: Context): CosmosEyeDatabase = instance ?: synchronized(this) {
            createDatabase(context)
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext, CosmosEyeDatabase::class.java, DbConstants.DB_NAME)
                .build()
    }
}
