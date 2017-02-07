package com.example.kt_ki.move2live;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by kt_ki on 2/5/2017.
 */

public class ProfileFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profile_layout,container , false);
        TextView textView = (TextView) view.findViewById(R.id.proText);
        textView.setText(R.string.hello_blank_fragment);
        return view;
    }
}
