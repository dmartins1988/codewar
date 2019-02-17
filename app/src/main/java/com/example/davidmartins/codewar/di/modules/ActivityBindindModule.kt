package com.example.davidmartins.codewar.di.modules

import com.example.davidmartins.codewar.ui.details.DetailsActivity
import com.example.davidmartins.codewar.ui.list.ListActivity
import com.example.davidmartins.codewar.ui.main.StartActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindindModule {

    @ContributesAndroidInjector
    abstract fun startActivity(): StartActivity


    @ContributesAndroidInjector
    abstract fun listActivity(): ListActivity

    @ContributesAndroidInjector
    abstract fun detailActivity(): DetailsActivity
}