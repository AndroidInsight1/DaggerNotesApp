package com.example.notesappdagger.displaynotes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.notesappdagger.storage.SharedPreferenceHelper
import com.example.notesappdagger.storage.Storage
import com.example.notesappdagger.utils.GlobalUtils.notesList
import javax.inject.Inject

private const val ADD_NOTES = "add_notes"

class MainViewModel @Inject constructor(private val storage: Storage) : ViewModel() {

    private var notesMutableLiveData = MutableLiveData<ArrayList<Notes>>()
    val notesLiveData : LiveData<ArrayList<Notes>>
        get() = notesMutableLiveData

    init {
        checkStorage()
    }

    private fun checkStorage(){
        if(storage.getJsonString(ADD_NOTES)?.isEmpty() == false){
            notesList = storage.getJsonString(ADD_NOTES)!!
            notesMutableLiveData.value = notesList
        }
    }

    fun addNotes(){
        storage.putJsonString(ADD_NOTES, notesList)
        notesMutableLiveData.value = notesList
    }

    fun removeNotes(notes: Notes){
        notesList.remove(notes)
        storage.putJsonString(ADD_NOTES, notesList)
        notesMutableLiveData.value = notesList
    }

}