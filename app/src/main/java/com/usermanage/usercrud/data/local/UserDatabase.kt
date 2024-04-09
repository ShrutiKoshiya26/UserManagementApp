package com.usermanage.usercrud.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.usermanage.usercrud.data.model.User

@Database(entities = [User::class], version = 1, exportSchema = true)
abstract class UserDatabase : RoomDatabase() {
    abstract fun getUserDao(): UserDao

}