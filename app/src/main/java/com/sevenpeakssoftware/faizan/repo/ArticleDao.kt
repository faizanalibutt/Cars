package com.sevenpeakssoftware.faizan.repo

import androidx.room.*
import com.sevenpeakssoftware.faizan.model.CarArticle
import kotlinx.coroutines.flow.Flow

@Dao
interface ArticleDao {

    @Query("SELECT * FROM article_table ORDER BY id DESC")
    fun getArticlesList(): Flow<List<CarArticle>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(carArticleList: List<CarArticle>)

    @Delete
    suspend fun delete(article: CarArticle)

}