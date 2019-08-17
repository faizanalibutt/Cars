package com.sevenpeakssoftware.faizan.ui.viewmodel

import android.view.View
import androidx.lifecycle.MutableLiveData
import com.sevenpeakssoftware.faizan.R
import com.sevenpeakssoftware.faizan.di.base.BaseViewModel
import com.sevenpeakssoftware.faizan.models.CarArticlesModel
import com.sevenpeakssoftware.faizan.network.AutoApi
import com.sevenpeakssoftware.faizan.ui.adapters.CarArticlesAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class CarArticlesListViewModel : BaseViewModel() {

    @Inject
    lateinit var autoApi: AutoApi

    private lateinit var subscription: Disposable
    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
    val errorMessage: MutableLiveData<Int> = MutableLiveData()
    val errorClickListener = View.OnClickListener { loadManufacturers() }
    val carArticlesAdapter: CarArticlesAdapter = CarArticlesAdapter()

    init {
        loadManufacturers()
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }

    private fun loadManufacturers() {
        subscription = autoApi.getCarArticles()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { onRetrievePostListStart() }
            .doOnTerminate { onRetrievePostListFinish() }
            .subscribe(
                { result -> onRetrievePostListSuccess(result) },
                { onRetrievePostListError() }
            )
    }

    private fun onRetrievePostListStart() {
        loadingVisibility.value = View.VISIBLE
        errorMessage.value = null
    }

    private fun onRetrievePostListFinish() {
        loadingVisibility.value = View.GONE
    }

    private fun onRetrievePostListSuccess(carArticlesList: CarArticlesModel) {
        //carArticlesAdapter.updatePositionList(carArticlesList)
    }

    private fun onRetrievePostListError() {
        errorMessage.value = R.string.post_error
    }

}