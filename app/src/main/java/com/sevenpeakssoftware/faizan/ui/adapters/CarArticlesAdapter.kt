package com.sevenpeakssoftware.faizan.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.sevenpeakssoftware.faizan.R
import com.sevenpeakssoftware.faizan.databinding.ItemCarBinding
import com.sevenpeakssoftware.faizan.models.CarArticlesModel
import com.sevenpeakssoftware.faizan.ui.viewmodel.CarArticleViewModel

class CarArticlesAdapter : RecyclerView.Adapter<CarArticlesAdapter.ViewHolder>() {

    private lateinit var carManufacturerList: List<CarArticlesModel>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemCarBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_car, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return if (::carManufacturerList.isInitialized) carManufacturerList.size else 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(carManufacturerList[position])
    }

    fun updatePositionList(carManufacturerList: List<CarArticlesModel>) {
        this.carManufacturerList = carManufacturerList
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