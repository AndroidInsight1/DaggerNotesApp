package com.example.notesappdagger.displaynotes

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.notesappdagger.MyApplication
import com.example.notesappdagger.R
import com.example.notesappdagger.addnotes.AddNotesActivity
import com.example.notesappdagger.utils.GlobalUtils.notesList
import com.google.android.material.floatingactionbutton.FloatingActionButton
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory
    private lateinit var viewModel: MainViewModel

    private var viewManager = LinearLayoutManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as MyApplication).appComponent.mainComponent().create().inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        /** By default, ViewModelProvider knows how to instantiate the ViewModels that have no arguments.
         * If ViewModel has arguments - without this mainViewModelFactory, ViewModelProvider doesn't
         * know how to give an instance */
        viewModel = ViewModelProvider(this, mainViewModelFactory)[MainViewModel::class.java]

        val fab = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        fab.setOnClickListener {
            startActivity(Intent(this@MainActivity, AddNotesActivity::class.java))
        }

        callAdapter()
    }

    override fun onStart() {
        super.onStart()
        if(notesList.size > 0){
            viewModel.addNotes()
        }
    }

    private fun callAdapter() {
        recyclerView.layoutManager = viewManager
        observeData()
    }

    private fun observeData(){
        viewModel.notesLiveData.observe(this, Observer{
            recyclerView.adapter = MainAdapter(viewModel,this)
        })
    }
}