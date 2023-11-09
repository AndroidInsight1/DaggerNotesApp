package com.example.notesappdagger.displaynotes

import com.example.notesappdagger.di.ActivityScope
import dagger.Subcomponent

@ActivityScope
@Subcomponent
interface MainComponent {

  @Subcomponent.Factory
  interface Factory {
      fun create():MainComponent
  }

  fun inject(activity: MainActivity)

}