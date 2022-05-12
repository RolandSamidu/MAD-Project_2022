package com.example.helpcenterhome;


import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class QuestionVH extends RecyclerView.ViewHolder
{
        public TextView question_txt,reply_txt,option_txt;

        public QuestionVH(@NonNull View itemView) {
            super(itemView);
            question_txt =itemView.findViewById(R.id.questiontext);
            reply_txt =itemView.findViewById(R.id.replytext);

            option_txt =itemView.findViewById(R.id.optiontext);
        }
}