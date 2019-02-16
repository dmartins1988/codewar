package com.example.davidmartins.codewar.base

import android.arch.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel : ViewModel() {

    protected var disposable = CompositeDisposable()

    override fun onCleared() {
        disposable.clear()
    }
}