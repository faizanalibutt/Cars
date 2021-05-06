package com.sevenpeakssoftware.faizan.ui.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.sevenpeakssoftware.faizan.databinding.ItemCarBinding
import com.sevenpeakssoftware.faizan.model.CarArticle
import com.sevenpeakssoftware.faizan.ui.viewmodel.CarArticleViewModel

class CarArticlesAdapter() : RecyclerView.Adapter<CarArticlesAdapter.ViewHolder>() {

    private lateinit var carArticlesList: List<CarArticle>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemCarBinding = ItemCarBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(itemCarBinding)
    }

    override fun getItemCount(): Int {
        return if (::carArticlesList.isInitialized) carArticlesList.size else 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(carArticlesList[position])
    }

    fun updateArticlesList(carArticlesList: List<CarArticle>) {
        this.carArticlesList = carArticlesList
        notifyDataSetChanged()
    }

    class ViewHolder(binding: ItemCarBinding) : RecyclerView.ViewHolder(binding.root) {
        private val viewModel = CarArticleViewModel(binding.root.context as LifecycleOwner, binding)
        fun bind(carArticle: CarArticle) {
            viewModel.bind(carArticle)
        }
    }
}