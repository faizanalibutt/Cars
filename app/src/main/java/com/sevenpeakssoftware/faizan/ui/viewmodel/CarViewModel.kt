package com.sevenpeakssoftware.faizan.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import com.sevenpeakssoftware.faizan.di.base.BaseViewModel
import com.sevenpeakssoftware.faizan.models.CarArticlesModel

class CarArticleViewModel : BaseViewModel() {

    private val carTitle = MutableLiveData<String>()
    private val carBackground = MutableLiveData<Int>()

    fun bind(carArticle: CarArticlesModel, res: Int) {
        carTitle.value = carArticle.status
        carBackground.value = res
    }

    fun getCarTitle(): MutableLiveData<String> {
        return carTitle
    }

    fun getBackgroud(): MutableLiveData<Int> {
        return carBackground
    }

}