package com.example.idla;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter
{
    private ArrayList lessons;

    public MainAdapter(ArrayList lessons)
    {
        this.lessons = lessons;
    }

    class CustViewHolder extends RecyclerView.ViewHolder
    {
        private CardView cardView;
        private ImageView imageViewIcon;
        private TextView textViewNo;
        private TextView textViewTitle;
        private TextView textViewDesc;

        public CustViewHolder(@NonNull View itemView)
        {
            super(itemView);
            cardView = (CardView) itemView;
            imageViewIcon = itemView.findViewById(R.id.lesson_icon);
            textViewNo = itemView.findViewById(R.id.lesson_no);
            textViewTitle = itemView.findViewById(R.id.lesson_title);
            textViewDesc = itemView.findViewById(R.id.lesson_desc);
        }

        void updateUI(Lesson lesson, int position)
        {
            textViewNo.setText(lesson.no);
            textViewTitle.setText(lesson.title);
            textViewDesc.setText(lesson.desc);
            switch (position % 4)
            {
                case 0:
                    cardView.setCardBackgroundColor(itemView.getContext().getColor(R.color.red));
                    break;
                case 1:
                    cardView.setCardBackgroundColor(itemView.getContext().getColor(R.color.yellow));
                    break;
                case 2:
                    cardView.setCardBackgroundColor(itemView.getContext().getColor(R.color.green));
                    break;
                case 3:
                    cardView.setCardBackgroundColor(itemView.getContext().getColor(R.color.blue));
                    break;
            }
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View cell = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_main,parent,false);
        return new CustViewHolder(cell);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position)
    {
        CustViewHolder custViewHolder = (CustViewHolder)holder;
        custViewHolder.updateUI((Lesson) lessons.get(position), position);

        custViewHolder.itemView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Log.d("MF",position + "被點");

                Context context = view.getContext();
                Lesson currentLesson = (Lesson) lessons.get(position);
                Intent intent = new Intent (context,currentLesson.activityClass);
                intent.putExtra("title",currentLesson.no + " - " + currentLesson.title);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return lessons.size();
    }
}
