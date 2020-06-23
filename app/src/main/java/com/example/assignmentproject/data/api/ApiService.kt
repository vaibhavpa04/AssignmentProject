package com.example.assignmentproject.data.api

import com.example.assignmentproject.data.model.ResponseHandler
import retrofit2.http.GET

interface ApiService {
    @GET("/")
    fun getArticles(): List<ResponseHandler>
}