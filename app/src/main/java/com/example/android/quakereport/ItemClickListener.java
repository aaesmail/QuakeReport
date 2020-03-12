package com.example.android.quakereport;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;

public class ItemClickListener implements AdapterView.OnItemClickListener {

    private Context mContext;
    private EarthquakeAdapter mEarthquakeAdapter;

    public ItemClickListener(Context context, EarthquakeAdapter earthquakeAdapter) {
        super();

        mContext = context;
        mEarthquakeAdapter = earthquakeAdapter;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String url = mEarthquakeAdapter.getItem(position).getURL();
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        mContext.startActivity(i);
    }
}
