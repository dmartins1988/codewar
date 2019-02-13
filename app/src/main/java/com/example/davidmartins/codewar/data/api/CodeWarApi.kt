package com.example.davidmartins.codewar.data.api

import com.example.davidmartins.codewar.data.models.Authored
import com.example.davidmartins.codewar.data.models.Completed
import com.example.davidmartins.codewar.data.models.Data
import com.example.davidmartins.codewar.data.models.User
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface CodeWarApi {

    @GET("users/{user}/code-challenges/completed")
    fun getCompletedByUser(@Path("user") user: String) : Single<Authored>

    @GET("users/{user}/code-challenges/authored")
    fun getAuthoredByUser(@Path("user") user: String) : Single<Completed>

    @GET("users/{user}")
    fun getUser(@Path("user") user: String)  : Single<User>
}