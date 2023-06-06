package com.example.repository.api

import com.example.model.DataModel
import com.example.repository.api.DataSource
import com.example.repository.api.Repository

class RepositoryImplementation(private val dataSource: DataSource<List<DataModel>>) :
    Repository<List<DataModel>> {

    override suspend fun getData(word: String): List<DataModel> {
        return dataSource.getData(word)
    }
}
