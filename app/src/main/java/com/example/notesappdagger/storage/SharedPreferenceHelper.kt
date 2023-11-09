package com.example.notesappdagger.storage

import android.content.Context
import com.example.notesappdagger.displaynotes.Notes
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import javax.inject.Inject

private const val ADD_NOTES = "add_notes"

class SharedPreferenceHelper @Inject constructor(context: Context) : Storage {

    private var sharedPreferences = context.getSharedPreferences(
        "NOTES_STORAGE", Context.MODE_PRIVATE)

    override fun putJsonString(key: String, notesList: ArrayList<Notes>) {
        with(sharedPreferences.edit()){
            val json = Gson().toJson(notesList)
            putString(key, json)
            apply()
        }
    }

    override fun getJsonString(key: String?): ArrayList<Notes>? {

        /** below line is to get the string present from our shared preferences, if not available in
         *  sharedpreference then setting it as null
              */

        val json = sharedPreferences.getString(key, null)
        val type = object: TypeToken<ArrayList<Notes?>?>() {}.type

        return Gson().fromJson(json, type)
    }
}