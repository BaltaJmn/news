package com.baltajmn.template.database.datasource

import androidx.room.Dao
import androidx.room.Database
import androidx.room.RoomDatabase
import com.baltajmn.template.database.model.DatabaseModel

@Database(
    entities = [DatabaseModel::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun dao(): com.baltajmn.template.database.datasource.Dao
}

@Dao
interface Dao {}
