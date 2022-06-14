package com.example.simplnotes.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.simplnotes.NewNoteFragment
import com.example.simplnotes.R
import com.example.simplnotes.entities.Notes

class RecycleAdapter(private val context: NewNoteFragment, private val arrList: ArrayList<String>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent ,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return arrList.count()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.etDesc).text = arrList[position]
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var itemDescription: TextView

        init{
            itemDescription = itemView.findViewById(R.id.item_desc)
        }
    }
}