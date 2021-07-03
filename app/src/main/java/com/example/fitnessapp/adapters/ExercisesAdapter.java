package com.example.fitnessapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fitnessapp.R;
import com.example.fitnessapp.model.Category;
import com.example.fitnessapp.model.Exercise;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

public class ExercisesAdapter extends RecyclerView.Adapter<ExercisesAdapter.MyViewHolder> {

    private StorageReference storageReference;
    private Context context;
    private List<Exercise> exercises;

    public ExercisesAdapter(Context context, ArrayList<Exercise> exercises) {
        this.context = context;
        this.exercises = exercises;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.exercise_item,parent,false);
        return new ExercisesAdapter.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ExercisesAdapter.MyViewHolder holder, int position) {
        Exercise exercise = exercises.get(position);
        //holder.textViewName.setText("Test");
    }

    @Override
    public int getItemCount() {
        return exercises.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView textViewName;
        ImageView imageView;
        LinearLayout linearLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            //textViewName = itemView.findViewById(R.id.category_name);
            //imageView = itemView.findViewById(R.id.image_category);
            //linearLayout = itemView.findViewById(R.id.exercise_item_ll);
        }

    }

}
