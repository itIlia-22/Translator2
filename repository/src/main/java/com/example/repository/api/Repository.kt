package com.example.repository.api

interface Repository<T> {

    suspend fun getData(word: String): T
}
