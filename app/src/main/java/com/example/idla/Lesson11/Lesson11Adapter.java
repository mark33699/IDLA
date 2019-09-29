package com.example.idla.Lesson11;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.idla.R;

import java.util.ArrayList;

public class Lesson11Adapter extends RecyclerView.Adapter
{
    private ArrayList items;
    public Lesson11Adapter(ArrayList arrayList)
    {
        this.items = arrayList;
    }

    class CustViewHolder extends RecyclerView.ViewHolder
    {
        private TextView textViewName;
        private TextView textViewTitle;
        private TextView textViewBio;

        public CustViewHolder(@NonNull View itemView)
        {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewBio = itemView.findViewById(R.id.textViewBio);
        }

        void updateUI(Staff staff)
        {
            textViewName.setText(staff.name);
            textViewTitle.setText(staff.title);
            textViewBio.setText(staff.bio);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View cell = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_lesson11,parent,false);
        return new CustViewHolder(cell);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, final int position)
    {
        CustViewHolder custViewHolder = (CustViewHolder)holder;
        custViewHolder.updateUI((Staff) this.items.get(position));

        custViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("MF",position + "被點");
//                Toast.makeText(,position + "被點",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }
}
