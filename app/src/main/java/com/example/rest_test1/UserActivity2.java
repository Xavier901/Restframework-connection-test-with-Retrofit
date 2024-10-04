package com.example.rest_test1;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UserActivity2 extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_user2);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
        listView=(ListView) findViewById(R.id.user_list_view);
        Retrofit.Builder builder=new Retrofit.Builder()
                //.baseUrl("http://192.168.242.158:8000/")
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit=builder.build();

        rest_call client=retrofit.create(rest_call.class);
        Call<List<User>> call=client.jsonForusers("users");

        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                Toast.makeText(UserActivity2.this, "Connected: "+response.message(), Toast.LENGTH_SHORT).show();
                List<User>userL=response.body();
                listView.setAdapter(new userAdapter(UserActivity2.this,userL));
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable throwable) {
                Toast.makeText(UserActivity2.this, "Error: "+throwable.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}