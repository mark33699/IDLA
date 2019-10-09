package com.example.idla.Lesson19;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Note.class}, version = 1)//版本是要幹嘛的？
public abstract class IDLADB extends RoomDatabase
{
    private static IDLADB INSTANCE;

    public abstract NoteDAO noteDAO();

    public static IDLADB getDatabase(Context context)
    {
        if (INSTANCE == null)
        {
            INSTANCE = Room.databaseBuilder(context,IDLADB.class,"idlaDB")
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }

    public static void destoryInstance()
    {
        if (INSTANCE != null)
            INSTANCE.close();
        INSTANCE = null;
    }

}
