package com.example.coinstats.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.coinstats.data.database.model.FavouriteCoinsDbModel
import com.example.coinstats.data.database.model.TopCoinsInfoDbModel

@Database(
    entities = [TopCoinsInfoDbModel::class, FavouriteCoinsDbModel::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase: RoomDatabase() {

}