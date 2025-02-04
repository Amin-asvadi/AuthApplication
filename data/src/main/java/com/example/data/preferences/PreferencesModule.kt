package com.example.data.preferences

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import com.example.base_android.uiles.Constant.DS_NAME
import com.example.data.repository.local.DataStoreRepository
import com.example.data.repositoryimp.local.PreferencesStorage
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import java.io.File
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PreferencesModule {

    @Provides
    @Singleton
    fun provideDataStore(
        @ApplicationContext context: Context
    ): DataStore<Preferences> {
        return PreferenceDataStoreFactory.create(
            produceFile = {
                File(context.filesDir, DS_NAME)
            }
        )
    }
    @Provides
    @Singleton
    fun provideUserPreferences(
        preferencesStorage: PreferencesStorage
    ): DataStoreRepository = preferencesStorage
}