package com.example.davidmartins.codewar.ui.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.example.davidmartins.codewar.base.BaseViewModel
import com.example.davidmartins.codewar.data.models.User
import com.example.davidmartins.codewar.data.repositories.CodeWarRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class StartViewModel @Inject constructor(private val codeWarRepository: CodeWarRepository) : BaseViewModel() {

    private val user = MutableLiveData<User>()
    private val userLoadError = MutableLiveData<Boolean>()
    private val loading = MutableLiveData<Boolean>()

    private lateinit var userToSearch: String

    internal fun getUser(): LiveData<User> {
        return user
    }

    internal fun getError(): LiveData<Boolean> {
        return userLoadError
    }

    internal fun getLoading(): LiveData<Boolean> {
        return loading
    }


    fun searchUser(userName: String) {
        userToSearch = userName
        fetchUser(userToSearch)
    }

    private fun fetchUser(userName: String) {
        loading.value = true
        disposable.add(
                codeWarRepository.getUserByName(userName)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(object : DisposableSingleObserver<User>() {
                            override fun onSuccess(user1: User) {
                                userLoadError.value = false
                                user.value = user1
                                loading.value = false
                            }

                            override fun onError(e: Throwable) {
                                loading.value = false
                                userLoadError.value = true
                            }
                        }))

    }

}