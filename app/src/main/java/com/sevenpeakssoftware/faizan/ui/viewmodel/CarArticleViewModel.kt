package com.sevenpeakssoftware.faizan.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import com.sevenpeakssoftware.faizan.di.base.BaseViewModel
import com.sevenpeakssoftware.faizan.models.CarArticlesModel

class CarArticleViewModel : BaseViewModel() {

    private val carArticleTitle = MutableLiveData<String>()
    private val carArticleImage = MutableLiveData<Int>()
    private val carArticleDate = MutableLiveData<String>()
    private val carArticleIngress = MutableLiveData<String>()

    fun bind(carArticlesModel: CarArticlesModel) {
        carArticleTitle.value = carArticlesModel.status
    }

    fun getCarArticleTitle(): MutableLiveData<String> {
        return carArticleTitle
    }

    fun getCarArticleImage(): MutableLiveData<Int> {
        return carArticleImage
    }

    fun getCarArticleDate(): MutableLiveData<String> {
        return carArticleDate
    }

    fun getCarArticleIngress(): MutableLiveData<String> {
        return carArticleIngress
    }

}