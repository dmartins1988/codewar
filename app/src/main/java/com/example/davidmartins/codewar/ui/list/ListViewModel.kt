package com.example.davidmartins.codewar.ui.list

import android.arch.lifecycle.MutableLiveData
import com.example.davidmartins.codewar.base.BaseViewModel
import com.example.davidmartins.codewar.data.models.Authored
import com.example.davidmartins.codewar.data.models.Completed
import com.example.davidmartins.codewar.data.repositories.CodeWarRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ListViewModel @Inject constructor(private val codeWarRepository: CodeWarRepository) : BaseViewModel() {


    private val completedChallenge = MutableLiveData<Completed>()
    private val authoredChallenge = MutableLiveData<Authored>()

    private val loadError = MutableLiveData<Boolean>()
    private val loading = MutableLiveData<Boolean>()

    private fun getCompletedChallenges(username: String) {
        loading.value = true
        disposable.add(
                codeWarRepository.getCompletedByUser(username)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(object : DisposableSingleObserver<Completed>(){
                            override fun onSuccess(completed: Completed) {
                                completedChallenge.value = completed
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

    private fun getAuthoredChallenges(username: String) {
        loading.value = true
        disposable.add(
                codeWarRepository.getAuthoredByUser(username)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(object : DisposableSingleObserver<Authored>() {
                            override fun onSuccess(authored: Authored) {
                                authoredChallenge.value = authored
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