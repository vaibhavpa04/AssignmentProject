package com.example.assignmentproject.ui.base.article

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.assignmentproject.R
import com.example.assignmentproject.data.api.ApiHelper
import com.example.assignmentproject.data.api.RetrofitBuilder
import com.example.assignmentproject.data.model.ResponseHandler
import com.example.assignmentproject.ui.base.ViewModelFactory
import com.example.assignmentproject.utils.common.Status
import kotlinx.android.synthetic.main.activity_main.*

class ArticleActivity : AppCompatActivity() {

    private lateinit var viewModel: ArticleViewModel
    private lateinit var adapter: ArticleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViewModel()
        setupUI()
        setupObservers()
    }

    private fun setupViewModel(){
        viewModel = ViewModelProviders.of(this,
            ViewModelFactory(ApiHelper(RetrofitBuilder.apiService))
        ).get(ArticleViewModel::class.java)
    }

    private fun setupUI(){
        val article_list = findViewById<RecyclerView>(R.id.article_list)
        article_list.layoutManager = LinearLayoutManager(this)
        adapter = ArticleAdapter(arrayListOf())
        article_list.adapter = adapter
    }

    private fun setupObservers() {
        viewModel.getArticles().observe(this, Observer {
            it?.let {  resource ->
                     when (resource.status){
                         Status.SUCCESS -> {
                                resource.data?.let { articls -> retriveList(articls)}
                              }
                         Status.ERROR -> {
                             Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                         }
                         Status.LOADING -> {
                         }
                     }
            }
        })
    }

    private fun retriveList(articls: List<ResponseHandler>) {
        adapter.apply {
            addArticles(articls)
            notifyDataSetChanged()
        }
    }
}