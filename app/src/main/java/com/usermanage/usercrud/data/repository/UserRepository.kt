package com.usermanage.usercrud.data.repository

import androidx.lifecycle.LiveData
import com.usermanage.usercrud.data.local.UserDao
import com.usermanage.usercrud.data.model.User
import javax.inject.Inject


class UserRepository @Inject constructor(
    private val userDao: UserDao
) {

    fun getAllUsers(): LiveData<List<User>> = userDao.getAllUsers()


    fun searchUsersByName(name: String): LiveData<List<User>> {
        return userDao.searchUserByName("%$name%")
    }

    suspend fun insertUser(user: User) {
        userDao.insertUser(user)
    }

    suspend fun updateUser(user: User) {
        userDao.updateUser(user)
    }

    suspend fun deleteUser(user: User) {
        userDao.deleteUser(user)
    }

    suspend fun deleteAll() {
        userDao.deleteAll()
    }

}