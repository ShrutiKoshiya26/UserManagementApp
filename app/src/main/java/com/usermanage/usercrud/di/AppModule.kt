package com.usermanage.usercrud.di

import android.content.Context
import androidx.room.Room
import com.usermanage.usercrud.application.App
import com.usermanage.usercrud.data.local.UserDao
import com.usermanage.usercrud.data.local.UserDatabase
import com.usermanage.usercrud.data.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Provides
    @Singleton
    fun provideApplication(): App = App()

    @Provides
    fun providesUserDao(userDatabase: UserDatabase): UserDao = userDatabase.getUserDao()

    @Provides
    fun providesUserRepository(userDao: UserDao): UserRepository = UserRepository(userDao)

    @Provides
    @Singleton
    fun provideRoomDb(@ApplicationContext context: Context): UserDatabase =
        Room.databaseBuilder(context, UserDatabase::class.java, "UserDB").build()
}
