package com.sevenpeakssoftware.faizan.utils

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.sevenpeakssoftware.faizan.utils.extension.getParentActivity

object BindingAdapters {

    @BindingAdapter("adapter")
    @JvmStatic
    fun setAdapter(
        view: androidx.recyclerview.widget.RecyclerView,
        adapter: androidx.recyclerview.widget.RecyclerView.Adapter<*>
    ) {
        view.adapter = adapter
    }

    @BindingAdapter("mutableVisibility")
    @JvmStatic
    fun setMutableVisibility(view: View, visibility: MutableLiveData<Int>?) {
        val parentActivity: AppCompatActivity? = view.getParentActivity()
        if (parentActivity != null && visibility != null) {
            visibility.observe(parentActivity, Observer { value ->
                view.visibility = value ?: View.VISIBLE
            })
        }
    }

    @BindingAdapter("mutableText")
    @JvmStatic
    fun setMutableText(view: TextView, text: MutableLiveData<String>?) {
        val parentActivity: AppCompatActivity? = view.getParentActivity()
        if (parentActivity != null && text != null) {
            text.observe(parentActivity, Observer { value -> view.text = value ?: "" })
        }
    }

    @BindingAdapter("mutableImage")
    @JvmStatic
    fun setMutableImage(view: ImageView, image: MutableLiveData<Int>) {
        val parentActivity: AppCompatActivity? = view.getParentActivity()
        if (parentActivity != null && image != null) {
            image.observe(parentActivity, Observer { value ->
                view.setImageResource(value)
            })
        }
    }

}
