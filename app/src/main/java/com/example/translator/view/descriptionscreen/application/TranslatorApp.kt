package com.example.translator.view.descriptionscreen.application

import android.app.Application
import com.example.translator.utils.di.application
import com.example.translator.utils.di.historyScreen
import com.example.translator.utils.di.mainScreen
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class TranslatorApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(listOf(application, mainScreen, historyScreen))
        }
    }
}
