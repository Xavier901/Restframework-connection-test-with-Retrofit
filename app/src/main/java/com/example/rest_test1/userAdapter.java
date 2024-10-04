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

public class userAdapter extends ArrayAdapter<User> {
    Context context;
    List<User> objects;

    public userAdapter(@NonNull Context context, @NonNull List<User> objects) {
        super(context, R.layout.user_list, objects);
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
            row = inflater.inflate(R.layout.user_list, parent, false);
        }

        TextView Userid          = (TextView) row.findViewById(R.id.userid);
        TextView Name            = (TextView) row.findViewById(R.id.name);
        TextView User_name       = (TextView) row.findViewById(R.id.username);
        TextView Email           = (TextView) row.findViewById(R.id.email);
        TextView Street          = (TextView) row.findViewById(R.id.street);
        TextView Suite           = (TextView) row.findViewById(R.id.suite);
        TextView City            = (TextView) row.findViewById(R.id.city);
        TextView Zipcode         = (TextView) row.findViewById(R.id.zipcode);
        TextView Lat             = (TextView) row.findViewById(R.id.lat);
        TextView Lng             = (TextView) row.findViewById(R.id.lng);
        TextView Phone           = (TextView) row.findViewById(R.id.phone);
        TextView Website         = (TextView) row.findViewById(R.id.website);
        TextView C_name          = (TextView) row.findViewById(R.id.company_name);
        TextView C_phraze        = (TextView) row.findViewById(R.id.catch_pherse);
        TextView bs              = (TextView) row.findViewById(R.id.bs);


        User item = objects.get(position);


        String user_id =Integer.toString( item.getId());



        Userid.setText( user_id);
        Name.setText( item.getName());
        User_name.setText(item.getUsername());
        Email.setText(item.getEmail());
        Street.setText(item.getAddress().getStreet());
        Suite.setText(item.getAddress().getSuite());
        City.setText(item.getAddress().getCity());
        Zipcode.setText(item.getAddress().getZipcode());
        Lat.setText(item.getAddress().getGeo().getLat());
        Lng.setText(item.getAddress().getGeo().getLng());
        Phone.setText(item.getPhone());
        Website.setText(item.getWebsite());
        C_name.setText(item.getCompany().getName());
        C_phraze.setText(item.getCompany().getCatchPhrase());
        bs.setText(item.getCompany().getBs());

        return row;
    }
}
