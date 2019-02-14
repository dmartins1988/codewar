package com.example.davidmartins.codewar

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