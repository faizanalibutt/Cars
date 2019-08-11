package com.sevenpeakssoftware.faizan.di.component

import com.sevenpeakssoftware.faizan.di.module.NetworkModule
import com.sevenpeakssoftware.faizan.ui.viewmodel.CarArticlesListViewModel
import com.sevenpeakssoftware.faizan.ui.viewmodel.NetworkStateViewModel
import dagger.Component
import javax.inject.Singleton

/**
 * Component providing inject() methods for presenters.
 */
@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector {
    /**
     * Injects required dependencies into the specified CarViewModel.
     * @param carViewModel CarViewModel in which to inject the dependencies
     */
    fun inject(carArticlesListViewModel: CarArticlesListViewModel)
    /**
     * Injects required dependencies into the specified CarViewModel.
     * @param networkStateViewModel NetworkStateViewModel in which to inject the dependencies
     */
    fun inject(networkStateViewModel: NetworkStateViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector
        fun networkModule(networkModule: NetworkModule): Builder
    }
}