package com.example.davidmartins.codewar.data.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

@Database(entities = arrayOf(User))
abstract class CodeWarDatabase : RoomDatabase() {

    abstract fun userDao() : UserDao
}