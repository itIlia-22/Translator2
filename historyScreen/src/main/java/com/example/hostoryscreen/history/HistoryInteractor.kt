package com.example.hostoryscreen.history

import com.example.core.viewmodel.Interactor
import com.example.model.AppState
import com.example.model.dto.SearchResultDto
import com.example.repository.api.Repository
import com.example.repository.api.RepositoryLocal

class HistoryInteractor(
    private val repositoryRemote: Repository<List<SearchResultDto>>,
    private val repositoryLocal: RepositoryLocal<List<SearchResultDto>>
) : Interactor<AppState> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): AppState {
        return AppState.Success(
            mapSearchResultToResult(
                if (fromRemoteSource) {
                    repositoryRemote
                } else {
                    repositoryLocal
                }.getData(word)
            )
        )
    }
}
