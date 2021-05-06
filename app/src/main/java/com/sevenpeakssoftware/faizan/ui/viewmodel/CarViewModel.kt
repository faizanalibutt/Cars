package com.sevenpeakssoftware.faizan.ui.viewmodel

import androidx.lifecycle.*
import com.sevenpeakssoftware.faizan.model.CarArticle
import com.sevenpeakssoftware.faizan.network.ApiClient
import com.sevenpeakssoftware.faizan.network.AutoApi
import com.sevenpeakssoftware.faizan.repo.ArticleRepository
import com.sevenpeakssoftware.faizan.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CarViewModel(private val articleRepository: ArticleRepository) : ViewModel() {

    private val autoApi: AutoApi by lazy { ApiClient.apiClient().create(AutoApi::class.java) }
    val allArticlesLocal = articleRepository.allCarArticles.asLiveData()

    fun insert(listCarArticle: List<CarArticle>) = viewModelScope.launch {
        articleRepository.insert(listCarArticle)
    }

    fun delete(carArticle: CarArticle) = viewModelScope.launch {
        articleRepository.delete(carArticle)
    }

    fun loadCarArticles() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(
                Resource.success(
                    data = autoApi.getCarArticles()
                )
            )
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error occurred"))
        }
    }

    class CarViewModelFactory(val articleRepository: ArticleRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(CarViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return CarViewModel(articleRepository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }

}