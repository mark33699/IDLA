package com.example.idla.Lesson19;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "note_t")
public class Note
{
    @PrimaryKey(autoGenerate = true)
    public int uid;
    public String user;
    public String time;
    public String todo;

    public Note(String user, String time, String todo)
    {
        this.user = user;
        this.time = time;
        this.todo = todo;
    }
}

