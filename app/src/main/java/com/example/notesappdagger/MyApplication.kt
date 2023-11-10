package com.example.notesappdagger

import android.app.Application
import com.example.notesappdagger.di.AppComponent
import com.example.notesappdagger.di.DaggerAppComponent


open class MyApplication : Application(){

    // Instance of the AppComponent that will be used by all the Activities in the project
    val appComponent: AppComponent by lazy {
        initializeComponent()
    }

    open fun initializeComponent(): AppComponent {
        // Creates an instance of AppComponent using its Factory constructor
        // We pass the applicationContext that will be used as Context in the graph
        dfgdfgdfgdg
        return DaggerAppComponent.factory().create(applicationContext)
    }
}