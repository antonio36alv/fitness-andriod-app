package com.bignerdranch.android.fit4you;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private static final String KEY = "RecyclerViewAdapterSets";
    private int mNumberOfSets;
    private ArrayList<Set> mSets = new ArrayList();
    private Context mContext;

    public RecyclerViewAdapter(Context context, int numberOfSets){
        mContext = context;
        mNumberOfSets = numberOfSets;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView mSetsNumber;
        private EditText mWeightUsedSetET;
        private EditText mRepsPerfSetET;
        private LinearLayout mRecylerViewSet;

        public ViewHolder(View itemView) {
            super(itemView);

            mSetsNumber = itemView.findViewById(R.id.set_number_weight_used);

            mWeightUsedSetET = itemView.findViewById(R.id.set_weight_used_ET);

            mRepsPerfSetET = itemView.findViewById(R.id.set_reps_perf_ET);

            mRecylerViewSet = itemView.findViewById(R.id.set_recycler_view);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.set_list_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.d(KEY, "onBindViewHolder: called");

        //Resources res = holder.itemView.getContext().getResources();
        holder.mSetsNumber.setText(holder.itemView.getResources().getString(R.string.set_number_weight_used, position +1));
    }

    @Override
    public int getItemCount() {
        return mNumberOfSets;
    }
}
