package com.example.davidmartins.codewar.ui.list

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ListFragmentBindingModule {

    @ContributesAndroidInjector
    internal abstract fun provideCompletedFragment() : CompletedFragment

    @ContributesAndroidInjector
    internal abstract fun provideAuthoredFragment(): AuthoredFragment
}