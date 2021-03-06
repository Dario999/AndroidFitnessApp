package com.example.fitnessapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.fitnessapp.adapters.CategoriesAdapter;
import com.example.fitnessapp.adapters.ExercisesAdapter;
import com.example.fitnessapp.model.Category;
import com.example.fitnessapp.model.Exercise;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ExercisesActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DatabaseReference databaseReference;
    private StorageReference storageReference;
    private ExercisesAdapter exercisesAdapter;
    private ArrayList<Exercise> exercises;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises);

        recyclerView = findViewById(R.id.exercises_rv);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        databaseReference = FirebaseDatabase.getInstance().getReference("Exercises");

        exercises = new ArrayList<>();



        String position;
        Bundle extras = getIntent().getExtras();
        if(extras == null) {
            position = null;
        } else {
            position = extras.getString("position");
        }
//        ArrayList<Exercise> temp = new ArrayList<>();
//        for(Exercise e : exercises){
//            if(e.getName().equals("Test")){
//                temp.add(e);
//            }
//        }

        exercisesAdapter = new ExercisesAdapter(this,exercises);
        recyclerView.setAdapter(exercisesAdapter);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Exercise exercise = dataSnapshot.getValue(Exercise.class);
                    if(exercise.getCategory() != null && exercise.getCategory().toString().equals(position)){
                        exercises.add(exercise);
                    }
                }
                exercisesAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}