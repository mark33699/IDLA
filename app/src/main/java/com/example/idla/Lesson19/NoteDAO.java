package com.example.idla.Lesson19;

import android.content.Context;

import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.List;

@Dao
public interface NoteDAO
{
    @Insert
    public void insert(Note note);

    @Query("SELECT * FROM note_t WHERE user = :user")
    List<Note> getAllNotesBy(String user);
}

