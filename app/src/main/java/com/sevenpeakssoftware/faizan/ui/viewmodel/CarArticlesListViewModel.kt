package com.sevenpeakssoftware.faizan.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations.switchMap
import com.sevenpeakssoftware.faizan.di.base.BaseViewModel
import com.sevenpeakssoftware.faizan.models.CarArticlesModel
import com.sevenpeakssoftware.faizan.network.AutoApi
import com.sevenpeakssoftware.faizan.repo.Listing
import io.reactivex.disposables.CompositeDisposable
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Inject


class CarArticlesListViewModel : BaseViewModel() {

    @Inject
    lateinit var autoApi: AutoApi

    private var networkExecutor: Executor? = null
    private val subscription = CompositeDisposable()
    private val repoResult = MutableLiveData<Listing<CarArticlesModel>>()
    val cars = switchMap(repoResult) { it.pagedList }
    val networkState = switchMap(repoResult) { it.networkState }

    init {
        //repoResult.postValue(manufacturersOfCar())
    }

    /*private fun manufacturersOfCar(): Listing<CarArticlesModel> {

        networkExecutor = Executors.newFixedThreadPool(5)

        return Listing(
            pagedList = ,
            networkState = switchMap(carManufacturersDataFactory.mutableLiveManufacturersData) {
                it.networkState
            },
            retry = {
                carManufacturersDataFactory.mutableLiveManufacturersData.value.retryAllFailed()
            })

    }*/

    fun retry() {
        val listing = repoResult.value
        listing?.retry?.invoke()
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }

}