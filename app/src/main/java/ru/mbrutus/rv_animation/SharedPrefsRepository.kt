package ru.mbrutus.rv_animation

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatDelegate
import androidx.preference.PreferenceManager

object SharedPrefsRepository {
    private const val IS_DARK = "isDark"

    private val prefs: SharedPreferences by lazy {
        val ctx = App.applicationContext()
        PreferenceManager.getDefaultSharedPreferences(ctx)
    }

    fun saveThemeState(localNightMode: Int) {
        val editor = prefs.edit()
        editor.putInt(IS_DARK, localNightMode)
        editor.apply()
    }

    fun getThemeState(): Int {
        return prefs.getInt(IS_DARK, AppCompatDelegate.MODE_NIGHT_NO)
    }
}