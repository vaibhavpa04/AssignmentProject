package com.example.assignmentproject.data.api

class ApiHelper(private val apiService: ApiService) {
    suspend fun getArticles() = apiService.getArticles()
}