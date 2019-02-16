package com.example.davidmartins.codewar.data.repositories

import com.example.davidmartins.codewar.data.api.CodeWarApi
import com.example.davidmartins.codewar.data.models.Authored
import com.example.davidmartins.codewar.data.models.Completed
import com.example.davidmartins.codewar.data.models.Detail
import com.example.davidmartins.codewar.data.models.User
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CodeWarRepository @Inject constructor(private val codeWarApi: CodeWarApi) {

    fun getUserByName(userName: String) : Single<User> = codeWarApi.getUser(userName)

    fun getCompletedByUser(userName: String) : Single<Completed> = codeWarApi.getCompletedByUser(userName)

    fun getAuthoredByUser(userName: String) : Single<Authored> = codeWarApi.getAuthoredByUser(userName)

    fun getChallengeDetailById(id: String) : Single<Detail> = codeWarApi.getChallengeDetails(id)

}