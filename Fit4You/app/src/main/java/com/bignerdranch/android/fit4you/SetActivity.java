package com.bignerdranch.android.fit4you;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class SetActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sets);

        Intent intent = getIntent();
        //String filePath = extras.getString("FILE_KEY");
        RecyclerView recyclerView = findViewById(R.id.set_recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, intent.getIntExtra("SETS_NUMBER", 0));
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
