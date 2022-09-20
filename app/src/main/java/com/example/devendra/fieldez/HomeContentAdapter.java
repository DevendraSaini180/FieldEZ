package com.example.devendra.fieldez;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class HomeContentAdapter extends ArrayAdapter<String> {

    private final Context mContext;
    private final String[] mTitle;

    public HomeContentAdapter(@NonNull Context context, String[] titles) {
        super(context, R.layout.home_content_layout, titles);
        this.mContext = context;
        this.mTitle = titles;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View currentItemView = convertView;

        if (currentItemView == null) {
            currentItemView = LayoutInflater.from(mContext).inflate(R.layout.home_content_layout, parent, false);
        }

        TextView titleText = currentItemView.findViewById(R.id.textViewTitle);
        titleText.setText(mTitle[position]);

        ImageView circleDrawable = currentItemView.findViewById(R.id.solidDrawable);
        if (position == 2 || position == 3) {
            circleDrawable.setImageResource(R.drawable.solid_orange_circular_drawable);
        }

        return currentItemView;
    }


}
