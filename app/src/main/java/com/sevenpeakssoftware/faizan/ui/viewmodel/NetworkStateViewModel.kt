package com.sevenpeakssoftware.faizan.ui.viewmodel

import android.view.View
import androidx.lifecycle.MutableLiveData
import com.sevenpeakssoftware.faizan.utils.NetworkState
import com.sevenpeakssoftware.faizan.di.base.BaseViewModel
import com.sevenpeakssoftware.faizan.utils.Status

class NetworkStateViewModel : BaseViewModel() {

    private val networkStateTitle : MutableLiveData<String> = MutableLiveData()
    private val networkStateVisibility: MutableLiveData<Int> = MutableLiveData()
    private val loadingVisibility: MutableLiveData<Int> = MutableLiveData()

    fun bindView(networkState: NetworkState?) {

        if (networkState != null && networkState.status === Status.RUNNING) {
            loadingVisibility.value = View.VISIBLE
        } else {
            loadingVisibility.value = View.GONE
        }

        if (networkState != null && networkState.status === Status.FAILED) {
            networkStateTitle.value = networkState.msg
            networkStateVisibility.value = View.VISIBLE
        } else {
            networkStateVisibility.value = View.GONE
        }
    }

    fun getNetworkStateTitle(): MutableLiveData<String> {
        return networkStateTitle
    }

    fun getLoadingVisibility(): MutableLiveData<Int> {
        return loadingVisibility
    }

    fun getNetworkStateVisibility(): MutableLiveData<Int> {
        return networkStateVisibility
    }

}