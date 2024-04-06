package com.usermanage.usercrud.data.repository

import androidx.lifecycle.LiveData
import com.usermanage.usercrud.data.model.User
import com.usermanage.usercrud.roomdb.dao.UserDao


class UserRepository(
    private val userDao: UserDao
) {

    suspend fun insertUser(user: User) {
        userDao.insertUser(user)
    }

    fun getAllUsers(): LiveData<List<User>> = userDao.getAllUsers()

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