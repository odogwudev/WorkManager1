package com.odogwudev.workmanager1.repository

import android.content.Context
import android.content.SharedPreferences

class SharedPreferencesRepository(context: Context) {

    private val SHARED_PREFERENCES = "shared_preferences"
    private val KEY_INFO = "info"

    private var mySharedPreferences: SharedPreferences = context.getSharedPreferences(
        SHARED_PREFERENCES, Context.MODE_PRIVATE
    )
    private lateinit var editor: SharedPreferences.Editor

    fun setInfo(info: String) {
        editor = mySharedPreferences.edit()
        editor.putString(KEY_INFO, info)
        editor.apply()
    }

    fun getInfo(): String? {
        return mySharedPreferences.getString(KEY_INFO, "")
    }

    fun clearInfo() {
        editor = mySharedPreferences.edit()
        editor.clear()
        editor.apply()
    }
}