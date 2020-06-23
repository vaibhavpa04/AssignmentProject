package com.example.assignmentproject.ui.base.article

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.assignmentproject.data.repository.ArticleRepository
import com.example.assignmentproject.utils.common.Resource
import kotlinx.coroutines.Dispatchers

class ArticleViewModel(private val articleRepository: ArticleRepository) :ViewModel() {

    fun  getArticles() = liveData(Dispatchers.IO){
        emit(Resource.loading(data = null))
        try{
            emit(Resource.success(data = articleRepository.getArticles()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }

    }
}