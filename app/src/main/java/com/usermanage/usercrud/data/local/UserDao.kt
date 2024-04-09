package com.usermanage.usercrud.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.usermanage.usercrud.data.model.User

@Dao
interface UserDao {

    //if some data is same/conflict, it'll be replace with new data.
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)

    @Update
    suspend fun updateUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)

    @Query("DELETE FROM userTB")
    suspend fun deleteAll()

    @Query("SELECT * FROM userTB")
    fun getAllUsers(): LiveData<List<User>>

    @Query("SELECT * FROM userTB WHERE name LIKE :name")
    fun searchUserByName(name: String): LiveData<List<User>>


}