package com.sevenpeakssoftware.faizan.model

import androidx.room.TypeConverter
import com.google.gson.reflect.TypeToken
import com.sevenpeakssoftware.faizan.network.ApiClient.getGsonObj
import java.lang.reflect.Type


class Converter {

    @TypeConverter
    fun fromString(value: String?): MutableList<String?>? {
        val listType: Type = object : TypeToken<MutableList<String?>?>() {}.type
        return getGsonObj().fromJson(value, listType)
    }

    @TypeConverter
    fun fromArrayList(list: MutableList<String?>?) = getGsonObj().toJson(list)

    @TypeConverter
    fun fromContentString(value: String?): MutableList<CarType?>? {
        val listType: Type = object : TypeToken<MutableList<CarType>?>() {}.type
        return getGsonObj().fromJson(value, listType)
    }

    @TypeConverter
    fun fromListToJson(list: MutableList<CarType>?): String? = getGsonObj().toJson(list)

}