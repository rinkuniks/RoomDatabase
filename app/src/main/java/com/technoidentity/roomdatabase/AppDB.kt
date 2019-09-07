package com.technoidentity.roomdatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.technoidentity.roomdatabase.customers.CustomerModel

@Database (entities = [(CustomerModel::class)],version = 1)
abstract class AppDB : RoomDatabase() {
    abstract fun empDAO(): EmpDAO

    companion object {
        private var INSTANCE: AppDB? = null

        internal fun getDatabase(context: Context): AppDB? {
            if (INSTANCE == null) {
                synchronized(AppDB::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            AppDB::class.java, "app_database"
                        ).build()
                    }
                }
            }
            return INSTANCE
        }
    }
}
