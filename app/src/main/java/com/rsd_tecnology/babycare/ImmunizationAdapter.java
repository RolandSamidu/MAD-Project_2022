package com.rsd_tecnology.babycare;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class ImmunizationAdapter extends FirebaseRecyclerAdapter<ImmunizationModel,ImmunizationAdapter.myViewHolder> {

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public ImmunizationAdapter(@NonNull FirebaseRecyclerOptions<ImmunizationModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull ImmunizationModel model) {
        holder.immunization.setText(model.getImmunization());
        holder.place.setText(model.getPlace());
        holder.date.setText(model.getDate());

    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.immunization_item, parent, false);
        return new myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder{

        TextView immunization,place,date;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            immunization = (TextView)itemView.findViewById(R.id.text_immunization);
            place = (TextView)itemView.findViewById(R.id.text_place);
            date = (TextView)itemView.findViewById(R.id.text_date);
        }
    }
}
