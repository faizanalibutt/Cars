package com.sevenpeakssoftware.faizan.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.sevenpeakssoftware.faizan.AppDelegate
import com.sevenpeakssoftware.faizan.databinding.ActivityMainBinding
import com.sevenpeakssoftware.faizan.repo.isOnline
import com.sevenpeakssoftware.faizan.utils.Status
import com.sevenpeakssoftware.faizan.ui.adapter.CarArticlesAdapter
import com.sevenpeakssoftware.faizan.ui.viewmodel.CarViewModel
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private val carViewModel: CarViewModel by viewModels {
        CarViewModel.CarViewModelFactory((application as AppDelegate).articleRepository)
    }
    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = activityMainBinding.root
        setContentView(view)

        val recyclerView = activityMainBinding.articleList
        val adapter = CarArticlesAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        carViewModel.allArticlesLocal.observe(this, {
            Timber.d("observer is must if you need data.")
            if(!isOnline())
                adapter.updateArticlesList(it)
        })

        carViewModel.loadCarArticles().observe(this, { result ->
            result?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        Timber.d("My Car Articles List: ${resource.data}")
                        activityMainBinding.progressBar.visibility = View.GONE
                        resource.data?.let {
                            adapter.updateArticlesList(it.content)
                            carViewModel.insert(it.content)
                        }
                    }
                    Status.FAILED -> {
                        Timber.d("data is not fetched as expected ${resource.message}")
                        activityMainBinding.progressBar.visibility = View.GONE
                        Toast.makeText(this, "Network is not available", Toast.LENGTH_SHORT).show()
                    }
                    Status.RUNNING -> {
                        activityMainBinding.progressBar.visibility = View.VISIBLE
                    }
                }
            }
        })

    }

}
