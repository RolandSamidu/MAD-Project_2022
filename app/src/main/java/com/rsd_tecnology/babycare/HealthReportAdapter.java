package com.rsd_tecnology.babycare;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class HealthReportAdapter extends FirebaseRecyclerAdapter<HealthReportModel, HealthReportAdapter.myViewHolder> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public HealthReportAdapter(@NonNull FirebaseRecyclerOptions<HealthReportModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull HealthReportModel model) {
        holder.date.setText(model.getDate());
        holder.topic.setText(model.getTopic());
        holder.description.setText(model.getDescription());
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.health_details,parent,false);
        return new myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder{

        TextView date,topic,description;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            date = (TextView) itemView.findViewById(R.id.date);
            topic = (TextView) itemView.findViewById(R.id.text_topic);
            description = (TextView) itemView.findViewById(R.id.text_description);
        }
    }
}
