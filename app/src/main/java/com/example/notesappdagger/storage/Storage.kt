package com.example.notesappdagger.storage

import com.example.notesappdagger.displaynotes.Notes

interface Storage {

    fun putJsonString(key: String, notes: ArrayList<Notes>)

    fun getJsonString(key: String?): ArrayList<Notes>?

}