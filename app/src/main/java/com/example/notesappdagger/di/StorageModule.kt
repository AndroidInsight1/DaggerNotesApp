package com.example.notesappdagger.di

import com.example.notesappdagger.storage.SharedPreferenceHelper
import com.example.notesappdagger.storage.Storage
import dagger.Module
import dagger.Provides

@Module
class StorageModule {

    @Provides
    fun provideStorage(storage: SharedPreferenceHelper): Storage {
        return storage
    }
}

