package com.example.helpcenterhome;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MenuAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    HelpCenter ma = new HelpCenter();
    ArrayList<Question> list = new ArrayList<>();
    public MenuAdapter(Context ctx)
    {
        this.context = ctx;
    }
    public void setItems(ArrayList<Question> ques)
    {
        list.addAll(ques);
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(context).inflate(R.layout.cradview,parent,false);
        return new QuestionVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Question q = null;
        this.onBindViewHolder(holder,position,q);
    }

    public void onBindViewHolder( RecyclerView.ViewHolder holder,int position ,Question q) {
        QuestionVH vh = (QuestionVH) holder;
        Question ques = q == null ? list.get(position) : q;
        vh.question_txt.setText(ques.getQuestion());
        vh.reply_txt.setText(
                ques.getReply().length() == 0 ? "Waiting for reply..." : ques.getReply()
        );
        vh.option_txt.setOnClickListener(ma.admin == 1 ? v ->
        {

            PopupMenu popupMenu = new PopupMenu(context, vh.option_txt);
            popupMenu.inflate(R.menu.option_menu);
            popupMenu.setOnMenuItemClickListener(item -> {
                switch (item.getItemId()) {
                    case R.id.menu_reply:
                        Intent intent = new Intent(context, ReplyScreen.class);
                        intent.putExtra("EDIT", ques);
                        context.startActivity(intent);
                        break;
                    case R.id.menu_remove:
                        DOAQuestion doa = new DOAQuestion();
                        doa.remove(ques.getKey()).addOnSuccessListener(suc -> {
                            Toast.makeText(context, "Remove Question", Toast.LENGTH_SHORT).show();
                            notifyItemRemoved(position);
                            list.remove(ques);

                        }).addOnFailureListener(er -> {
                            Toast.makeText(context, "" + er.getMessage(), Toast.LENGTH_SHORT).show();
                        });
                        break;
                }
                return false;
            });

            popupMenu.show();


        } : v -> {
            PopupMenu popupMenu = new PopupMenu(context, vh.option_txt);
            popupMenu.inflate(R.menu.option_menu);
            popupMenu.setOnMenuItemClickListener(item -> {
                switch (item.getItemId()) {
                    case R.id.menu_reply:
//                            Intent intent = new Intent(context, AskQuestion.class);
//                            intent.putExtra("EDIT", ques);
//                            context.startActivity(intent);
                        Toast.makeText(context, "Only Admin Can Reply", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_remove:
                        DOAQuestion doa = new DOAQuestion();
                        doa.remove(ques.getKey()).addOnSuccessListener(suc -> {
                            Toast.makeText(context, "Remove Question", Toast.LENGTH_SHORT).show();
                            notifyItemRemoved(position);
                            list.remove(ques);

                        }).addOnFailureListener(er -> {
                            Toast.makeText(context, "" + er.getMessage(), Toast.LENGTH_SHORT).show();
                        });
                        break;
                }
                return false;
            });

            popupMenu.show();

        });
    }
    @Override
    public int getItemCount() {
        return list.size();
    }
}
