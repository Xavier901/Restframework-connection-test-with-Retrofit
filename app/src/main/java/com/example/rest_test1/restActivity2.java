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

public class restActivity2 extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      //  EdgeToEdge.enable(this);
        setContentView(R.layout.activity_rest2);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
        listView=(ListView) findViewById(R.id.rest_view);


        Retrofit.Builder builder=new Retrofit.Builder()
                .baseUrl("http://192.168.242.158:8000/api/")
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit=builder.build();

        rest_call client=retrofit.create(rest_call.class);

        Call<List<restData>> call=client.jsonrest("v1");

        call.enqueue(new Callback<List<restData>>() {
            @Override
            public void onResponse(Call<List<restData>> call, Response<List<restData>> response) {
                List<restData> restDataList =response.body();
                listView.setAdapter(new restDataadapter(restActivity2.this,restDataList));
            }

            @Override
            public void onFailure(Call<List<restData>> call, Throwable throwable) {

            }
        });



    }
}