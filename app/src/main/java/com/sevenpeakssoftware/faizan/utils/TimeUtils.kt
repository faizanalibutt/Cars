package com.sevenpeakssoftware.faizan.utils

import android.content.Context
import android.text.format.DateFormat
import java.text.SimpleDateFormat
import java.util.*

object TimeUtils {


    fun showRequiredDate(stringDate: String, context: Context): String {
        // 25.05.2018 14:13
        val simpleDateFormat = SimpleDateFormat("dd.MM.yyyy HH:mm", Locale.getDefault())
        val beforeDate = simpleDateFormat.parse(stringDate)
        beforeDate?.let {
            val newDateFormat: SimpleDateFormat =
                if (DateFormat.is24HourFormat(context))
                    SimpleDateFormat(
                        if (beforeDate.time < getCurrentYear())
                            "dd MMMM yyyy, HH:mm"
                        else
                            "dd MMMM, HH:mm",
                        Locale.getDefault()
                    )
                else
                    SimpleDateFormat(
                        if (beforeDate.time < getCurrentYear())
                            "dd MMMM yyyy, hh:mm aa"
                        else
                            "dd MMMM, hh:mm aa",
                        Locale.getDefault()
                    )
            return newDateFormat.format(beforeDate)
        }
        return "couldn't get date"
    }

    private fun getCurrentYear(): Long {
        val c = Calendar.getInstance().apply {
            get(Calendar.YEAR)
        }
        return c.timeInMillis
    }
}