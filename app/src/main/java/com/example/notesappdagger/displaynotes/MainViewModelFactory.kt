package com.example.notesappdagger.displaynotes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

import com.example.notesappdagger.storage.SharedPreferenceHelper
import javax.inject.Inject
import javax.inject.Provider

/** If you use factories, then we must know the best practice would be using Provider. Provider will
 *  ensure that whenever I create new MainViewModel, We will be using the
 *  new instance(get() method -SharedPreferenceHelper)
 */

class MainViewModelFactory @Inject constructor(
    private val sharedPreferenceHelperProvider: Provider<SharedPreferenceHelper>
    ): ViewModelProvider.Factory{

    /** Create a new instance of the given Class
     *  @param modelClass a 'Class' whose instance is requested
     *  @return a newly created ViewModel
     * */

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        /** get() -> Provide a fully constructed and injected instance of T */
        return MainViewModel(sharedPreferenceHelperProvider.get()) as T
    }
}