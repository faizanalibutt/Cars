package com.sevenpeakssoftware.faizan.models

import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName

/**
 * Class which provides a model for car models
 * @constructor Sets all properties of the post
 * @property page get page number
 * @property pageSize get page size of desired amount
 * @property totalPageCount get page count.
 * @property wkda get detail information about many manufacturers.
 */
data class CarArticlesModel(
    @SerializedName("page")
    val page: Int,
    @SerializedName("pageSize")
    val pageSize: Int,
    @SerializedName("totalPageCount")
    val totalPageCount: Int,
    @SerializedName("wkda")
    val wkda: JsonObject
)