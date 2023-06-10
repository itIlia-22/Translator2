package com.example.translator.view.main

import com.example.core.viewmodel.Interactor
import com.example.model.AppState
import com.example.model.dto.SearchResultDto
import com.example.repository.api.Repository
import com.example.repository.api.RepositoryLocal
import com.example.translator.utils.mapSearchResultToResult

class MainInteractor(
    private val repositoryRemote: Repository<List<SearchResultDto>>,
    private val repositoryLocal: RepositoryLocal<List<SearchResultDto>>
) : Interactor<AppState> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): AppState {
        val appState: AppState
        if (fromRemoteSource) {
            appState = AppState.Success(mapSearchResultToResult(repositoryRemote.getData(word)))
            repositoryLocal.saveToDB(appState)
        } else {
            appState = AppState.Success(mapSearchResultToResult(repositoryRemote.getData(word)))
        }
        return appState
    }
}
