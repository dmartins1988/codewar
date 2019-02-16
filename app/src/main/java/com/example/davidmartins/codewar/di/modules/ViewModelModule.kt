package com.example.davidmartins.codewar.di.modules

import com.example.davidmartins.codewar.di.util.ViewModelKey
import com.example.davidmartins.codewar.ui.details.DetailViewModel
import com.example.davidmartins.codewar.ui.list.ListViewModel
import com.example.davidmartins.codewar.ui.main.StartViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Singleton


@Singleton
@Module
abstract class ViewModelModule {


    @Binds
    @IntoMap
    @ViewModelKey(StartViewModel::class)
    abstract fun bindStartViewModel(viewModel: StartViewModel)


    @Binds
    @IntoMap
    @ViewModelKey(ListViewModel::class)
    abstract fun bindListViewModel(viewModel: ListViewModel)

    @Binds
    @IntoMap
    @ViewModelKey(DetailViewModel::class)
    abstract fun bindDetailViewModel(viewModel: DetailViewModel)

}