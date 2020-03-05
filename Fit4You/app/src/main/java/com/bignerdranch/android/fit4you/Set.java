package com.bignerdranch.android.fit4you;

import java.util.Locale;

public class Set {
    //set object would contain
    //------------------------set number #, weight used, reps done, heaviest/or not boolean
    private int mNumberSets;
    private int mWeightUsed;
    private int mRepsDone;
    private boolean mHeaviestSet;

    public int getmNumberSets() {
        return mNumberSets;
    }

    public void setmNumberSets(int mNumberSets) {
        this.mNumberSets = mNumberSets;
    }
    public int getmWeightUsed() {
        return mWeightUsed;
    }

    public void setmWeightUsed(int mWeightUsed) {
        this.mWeightUsed = mWeightUsed;
    }

    public int getmRepsDone() {
        return mRepsDone;
    }

    public void setmRepsDone(int mRepsDone) {
        this.mRepsDone = mRepsDone;
    }

    public boolean ismHeaviestSet() {
        return mHeaviestSet;
    }

    public void setmHeaviestSet(boolean mHeaviestSet) {
        this.mHeaviestSet = mHeaviestSet;
    }

    public StringBuilder toStringBuilder(){
        StringBuilder sb = new StringBuilder();
        //we will write a line describing each set as follows vv
        //set number #, weight used, reps done, heaviest/or not boolean
        //then will "newline"
        for(int x = 0; x <= mNumberSets; x++){
            sb.append(String.format(Locale.getDefault(),
                      "Set number %d,%d,%d,%b\n", x, mWeightUsed, mRepsDone, mHeaviestSet));
        }
        return sb;
    }

    public String toString(){
        return "jawn";
    }
}
