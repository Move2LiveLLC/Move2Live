package com.prototype.move2live.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.TextViewCompat;
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

import org.w3c.dom.Text;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by kt_ki on 2/5/2017.
 */

public class ProfileFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profile_layout, container, false);
        TextView textView = (TextView) view.findViewById(R.id.proText);
        textView.setText("<User Name>");

        ImageView imageView = (ImageView) view.findViewById(R.id.imgTran);
        imageView.setImageResource(R.drawable.person_flat);

        // generate Dates
        Calendar calendar = Calendar.getInstance();
        Date d1 = calendar.getTime();
        calendar.add(Calendar.DATE, 1);
        Date d2 = calendar.getTime();
        calendar.add(Calendar.DATE, 1);
        Date d3 = calendar.getTime();

        GraphView graph = (GraphView) view.findViewById(R.id.graph);
        graph.setTitle("Daily Mood Graph");
        graph.setTitleColor(R.color.colorAccent);

// you can directly pass Date objects to DataPoint-Constructor
// this will convert the Date to double via Date#getTime()
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[]{
                new DataPoint(d1, 3),
                new DataPoint(d2, 4),
                new DataPoint(d3, 1)
        });

        graph.addSeries(series);

// set date label formatter
        graph.getGridLabelRenderer()
                .setLabelFormatter(new DateAsXAxisLabelFormatter(getActivity()));
        graph.getGridLabelRenderer()
                .setNumHorizontalLabels(3); // only 4 because of the space

// set manual x bounds to have nice steps
        graph.getViewport().setMinX(d1.getTime());
        graph.getViewport().setMaxX(d3.getTime());
        graph.getViewport().setXAxisBoundsManual(true);

// as we use dates as labels, the human rounding to nice readable numbers
// is not necessary
        graph.getGridLabelRenderer().setHumanRounding(false);

        TextView userView = (TextView) view.findViewById(R.id.profile_username);
        tempShowUsernameForDebug(userView);

        return view;
    }

    private void tempShowUsernameForDebug(TextView userView){
        SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        String defaultUsername = "Username";
        userView.setText(sharedPref.getString(getString(R.string.preference_username), defaultUsername));
    }
}
