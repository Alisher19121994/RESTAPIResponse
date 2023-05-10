package com.milliybank.restapiresponse

data class UsersListItem(
    val completed: Boolean,
    val id: Int,
    val title: String,
    val userId: Int
)