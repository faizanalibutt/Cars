package com.sevenpeakssoftware.faizan.model

import com.google.gson.annotations.SerializedName

/**
 * Class presenting Car Articles Model
 * @constructor Sets all properties of the articles
 * @property status check data is loaded or not.
 * @property content contains all car articles.
 * @property serverTime it might be the time i request for data.
 */
data class CarModel(
    @SerializedName("status")
    val status: String,
    @SerializedName("content")
    val content: MutableList<CarArticle>,
    @SerializedName("serverTime")
    val serverTime: Int
)