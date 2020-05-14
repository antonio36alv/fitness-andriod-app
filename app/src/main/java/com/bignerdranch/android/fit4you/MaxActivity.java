package com.bignerdranch.android.fit4you;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MaxActivity extends AppCompatActivity {

    private EditText mWeightUsedET;
    private EditText mRepsET;
    private TextView mResultsTextView;
    private Button mCalcResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_max);

        mWeightUsedET = findViewById(R.id.weight_used_ET);

        mRepsET = findViewById(R.id.reps_perf_ET);

        mResultsTextView = findViewById(R.id.max_rep_result_TV);
        mResultsTextView.setVisibility(View.GONE);

        mCalcResult = findViewById(R.id.calc_results_button);
        mCalcResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                        mResultsTextView.setText(getResources().getString(R.string.est_max_result,
                                                 estMax(Integer.parseInt(mWeightUsedET.getText().toString()),
                                                         Integer.parseInt(mRepsET.getText().toString()))));
                        mResultsTextView.setVisibility(View.VISIBLE);
            }
        });
    }

    private int estMax(int weight, int reps){
    /*5*(Math.floor(Math.abs(number/5)));*/
        return (int) (weight * reps * .0333) + weight;
        /*EST = (WEIGHT * REPS * .0333) + EST*/
    }
}
