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



public class restDataadapter extends ArrayAdapter<restData> {
    Context context;
    List<restData> objects;
    public restDataadapter(@NonNull Context context, @NonNull List<restData> objects) {
        super(context, R.layout.rest_body, objects);
        this.context = context;
        this.objects = objects;
    }



        @NonNull
        @Override
        public View getView ( int position, @Nullable View convertView, @NonNull ViewGroup parent){

        View row = convertView;

        if (row == null) {
            LayoutInflater inflater =
                    (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.rest_body, parent, false);
        }


        restData item = objects.get(position);

        TextView body = (TextView) row.findViewById(R.id.restbody);
        body.setText(item.getBody());

        return row;
    }


}

