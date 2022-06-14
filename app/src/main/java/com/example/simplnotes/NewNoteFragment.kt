package com.example.simplnotes

import android.os.Bundle
import android.provider.ContactsContract
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.simplnotes.adapter.RecycleAdapter

class NewNoteFragment : Fragment() {
    private var layoutManager: LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecycleAdapter.ViewHolder>? = null

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

        fun saveNote(){
            var arrList = ArrayList<String>()
            var Description = view.findViewById<EditText>(R.id.etDesc)
            var NoteList = view.findViewById<RecyclerView>(R.id.rv1)
            val myAdapter = RecycleAdapter(this,arrList)



            if(Description.text.isNullOrEmpty()){
                Toast.makeText(context, "Description Required",Toast.LENGTH_SHORT).show()
            }
            else{
                arrList.add(Description.text.toString())
                myAdapter.notifyDataSetChanged()
            }
            NoteList.adapter = myAdapter
        }
        val submitNote = view.findViewById<Button>(R.id.btnsubmit)
        submitNote.setOnClickListener{
            findNavController().navigate(R.id.action_fragmentNoteNew_to_homeFragment)
            saveNote()
        }
    }
}