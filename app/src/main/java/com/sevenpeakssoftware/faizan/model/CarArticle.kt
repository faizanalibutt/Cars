package com.sevenpeakssoftware.faizan.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import org.json.JSONArray

/**
 * article detail
 * */
@Entity(tableName = "article_table")
data class CarArticle(
    @SerializedName("id")
    @PrimaryKey() @ColumnInfo(name = "id") val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("dateTime")
    val dateTime: String,
    @SerializedName("tags")
    val tags : MutableList<String>,
    @SerializedName("content")
    val content : MutableList<CarType>,
    @SerializedName("ingress")
    val ingress: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("created")
    val created: Long,
    @SerializedName("changed")
    val changed: Long,
)
