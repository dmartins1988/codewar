package com.example.davidmartins.codewar.data.api

import com.example.davidmartins.codewar.data.models.*
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface CodeWarApi {

    @GET("users/{user}/code-challenges/completed")
    fun getCompletedByUser(@Path("user") user: String) : Single<Completed>

    @GET("users/{user}/code-challenges/authored")
    fun getAuthoredByUser(@Path("user") user: String) : Single<Authored>

    @GET("users/{user}")
    fun getUser(@Path("user") user: String)  : Single<User>

    @GET("code-challenges/{id}")
    fun getChallengeDetails(id: String) : Single<Detail>
}