package com.example.paging.model

import com.google.gson.annotations.SerializedName

data class UserInfo(
    val page: Int?,
    @SerializedName("per_page")
    val perPage: Int?,
    val total: Int?,
    @SerializedName("total_pages")
    val totalPages: Int?,
    val data : List<Data>?
){
    data class Data(
        val id: Int?,
        val avatar: String?,
        val email: String?,
        @SerializedName("first_name")
        val firstName: String?,
        @SerializedName("last_name")
        val lastName: String?
    )
}
