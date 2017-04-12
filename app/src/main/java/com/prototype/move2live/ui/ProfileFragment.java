package com.prototype.move2live.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.helper.DateAsXAxisLabelFormatter;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.prototype.move2live.R;
import com.prototype.move2live.util.CircleTransform;
import com.squareup.picasso.Picasso;

import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kt_ki on 2/5/2017.
 */

public class ProfileFragment extends Fragment {

    @BindView(R.id.imgTran) ImageView profileImageView;
    @BindView(R.id.profile_username) TextView userTextView;
    @BindView(R.id.graph) GraphView graphView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profile_layout, container, false);
        ButterKnife.bind(this, view);

        // generate Dates
        Calendar calendar = Calendar.getInstance();
        Date d1 = calendar.getTime();
        calendar.add(Calendar.DATE, 1);
        Date d2 = calendar.getTime();
        calendar.add(Calendar.DATE, 1);
        Date d3 = calendar.getTime();

        graphView.setTitle("Daily Mood Graph");
        graphView.setTitleColor(R.color.colorAccent);

        // you can directly pass Date objects to DataPoint-Constructor
        // this will convert the Date to double via Date#getTime()
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[]{
                new DataPoint(d1, 3),
                new DataPoint(d2, 4),
                new DataPoint(d3, 1)
        });

        graphView.addSeries(series);

        // set date label formatter
        graphView.getGridLabelRenderer()
                .setLabelFormatter(new DateAsXAxisLabelFormatter(getActivity()));
        graphView.getGridLabelRenderer()
                .setNumHorizontalLabels(3); // only 4 because of the space

        // set manual x bounds to have nice steps
        graphView.getViewport().setMinX(d1.getTime());
        graphView.getViewport().setMaxX(d3.getTime());
        graphView.getViewport().setXAxisBoundsManual(true);

        // as we use dates as labels, the human rounding to nice readable numbers
        // is not necessary
        graphView.getGridLabelRenderer().setHumanRounding(false);

        getSocialNameAndPhoto();

        return view;
    }

    private void getSocialNameAndPhoto(){
        SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        String defaultUsername = "Username";
        String defaultPhotoUrl = "";

        userTextView.setText(sharedPref.getString(getString(R.string.preference_username), defaultUsername));
        String photoUrl = sharedPref.getString(getString(R.string.preference_photo_url), defaultPhotoUrl);

        if(photoUrl == "" || photoUrl == null){
            profileImageView.setImageResource(R.drawable.person_flat);
        }else {

            Picasso.with(getContext())
                    .load(photoUrl)
                    .transform(new CircleTransform())
                    .placeholder(R.drawable.person_flat)
                    .error(R.drawable.person_flat)
                    .into(profileImageView);
        }
    }
}
