package com.sevenpeakssoftware.faizan.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.sevenpeakssoftware.faizan.ui.viewmodel.CarArticleViewModel
import com.sevenpeakssoftware.faizan.R
import com.sevenpeakssoftware.faizan.databinding.ItemCarBinding
import com.sevenpeakssoftware.faizan.models.CarArticlesModel

class CarArticlesAdapter : RecyclerView.Adapter<CarArticlesAdapter.ViewHolder>() {

    private lateinit var carArtilesList: List<CarArticlesModel>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemCarBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_car, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return if (::carArtilesList.isInitialized) carArtilesList.size else 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(carArtilesList[position])
    }

    fun updatePositionList(carManufacturerList: List<CarArticlesModel>) {
        this.carArtilesList = carManufacturerList
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemCarBinding) : RecyclerView.ViewHolder(binding.root) {

        private val viewModel = CarArticleViewModel()

        fun bind(carArticle: CarArticlesModel) {
            viewModel.bind(carArticle)
            binding.viewModel = viewModel
        }
    }
}