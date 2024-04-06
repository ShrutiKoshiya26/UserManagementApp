package com.usermanage.usercrud.utils

import android.content.Context
import com.usermanage.usercrud.data.repository.UserRepository
import com.usermanage.usercrud.roomdb.dbhelper.UserDatabase
import com.usermanage.usercrud.ui.viewmodelfactory.ViewModelFactory

object Injector {

    private var repository: UserRepository? = null
    private var factory: ViewModelFactory? = null
    private fun getUserRepository(context: Context): UserRepository {
        synchronized(this) {
            if (repository == null) {
                repository =
                    UserRepository(UserDatabase.getDatabase(context = context).getUserDao())
            }
            return repository!!
        }
    }

    fun getViewModelFactory(context: Context): ViewModelFactory {
        synchronized(this) {
            if (factory == null) {
                factory = ViewModelFactory(getUserRepository(context))
            }
            return factory!!
        }
    }


}