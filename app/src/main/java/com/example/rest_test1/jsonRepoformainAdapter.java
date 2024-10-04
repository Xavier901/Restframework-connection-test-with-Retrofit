package com.example.rest_test1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class jsonRepoformainAdapter extends ArrayAdapter<JsonRepoformain> {



    Context context;
    List<JsonRepoformain>objects;
    public jsonRepoformainAdapter(@NonNull Context context, @NonNull List<JsonRepoformain> objects) {
        super(context, R.layout.main_listview_layout, objects);

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
            row = inflater.inflate(R.layout.main_listview_layout, parent, false);
        }

        TextView idx = (TextView) row.findViewById(R.id.idx);
        TextView auther = (TextView) row.findViewById(R.id.auther);
        TextView title = (TextView) row.findViewById(R.id.title);
        TextView body = (TextView) row.findViewById(R.id.body);

        JsonRepoformain item = objects.get(position);

        String id =Integer.toString( item.getId());
        idx.setText( id);
        String user_id=Integer.toString(item.getUserId());
        auther.setText( user_id);
        title.setText(item.getTitle());
        body.setText(item.getBody());

        return row;

    }
}
