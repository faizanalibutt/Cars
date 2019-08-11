package com.sevenpeakssoftware.faizan.di.base

import androidx.lifecycle.ViewModel
import com.sevenpeakssoftware.faizan.di.component.DaggerViewModelInjector
import com.sevenpeakssoftware.faizan.di.component.ViewModelInjector
import com.sevenpeakssoftware.faizan.di.module.NetworkModule
import com.sevenpeakssoftware.faizan.ui.viewmodel.CarArticlesListViewModel

abstract class BaseViewModel : ViewModel() {

    private val injector: ViewModelInjector = DaggerViewModelInjector
        .builder()
        .networkModule(NetworkModule)
        .build()

    init {
        inject()
    }

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is CarArticlesListViewModel -> injector.inject(this)
        }
    }
}