package com.rsd_tecnology.babycare;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.HashMap;
import java.util.Map;

public class ImmunizationAdapter extends FirebaseRecyclerAdapter<ImmunizationModel,ImmunizationAdapter.myViewHolder> {

    private int position;

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
    protected void onBindViewHolder(@NonNull myViewHolder holder, @SuppressLint("RecyclerView") final int position, @NonNull ImmunizationModel model) {
        holder.immunization.setText(model.getImmunization());
        holder.place.setText(model.getPlace());
        holder.date.setText(model.getDate());

        //Updated Part

        holder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final DialogPlus dialogPlus = DialogPlus.newDialog(holder.immunization.getContext())
                        .setContentHolder(new ViewHolder(R.layout.update_popup))
                        .setExpanded(true,1200)
                        .create();

                View view = dialogPlus.getHolderView();

                EditText immunization = view.findViewById(R.id.text_immunization);
                EditText place = view.findViewById(R.id.text_place);
                EditText date = view.findViewById(R.id.text_date);

                Button btnUpdate = view.findViewById(R.id.btnUpdate);

                immunization.setText(model.getImmunization());
                place.setText(model.getPlace());
                date.setText(model.getDate());

                dialogPlus.show();

                btnUpdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Map<String,Object> map = new HashMap<>();
                        map.put("immunization",immunization.getText().toString());
                        map.put("place",place.getText().toString());
                        map.put("date",date.getText().toString());

                        FirebaseDatabase.getInstance().getReference().child("immunizations")
                                .child(getRef(position).getKey()).updateChildren(map)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        Toast.makeText(holder.immunization.getContext(), "Updated Successfully!", Toast.LENGTH_SHORT).show();
                                        dialogPlus.dismiss();
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(holder.immunization.getContext(), "Error while Updating", Toast.LENGTH_SHORT).show();
                                    }
                                });
                    }
                });
            }
        });

        // Delete Immunization Details

        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(holder.immunization.getContext());
                builder.setTitle("Are you Sure?");
                builder.setMessage("Deleted Data can't be Undo.");

                builder.setPositiveButton("Deleted", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        FirebaseDatabase.getInstance().getReference().child("immunizations")
                                .child(getRef(position).getKey()).removeValue();
                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(holder.immunization.getContext(), "Cancel", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.show();

            }
        });

    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.immunization_item, parent, false);
        return new myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder{

        TextView immunization,place,date;
        Button btnEdit,btnDelete;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            immunization = (TextView)itemView.findViewById(R.id.text_immunization);
            place = (TextView)itemView.findViewById(R.id.text_place);
            date = (TextView)itemView.findViewById(R.id.text_date);

            btnEdit = (Button)itemView.findViewById(R.id.btnEdit);
            btnDelete = (Button)itemView.findViewById(R.id.btnDelete);
        }
    }
}
