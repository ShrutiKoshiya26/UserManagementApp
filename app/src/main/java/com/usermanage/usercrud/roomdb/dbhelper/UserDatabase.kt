package com.usermanage.usercrud.roomdb.dbhelper

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.usermanage.usercrud.data.model.User
import com.usermanage.usercrud.roomdb.dao.UserDao

@Database(entities = [User::class], version = 1, exportSchema = true)
abstract class UserDatabase : RoomDatabase() {

    abstract fun getUserDao(): UserDao

    companion object {
        @Volatile
        private var INSTANCE: UserDatabase? = null

        fun getDatabase(context: Context): UserDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE =
                    Room.databaseBuilder(context, UserDatabase::class.java, "UserDB").build()
                return INSTANCE!!
            }

        }

    }
}