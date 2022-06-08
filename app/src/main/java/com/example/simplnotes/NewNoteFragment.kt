package com.example.simplnotes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.navigation.fragment.findNavController

class NewNoteFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_note, container, false)
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            NewNoteFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val submitNote = view.findViewById<Button>(R.id.btn_submit)
        submitNote.setOnClickListener{
            findNavController().navigate(R.id.action_fragmentNoteNew_to_homeFragment)
        }

        fun saveNote(){
            val title = view.findViewById<EditText>(R.id.et_Title)
            val description = view.findViewById<EditText>(R.id.et_Desc)
            if (title.text.isNullOrEmpty()){
                Toast.makeText(context, "Title Required",Toast.LENGTH_SHORT).show()
            }
            if(description.text.isNullOrEmpty()){
                Toast.makeText(context, "Description Required",Toast.LENGTH_SHORT).show()
            }
        }
    }
}