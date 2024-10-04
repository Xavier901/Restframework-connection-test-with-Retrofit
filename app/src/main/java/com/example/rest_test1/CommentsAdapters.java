package com.example.rest_test1;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;


public class CommentsAdapters extends ArrayAdapter<Comments> {

    Context context;
    List<Comments> objects;
    public CommentsAdapters(@NonNull Context context, @NonNull List<Comments> objects) {
        super(context, R.layout.activity_comments2, objects);
        this.context=context;
        this.objects=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View row = convertView;

        if (row == null) {
            LayoutInflater inflater =
                    (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.comment_view_layout, parent, false);
        }

        TextView postid         = (TextView) row.findViewById(R.id.postid);
        TextView comment_id     = (TextView) row.findViewById(R.id.comment_id);
        TextView comment_name   = (TextView) row.findViewById(R.id.comment_name);
        TextView commentor_email= (TextView) row.findViewById(R.id.commentor_email);
        TextView commentor_body = (TextView) row.findViewById(R.id.commentor_body);

        Comments item = objects.get(position);


        String post_id =Integer.toString( item.getPostId());
        String comme=Integer.toString(item.getcommentId());



        postid.setText( post_id);
        comment_id.setText( comme);
        comment_name.setText(item.getName());
        commentor_email.setText(item.getEmail());
        commentor_body.setText(item.getBody());


        return row;
    }
}
