package com.example.davidmartins.codewar.data.repositories

import android.arch.lifecycle.LiveData
import com.example.davidmartins.codewar.data.api.CodeWarApi
import com.example.davidmartins.codewar.data.db.UserDao
import com.example.davidmartins.codewar.data.db.UserData
import com.example.davidmartins.codewar.data.models.AuthoredResponse
import com.example.davidmartins.codewar.data.models.CompletedResponse
import com.example.davidmartins.codewar.data.models.Detail
import com.example.davidmartins.codewar.data.models.User
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CodeWarRepository @Inject constructor(private val codeWarApi: CodeWarApi,
                                            private val userDao: UserDao) {

    fun getUserByName(userName: String) : Single<User> = codeWarApi.getUser(userName)

    fun getCompletedByUser(userName: String) : Single<CompletedResponse> = codeWarApi.getCompletedByUser(userName)

    fun getAuthoredByUser(userName: String) : Single<AuthoredResponse> = codeWarApi.getAuthoredByUser(userName)

    fun getChallengeDetailById(id: String) : Single<Detail> = codeWarApi.getChallengeDetails(id)

    fun insertUserOnDb(user: User) = userDao.insertUser(UserData(0, user.name, user.ranks.overall.rank))

    fun getAllUsers() : Single<List<UserData>> = userDao.getOrderUsers()

    fun getAllUsersOrdered() : Single<List<UserData>> = userDao.getOrderUsers()
}