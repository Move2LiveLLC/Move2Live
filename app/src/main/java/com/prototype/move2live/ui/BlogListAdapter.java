package com.prototype.move2live.ui;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.prototype.move2live.R;

import java.util.List;

/**
 * Created by kt_ki on 5/10/2017.
 */

public class BlogListAdapter extends ArrayAdapter<UserDetailsForBlog> {

    public BlogListAdapter(@NonNull Context context, @LayoutRes int resource,
                           List<UserDetailsForBlog> object) {
        super(context, resource, object);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null){
            convertView =
                    ((Activity) getContext())
                            .getLayoutInflater().inflate(R.layout.blog_list_layout,parent,false);
        }

        TextView nameText = (TextView) convertView.findViewById(R.id.tv_name);
        TextView blogText = (TextView) convertView.findViewById(R.id.tv_blog);
        TextView timeText = (TextView) convertView.findViewById(R.id.tv_time);
        TextView dateText = (TextView) convertView.findViewById(R.id.tv_date);
        ImageView profileImage = (ImageView) convertView.findViewById(R.id.iv_profilePic);

        UserDetailsForBlog detailsForBlog = getItem(position);

        if (detailsForBlog != null) {
            nameText.setText(detailsForBlog.getName());
            blogText.setText(detailsForBlog.getBlog());
            dateText.setText(detailsForBlog.getDate());
            timeText.setText(detailsForBlog.getTime());
        }

        return convertView;
    }
}
