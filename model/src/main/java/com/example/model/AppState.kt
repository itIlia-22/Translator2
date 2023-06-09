package com.example.model

import com.example.model.dto.SearchResultDto
import com.example.model.userdata.DataModel

sealed class AppState {

    data class Success(val data: List<DataModel>?) : AppState()
    data class Error(val error: Throwable) : AppState()
    data class Loading(val progress: Int?) : AppState()
}
