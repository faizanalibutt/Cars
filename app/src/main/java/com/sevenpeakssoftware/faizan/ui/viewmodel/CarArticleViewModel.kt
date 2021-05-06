package com.sevenpeakssoftware.faizan.ui.viewmodel

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bumptech.glide.Glide
import com.sevenpeakssoftware.faizan.R
import com.sevenpeakssoftware.faizan.databinding.ItemCarBinding
import com.sevenpeakssoftware.faizan.model.CarArticle
import com.sevenpeakssoftware.faizan.utils.TimeUtils

class CarArticleViewModel(lifecycleOwner: LifecycleOwner, binding: ItemCarBinding) : ViewModel() {

    private val title = MutableLiveData<String>()
    private val image = MutableLiveData<String>()
    private val date = MutableLiveData<String>()
    private val ingress = MutableLiveData<String>()

    init {
        title.observe(lifecycleOwner, {
            binding.demoTitle.text = it
        })
        date.observe(lifecycleOwner, {
            binding.demoDate.text = TimeUtils.showRequiredDate(it, lifecycleOwner as Context)
        })
        ingress.observe(lifecycleOwner, {
            binding.demoIngress.text = it
        })
        image.observe(lifecycleOwner, {
            // glide will be here. wait
            Glide.with(lifecycleOwner as Context)
                .load(it)
                .centerCrop()
                .placeholder(R.drawable.audi_q7)
                .into(binding.demoImage)
        })
    }

    fun bind(carArticle: CarArticle) {
        title.value = carArticle.title
        date.value = carArticle.dateTime
        ingress.value = carArticle.ingress
        image.value = carArticle.image
    }

}