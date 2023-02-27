package com.example.coinstats.data.database

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.coinstats.data.database.model.FavouriteCoinDbModel
import com.example.coinstats.data.database.model.CoinDbModel

@Database(
    entities = [CoinDbModel::class, FavouriteCoinDbModel::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        private var INSTANCE: AppDatabase? = null
        private val LOCK = Any()
        private const val DB_NAME = "coin_stats.db"

        fun getInstance(application: Application): AppDatabase {
            synchronized(LOCK) {
                INSTANCE?.let {
                    return it
                }
            }
            synchronized(LOCK) {
                INSTANCE?.let {
                    return it
                }
                val db = Room.databaseBuilder(
                    application,
                    AppDatabase::class.java,
                    DB_NAME
                ).fallbackToDestructiveMigration().build()
                INSTANCE = db
                return db
            }
        }
    }

    abstract fun getTopCoinsDao(): TopCoinsDao
}