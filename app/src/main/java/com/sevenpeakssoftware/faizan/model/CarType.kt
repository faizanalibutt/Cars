package com.sevenpeakssoftware.faizan.model

import com.google.gson.annotations.SerializedName

data class CarType(
    @SerializedName("type")
    val type: String,
    @SerializedName("subject")
    val subject: String,
    @SerializedName("description")
    val description: String,
)
