package com.bignerdranch.android.fit4you;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class ExerciseActivity extends AppCompatActivity {

    private EditText mExerciseName;
    private EditText mNumberSets;
    private CheckBox mMainCheck;
    private Button mOkExerciseButton;
    private EditText mNotes;
    private Button mSaveWorkoutButton;

    private static final String KEY = "ExerciseActivity";

    private StringBuilder notes = new StringBuilder();

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        mNotes = findViewById(R.id.notes_ET);
        //need to save as we keep recording exercises, need to carryover

        if(savedInstanceState!=null){
            mNotes.setText(savedInstanceState.getString(KEY));
            notes.append(savedInstanceState.getString(KEY));
        }
        mExerciseName = findViewById(R.id.exercise_ET);

        mNumberSets = findViewById(R.id.number_sets_ET);

        mMainCheck = findViewById(R.id.main_move_check);

        mOkExerciseButton = findViewById(R.id.ok_exercise_button);
        mOkExerciseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //boolean to be passed into exercise to determine whether
                // or not it is a main movement, opposed to a secondary, by default false
                boolean mainMovement = false;
                if(mMainCheck.isChecked()) {
                    //if the user states it is a main movement then we will make it so
                     mainMovement = true;
                }
                //pass details into exercise object
                Exercise exercise = new Exercise(mExerciseName.getText().toString(), mainMovement,
                                                 Integer.parseInt(mNumberSets.getText().toString()));
                //we will retrieve the filename/path in order to write to it
                //comes from date activity, will be a workout date the user picked
                Intent intent = getIntent();
                File file = new File(intent.getStringExtra("FILE_NAME"));
                try{
                    PrintWriter pw = new PrintWriter(file);
                    //using the exercise object to string method we will write the
                    //details we passed into exercise
                    pw.println(exercise);
                    pw.close();
                    //TODO toast for making certain it worked, should probably get rid of
                    Toast.makeText(ExerciseActivity.this, "Done did it", Toast.LENGTH_SHORT).show();
                } catch (IOException e){
                    //incase we have an exception catched, toast the error message
                    Toast.makeText(ExerciseActivity.this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
                //check to see if anything was written in notes
                //if there has append to stringbuilder
                if (!mNotes.equals("")) {
                    notes.append(mNotes.getText().toString() + " ");
                }
                Intent toSetActivity = new Intent(ExerciseActivity.this, SetActivity.class);
                toSetActivity.putExtra("FILE_KEY", intent.getStringExtra("FILE_NAME"));
                toSetActivity.putExtra("SETS_NUMBER", exercise.getmNumberSets());
                //intent.putExtras(extraBundle);
                startActivity(toSetActivity);
            }

        });

        mSaveWorkoutButton = findViewById(R.id.save_workout_button);
        mSaveWorkoutButton.setEnabled(false);
        mSaveWorkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //will end workout log and save it
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        if (!notes.equals("")) {
            savedInstanceState.putString(KEY, notes.toString());
        }
    }
}
