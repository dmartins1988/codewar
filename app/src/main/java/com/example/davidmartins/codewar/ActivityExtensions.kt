package com.example.davidmartins.codewar

import android.app.Activity
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import com.example.davidmartins.codewar.base.BaseActivity

inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) {
    beginTransaction().func()
            .commit()
}

fun AppCompatActivity.addFragment(fragment: Fragment, @IdRes frameId: Int) {
    supportFragmentManager.inTransaction { add(frameId, fragment) }
}

fun AppCompatActivity.replaceFragment(fragment: Fragment, @IdRes frameId: Int) {
    supportFragmentManager.inTransaction { replace(frameId, fragment) }
}

fun Fragment.baseActivity() = this.activity as BaseActivity

inline fun <reified T : ViewModel> ofFragment(
        fragment: Fragment,
        viewModelFactory: ViewModelProvider.Factory
): T {
    return ViewModelProviders.of(fragment, viewModelFactory)[T::class.java]
}