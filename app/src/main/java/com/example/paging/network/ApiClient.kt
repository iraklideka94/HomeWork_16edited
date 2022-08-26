package com.example.paging.network

import com.example.paging.model.UserInfo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {
    @GET("users")
    suspend fun getData(@Query("page") page: Int) : Response<UserInfo>
}