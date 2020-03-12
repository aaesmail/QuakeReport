package com.example.android.quakereport;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    private static final String LOCATION_SEPARATOR = " of ";

    public EarthquakeAdapter(Activity context, List<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext())
                    .inflate(R.layout.list_item, parent, false);
        }

        Earthquake currentEarthquake = getItem(position);

        TextView textViews; // gonna use it to hold all text views and assign their texts

        // setting magnitude
        double magnitude = currentEarthquake.getMagnitude();

        textViews = listItemView.findViewById(R.id.magnitude);
        textViews.setText(formatMagnitude(magnitude));

        // setting color of Circle
        GradientDrawable magnitudeCircle = (GradientDrawable) textViews.getBackground();
        magnitudeCircle.setColor(getMagnitudeColor(magnitude));

        // getting location
        String location = currentEarthquake.getLocation();

        // setting the offset of location
        textViews = listItemView.findViewById(R.id.location_offset);
        textViews.setText(getLocationOffset(location));

        // setting the primary location
        textViews = listItemView.findViewById(R.id.primary_location);
        textViews.setText(getPrimaryLocation(location));

        // readying the date object to format it
        Date dateObject = new Date(currentEarthquake.getTimeInMS());

        // setting the date
        textViews = listItemView.findViewById(R.id.date);
        textViews.setText(formatDate(dateObject));

        // setting the time
        textViews = listItemView.findViewById(R.id.time);
        textViews.setText(formatTime(dateObject));

        return listItemView;
    }

    private String formatDate(Date dateObject)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy", Locale.US);

        return dateFormat.format(dateObject);
    }

    private  String formatTime(Date dateObject)
    {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a", Locale.US);

        return timeFormat.format(dateObject);
    }

    private String getLocationOffset(String location)
    {
        if (location.contains(LOCATION_SEPARATOR))
        {
            String[] parts = location.split(LOCATION_SEPARATOR);
            parts[0] += LOCATION_SEPARATOR;
            return parts[0];
        }

        return getContext().getString(R.string.near_the);
    }

    private String getPrimaryLocation(String location)
    {
        if (location.contains(LOCATION_SEPARATOR))
        {
            String[] parts = location.split(LOCATION_SEPARATOR);
            return parts[1];
        }

        return location;
    }

    private String formatMagnitude(double magnitude)
    {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return  magnitudeFormat.format(magnitude);
    }

    private int getMagnitudeColor(double magnitude)
    {
        int magnitudeColorResourceId;

        switch ((int)Math.floor(magnitude))
        {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;

            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;

            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;

            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;

            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;

            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;

            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;

            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;

            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;

            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }

        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }
}
