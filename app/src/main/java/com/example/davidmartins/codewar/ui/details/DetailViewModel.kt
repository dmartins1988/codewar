package com.example.davidmartins.codewar.ui.details

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.example.davidmartins.codewar.base.BaseViewModel
import com.example.davidmartins.codewar.data.models.Detail
import com.example.davidmartins.codewar.data.repositories.CodeWarRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class DetailViewModel @Inject constructor(private val codeWarRepository: CodeWarRepository) : BaseViewModel() {

    private val detailChallenge = MutableLiveData<Detail>()

    private val loading = MutableLiveData<Boolean>()
    private val loadError = MutableLiveData<Boolean>()

    internal fun getDetails() : LiveData<Detail> = detailChallenge

    internal fun getError() : LiveData<Boolean> = loadError

    internal fun getLoading() : LiveData<Boolean> = loading

    fun getDetail(id: String) {
        loading.value = true
        disposable.add(
                codeWarRepository.getChallengeDetailById(id)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(object : DisposableSingleObserver<Detail>() {
                            override fun onSuccess(detail: Detail) {
                                detailChallenge.value = detail
                                loading.value = false
                                loadError.value = false
                            }

                            override fun onError(e: Throwable) {
                                loading.value = false
                                loadError.value = true
                            }

                        })
        )
    }


}