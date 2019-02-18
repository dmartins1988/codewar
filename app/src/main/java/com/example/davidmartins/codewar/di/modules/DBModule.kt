package com.example.davidmartins.codewar.di.modules

import android.arch.persistence.room.Room
import android.content.Context
import com.example.davidmartins.codewar.data.db.CodeWarDatabase
import com.example.davidmartins.codewar.data.db.UserDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DBModule {

    @Singleton
    @Provides
    fun provideUserDatabase(context: Context) = Room
            .databaseBuilder(context, CodeWarDatabase::class.java, "user.db")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()


    @Singleton
    @Provides
    fun provideUserDao(codeWarDatabase: CodeWarDatabase) : UserDao = codeWarDatabase.userDao()

}