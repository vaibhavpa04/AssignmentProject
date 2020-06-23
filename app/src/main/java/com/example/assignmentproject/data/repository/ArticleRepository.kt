package com.example.assignmentproject.data.repository

import com.example.assignmentproject.data.api.ApiHelper

class ArticleRepository(private val apiHelper: ApiHelper) {
    suspend fun getArticles() = apiHelper.getArticles()
}