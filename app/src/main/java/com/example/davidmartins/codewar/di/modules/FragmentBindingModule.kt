package com.example.davidmartins.codewar.di.modules

import com.example.davidmartins.codewar.ui.details.DetailFragment
import com.example.davidmartins.codewar.ui.list.AuthoredFragment
import com.example.davidmartins.codewar.ui.list.CompletedFragment
import com.example.davidmartins.codewar.ui.main.StartFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBindingModule {

    @ContributesAndroidInjector
    abstract fun mainFragment(): StartFragment

    @ContributesAndroidInjector
    abstract fun authoredFragment(): AuthoredFragment

    @ContributesAndroidInjector
    abstract fun completedFragment(): CompletedFragment

    @ContributesAndroidInjector
    abstract fun detailFragment(): DetailFragment
}