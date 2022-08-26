package com.example.paging.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.paging.model.UserInfo
import com.example.paging.network.RetrofitInstance

class UserPagingSource : PagingSource<Int, UserInfo.Data>(){
    override fun getRefreshKey(state: PagingState<Int, UserInfo.Data>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UserInfo.Data> {
        val page: Int = params.key ?: 1
        val prevPage = params.key
        val nextPage = page + 1

       return try {
            val response = RetrofitInstance.userService.getData(page = page)
            if (response.isSuccessful){
                val users = response.body()?.data ?: emptyList()
                LoadResult.Page(users,prevPage,nextPage)
            }else{
                LoadResult.Error(Throwable())
            }
        }catch (e: Throwable){
            LoadResult.Error(e)
        }
    }
}