package com.sevenpeakssoftware.faizan.models

import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName
import org.json.JSONArray

/**
 * Class presenting Car Articles Model
 * @constructor Sets all properties of the articles
 * @property status check data is loaded or not.
 * @property content contains all car articles.
 * @property serverTime get page count.
 */
data class CarArticlesModel(
    @SerializedName("status")
    val status: String,
    @SerializedName("content")
    val content: JSONArray,
    @SerializedName("serverTime")
    val serverTime: Int
)