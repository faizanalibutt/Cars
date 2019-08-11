package com.sevenpeakssoftware.faizan.network

import com.sevenpeakssoftware.faizan.models.CarArticlesModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * The interface which provides methods to get result of webservices
 */
interface AutoApi {

    /**
     * Get the list of the Car Articles from the API
     */
    @GET("/application/119267/article/get_articles_list")
    fun getCarArticles(): Observable<CarArticlesModel>
}