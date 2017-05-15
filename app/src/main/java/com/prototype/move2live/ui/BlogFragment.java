package com.prototype.move2live.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.prototype.move2live.R;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by kt_ki on 2/7/2017.
 */

public class BlogFragment extends Fragment {
    String userName = "Kirtan";
    SignInActivity inActivity;
    BlogListAdapter listAdapter;
    UserDetailsForBlog userDetailsForBlog;
    ListView listView;
    EditText blogText;
    String timeOfPublushing;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.blog_layout , container , false);

        listView = (ListView) view.findViewById(R.id.lv_myBlogList);
        blogText = (EditText) view.findViewById(R.id.et_myBlog);
        userDetailsForBlog = new UserDetailsForBlog();

        inActivity = new SignInActivity();

        final List<UserDetailsForBlog> userDetailsForBlogList = new ArrayList<>();
        listAdapter = new BlogListAdapter(getContext(),R.layout.blog_list_layout,
                userDetailsForBlogList);
        listView.setAdapter(listAdapter);

        Button publish = (Button) view.findViewById(R.id.bt_publish);
        publish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                userDetailsForBlog.setName(inActivity.userName);
                userDetailsForBlog.setBlog(blogText.getText().toString().trim());
                userDetailsForBlog.setTime(DateFormat.getTimeInstance().format(new Date()));
                userDetailsForBlog.setDate(DateFormat.getDateInstance().format(new Date()));
                listAdapter.add(userDetailsForBlog);

                Toast.makeText(getContext(), "Published", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
