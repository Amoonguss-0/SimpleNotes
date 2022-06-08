package com.example.simplnotes.dao

import androidx.room.*
import com.example.simplnotes.entities.Notes

@Dao
interface NotesDao {
    @get:Query("SELECT * FROM notes ORDER BY id DESC")
    val allNotes: List<Notes>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNotes(note:Notes)

    @Delete
    fun deleteNote(note:Notes)
}