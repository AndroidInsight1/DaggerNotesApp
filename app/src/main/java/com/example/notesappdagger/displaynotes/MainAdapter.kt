package com.example.notesappdagger.displaynotes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.notesappdagger.R
import com.example.notesappdagger.utils.GlobalUtils.notesList

class MainAdapter(
    val viewModel: MainViewModel,
    private val context: Context
) : RecyclerView.Adapter<MainAdapter.NotesViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_main, parent, false)
        return NotesViewHolder(view)
    }

    override fun getItemCount(): Int {
        if(notesList.size == 0){
            Toast.makeText(context, "List is empty", Toast.LENGTH_SHORT).show()
        }
        return notesList.size
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        holder.bind(notesList[position])
    }

    inner class NotesViewHolder(private val binding: View): RecyclerView.ViewHolder(binding) {

        fun bind(notes: Notes){
            binding.findViewById<TextView>(R.id.tv_date).text = notes.date
            binding.findViewById<TextView>(R.id.tv_title).text = notes.title
            binding.findViewById<TextView>(R.id.tv_description).text = notes.description

            val deleteImg = binding.findViewById<ImageView>(R.id.iv_delete)

            deleteImg.setOnClickListener{
                viewModel.removeNotes(notes)
                notifyItemChanged(notesList.indexOf(notes))
            }

        }

    }

}