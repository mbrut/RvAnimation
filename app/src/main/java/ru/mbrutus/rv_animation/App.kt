package ru.mbrutus.rv_animation

import android.app.Application
import android.content.Context
import androidx.appcompat.app.AppCompatDelegate

class App: Application() {
    companion object {
        private var instance: App? = null

        fun applicationContext(): Context {
            return instance!!.applicationContext
        }
    }

    init {
        instance = this
    }

    override fun onCreate() {
        super.onCreate()
        SharedPrefsRepository.getThemeState().also {
            AppCompatDelegate.setDefaultNightMode(it)
        }
    }
}