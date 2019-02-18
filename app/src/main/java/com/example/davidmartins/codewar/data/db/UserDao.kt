package com.example.davidmartins.codewar.data.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import io.reactivex.Flowable
import android.arch.persistence.room.OnConflictStrategy



@Dao
interface UserDao {

    @Query("SELECT * FROM userData LIMIT 5")
    fun getAllUsers() : Flowable<List<UserData>>

    @Query("SELECT * FROM userData ORDER BY rank DESC LIMIT 5")
    fun getOrderUsers(): Flowable<List<UserData>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(favoriteShow: UserData)

}