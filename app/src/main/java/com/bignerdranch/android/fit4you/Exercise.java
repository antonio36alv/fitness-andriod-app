package com.bignerdranch.android.fit4you;

import java.util.Locale;

public class Exercise {
//workout object would contain
    // ---------------------------exercise name, main or secondary movement boolean, number of sets
    private String mName;
    private boolean mMain;
    private int mNumberSets;

    public Exercise(String name, boolean main, int numberSets){
        mName = name;
        mMain = main;
        mNumberSets = numberSets;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public boolean ismMain() {
        return mMain;
    }

    public void setmMain(boolean mMain) {
        this.mMain = mMain;
    }

    public int getmNumberSets() {
        return mNumberSets;
    }

    public void setmNumberSets(int mNumberSets) {
        this.mNumberSets = mNumberSets;
    }

    public String toString(){
        //exercise name, main or secondary movement boolean, number of sets

        return String.format(Locale.getDefault(),
                "%s,%b,%d", mName, mMain, mNumberSets);
    }
}