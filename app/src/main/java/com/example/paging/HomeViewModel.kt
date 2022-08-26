package com.example.paging

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.paging.model.UserInfo
import com.example.paging.paging.UserPagingSource
import kotlinx.coroutines.flow.Flow

class HomeViewModel : ViewModel() {
    fun getList(): Flow<PagingData<UserInfo.Data>> {
        return Pager(
            config = PagingConfig(pageSize = 100),
            pagingSourceFactory = {UserPagingSource()}
        ).flow.cachedIn(viewModelScope)
    }
}