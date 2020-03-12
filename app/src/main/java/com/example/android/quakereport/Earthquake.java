package com.example.android.quakereport;


public class Earthquake {

    private double mMagnitude;   // Holds magnitude of earthquake
    private String mLocation;   // Location where earthquake occurred
    private long mTimeInMS;       // Holds Date when earthquake occurred ex: Feb 2, 2016
    private String mURL;           // Holds URL of site of earthquake

    public Earthquake(double magnitude, String location, long timeInMS, String URL) {
        mMagnitude = magnitude;
        mLocation = location;
        mTimeInMS = timeInMS;
        mURL = URL;
    }

    public double getMagnitude() {
        return mMagnitude;
    }

    public String getLocation() {
        return mLocation;
    }

    public long getTimeInMS() {
        return mTimeInMS;
    }

    public String getURL() {
        return mURL;
    }
}
