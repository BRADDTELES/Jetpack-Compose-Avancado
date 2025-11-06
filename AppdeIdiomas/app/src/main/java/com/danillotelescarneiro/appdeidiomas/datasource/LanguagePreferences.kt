package com.danillotelescarneiro.appdeidiomas.datasource

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataSore by preferencesDataStore(name = "language_datastore")

object LanguagePreferences {

    private val LANGUAGE_KEY = stringPreferencesKey(name = "language_key")

    suspend fun saveLanguage(context: Context, languageCode: String){
        context.dataSore.edit { preferences ->
            preferences[LANGUAGE_KEY] = languageCode
        }
    }

    fun getLanguage(context: Context): Flow<String> {
        return context.dataSore.data.map { preferences ->
            preferences[LANGUAGE_KEY] ?: "pt"
        }
    }

}