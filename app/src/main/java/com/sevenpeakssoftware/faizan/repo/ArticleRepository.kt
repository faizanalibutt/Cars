package com.sevenpeakssoftware.faizan.repo

import androidx.annotation.WorkerThread
import com.sevenpeakssoftware.faizan.model.CarArticle
import kotlinx.coroutines.flow.Flow

class ArticleRepository(private val articleDao: ArticleDao) {

    val allCarArticles: Flow<List<CarArticle>> = articleDao.getArticlesList()

    @WorkerThread
    suspend fun insert(carArticleList: List<CarArticle>) {
        articleDao.insert(carArticleList)
    }

    suspend fun delete(carArticle: CarArticle) {
        articleDao.delete(carArticle)
    }

}