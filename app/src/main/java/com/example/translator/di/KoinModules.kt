package com.example.translator.di

import androidx.room.Room
import com.example.hostoryscreen.history.HistoryActivity
import com.example.hostoryscreen.history.HistoryInteractor
import com.example.hostoryscreen.history.HistoryViewModel
import com.example.model.DataModel
import com.example.repository.api.*
import com.example.repository.api.room.HistoryDataBase
import com.example.translator.view.main.MainActivity
import com.example.translator.view.main.MainInteractor
import com.example.translator.view.main.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val application = module {
    single { Room.databaseBuilder(get(), HistoryDataBase::class.java, "HistoryDB").build() }
    single { get<HistoryDataBase>().historyDao() }
    single<Repository<List<DataModel>>> { RepositoryImplementation(RetrofitImplementation()) }
    single<RepositoryLocal<List<DataModel>>> { RepositoryImplementationLocal(
        RoomDataBaseImplementation(get())
    )
    }
}


val mainScreen = module {
    scope(named<MainActivity>()) {
        scoped { MainInteractor(get(), get()) }
        viewModel { MainViewModel(get()) }
    }
}

val historyScreen = module {
    scope(named<HistoryActivity>()) {
        scoped { HistoryInteractor(get(), get()) }
        viewModel { HistoryViewModel(get()) }
    }
}
