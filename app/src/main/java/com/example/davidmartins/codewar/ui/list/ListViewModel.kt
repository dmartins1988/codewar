package com.example.davidmartins.codewar.ui.list

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.example.davidmartins.codewar.base.BaseViewModel
import com.example.davidmartins.codewar.data.models.*
import com.example.davidmartins.codewar.data.repositories.CodeWarRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ListViewModel @Inject constructor(private val codeWarRepository: CodeWarRepository) : BaseViewModel() {


    private val completedChallenge = MutableLiveData<CompletedResponse>()
    private val authoredChallenge = MutableLiveData<AuthoredResponse>()
    private val listOfCompleted = MutableLiveData<List<Completed>>()
    private val listOfAuthored = MutableLiveData<List<Authored>>()

    private val loadError = MutableLiveData<Boolean>()
    private val loading = MutableLiveData<Boolean>()

    internal fun getListOfCompleted(): LiveData<List<Completed>> {
        return listOfCompleted
    }

    internal fun getListOfAuthored(): LiveData<List<Authored>> {
        return listOfAuthored
    }

    internal fun getError(): LiveData<Boolean> {
        return loadError
    }

    internal fun getLoading(): LiveData<Boolean> {
        return loading
    }

    internal fun getCompletedChallenge(): LiveData<CompletedResponse> {
        return completedChallenge
    }

    fun getCompletedChallenges(username: String) {
        loading.value = true
        disposable.add(
                codeWarRepository.getCompletedByUser(username)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(object : DisposableSingleObserver<CompletedResponse>(){
                            override fun onSuccess(completedResponse: CompletedResponse) {
                                completedChallenge.value = completedResponse
                                listOfCompleted.value = completedResponse.data
                                loading.value = false
                                loadError.value = false
                            }

                            override fun onError(e: Throwable) {
                                loadError.value = true
                                loading.value = false
                            }

                        })
        )
    }

    fun getAuthoredChallenges(username: String) {
        loading.value = true
        disposable.add(
                codeWarRepository.getAuthoredByUser(username)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(object : DisposableSingleObserver<AuthoredResponse>() {
                            override fun onSuccess(authoredResponse: AuthoredResponse) {
                                authoredChallenge.value = authoredResponse
                                listOfAuthored.value = authoredResponse.data
                                loading.value = false
                                loadError.value = false
                            }

                            override fun onError(e: Throwable) {
                                loadError.value = true
                                loading.value = false
                            }

                        })
        )
    }


}