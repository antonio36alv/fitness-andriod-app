package com.bignerdranch.android.fit4you;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button mNewWorkoutButton;
    private Button mMaxCalcButton;
    private TextView mEmptyTextView;

    private RecyclerView mWorkoutRecyclerView;
    /*private WorkoutAdapter mAdapter;*/

    /*private ArrayList<Workout> workouts;

     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mNewWorkoutButton = findViewById(R.id.new_workout_button);
        mNewWorkoutButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //here we will advance to new workout activity
                startActivity(new Intent(MainActivity.this, DateActivity.class));
            }
        });

        mMaxCalcButton = findViewById(R.id.max_calc_button);
        mMaxCalcButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //here we will advance to the estimated max calculator activity
                startActivity(new Intent(MainActivity.this, MaxActivity.class));
            }
        });

        mEmptyTextView = findViewById(R.id.empty_text_view);
        /*
        if there are workouts logged make this invisible
        mEmptyTextView.setVisibility(View.GONE);
         */

    }
}
