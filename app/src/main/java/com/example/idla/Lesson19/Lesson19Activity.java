package com.example.idla.Lesson19;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.idla.R;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Lesson19Activity extends AppCompatActivity
{
    private ListView listView;
    private List<Note> notes;
    private ArrayList<HashMap<String,String>> maps = new ArrayList<HashMap<String,String>>();
    private SimpleAdapter simpleAdapter;
    private NoteDAO noteDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson19);
        listView = findViewById(R.id.listView);

        noteDAO = IDLADB.getDatabase(this).noteDAO();
        Log.d("MF❤️",getDatabasePath("idlaDB").getAbsolutePath());

        simpleAdapter = new SimpleAdapter(this,
                maps,
                android.R.layout.simple_list_item_2,
                new String[] {"time", "todo"},
                new int[] {android.R.id.text1,android.R.id.text2});

        getNoteFromDB();
    }

    private void getNoteFromDB()
    {
        notes = noteDAO.getAllNotesBy("mark");

        maps.clear();
        for(Note note: notes)
        {
            HashMap<String,String> map = new HashMap<String,String>();
            map.put( "time", note.time);
            map.put( "todo", note.todo);
            maps.add(map);
        }

        listView.setAdapter(simpleAdapter);
    }

    public void addNote(View view)
    {

        LayoutInflater layoutInflater = getLayoutInflater();
        final View viewLayout = layoutInflater.inflate(R.layout.alert_note_add,null);
        Dialog dialog = new AlertDialog.Builder(this)

                .setTitle("請記事")
                .setView(viewLayout)
                .setPositiveButton("好", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        EditText editText = viewLayout.findViewById(R.id.add_content);
                        String noteContent = String.valueOf(editText.getText());
                        Note newNote = new Note("mark",new Date().toString(),noteContent);
                        noteDAO.insert(newNote);

                        getNoteFromDB();
                    }
                })
                .setNegativeButton("等一下",null)
                .create();

        dialog.show();
    }
}
