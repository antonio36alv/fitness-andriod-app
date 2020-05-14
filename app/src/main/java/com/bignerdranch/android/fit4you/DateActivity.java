package com.bignerdranch.android.fit4you;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import java.io.*;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class DateActivity extends AppCompatActivity {

    private DatePicker mDatePicker;
    private Button mOkDate;

    public File file;
    public Scanner sc;
    private String dir = "//data//data//com.bignerdranch.android.fit4you//records";
private static final String FILE_KEY = "FILE_NAME";

    /*public FileReader fr;*/

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);

        //first time visiting this series of activities, we will make a directory for saving
        //our workout records, if it does not currently exist
        if(!new File(dir).exists()) {
            new File(dir).mkdir();
        }

        mDatePicker = findViewById(R.id.date_picker);

        mOkDate = findViewById(R.id.ok_date_button);
        mOkDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //construct date
                Date date = new Date(mDatePicker.getYear(),
                         mDatePicker.getMonth(),
                         mDatePicker.getDayOfMonth());
                try {
                    //if there is not a file under the same name we will allow this file to be written
                    //and will proceed to the next activity
                    if(!new File(String.format(Locale.getDefault(), "%s//workout_%d_%d_%d.txt",
                            dir, date.getMonth() + 1, date.getDate(), date.getYear())).exists()) {
                        //make new file
                        File file = new File(String.format(Locale.getDefault(), "%s//workout_%d_%d_%d.txt",
                                dir, date.getMonth() + 1, date.getDate(), date.getYear()));
                        file.createNewFile();
                        //set to second activity
                        Intent intent = new Intent(DateActivity.this, ExerciseActivity.class);
                        intent.putExtra(FILE_KEY, file.toString());
                        startActivity(intent);
                    } else {
                        Toast.makeText(DateActivity.this, "Select a new date. A workout already exists under this date.", Toast.LENGTH_SHORT).show();
                    }
                }catch(Exception e){
                    Toast.makeText(DateActivity.this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
                //workout object would contain
                // ---------------------------exercise name, main or secondary movement boolean, number of sets
                //set object would contain
                //------------------------set number #, weight used, reps done, heaviest/or not boolean
            }
        });
    }
}
