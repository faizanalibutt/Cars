package com.sevenpeakssoftware.faizan.network

import com.sevenpeakssoftware.faizan.model.CarModel
import org.json.JSONArray
import org.json.JSONObject
import retrofit2.http.GET

/**
 * The interface which provides methods to get result of webservices
 */
interface AutoApi {

    /**
     * Get the list of the Car Articles from the API
     */
    @GET(ARTICLES)
    suspend fun getCarArticles(): CarModel

    companion object {
        const val ARTICLES = "article/get_articles_list"
    }
}