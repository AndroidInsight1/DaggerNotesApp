package com.example.notesappdagger.di

import com.example.notesappdagger.displaynotes.MainComponent
import dagger.Module

@Module(
subcomponents = [
     MainComponent::class
]
)

class AppSubComponents
