package com.example.repository.api

interface DataSource<T> {

    suspend fun getData(word: String): T
}
