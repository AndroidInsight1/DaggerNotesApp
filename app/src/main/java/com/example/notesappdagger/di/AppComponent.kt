package com.example.notesappdagger.di

import android.content.Context
import com.example.notesappdagger.displaynotes.MainActivity
import com.example.notesappdagger.displaynotes.MainComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [StorageModule::class, AppSubComponents::class])
interface AppComponent {

    // Factory to create instances of the AppComponent
    @Component.Factory
    interface Factory {
        // With @BindsInstance, the Context passed in will be available in the graph
        fun create(@BindsInstance context: Context): AppComponent
    }

    // Types that can be retrieved from the graph
    fun mainComponent(): MainComponent.Factory
}