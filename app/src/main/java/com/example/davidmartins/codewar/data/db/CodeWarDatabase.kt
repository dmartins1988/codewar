package com.example.davidmartins.codewar.data.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.davidmartins.codewar.data.models.User

@Database(entities = [UserData::class], version = 1)
abstract class CodeWarDatabase : RoomDatabase() {

    abstract fun userDao() : UserDao
}