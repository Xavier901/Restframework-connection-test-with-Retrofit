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

public class PostActivity2 extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_post2);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });

        listView=(ListView) findViewById(R.id.post_listView);
        Retrofit.Builder builder=new Retrofit.Builder()
                //.baseUrl("http://192.168.242.158:8000/")
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit=builder.build();

        rest_call client=retrofit.create(rest_call.class);
        Call<List<JsonRepoformain>> call=client.jsonreposForUser("posts");

        call.enqueue(new Callback<List<JsonRepoformain>>() {
            @Override
            public void onResponse(Call<List<JsonRepoformain>> call, Response<List<JsonRepoformain>> response) {
                Toast.makeText(PostActivity2.this, "Connect: "+response.body().toString(), Toast.LENGTH_LONG).show();
                List<JsonRepoformain> repos=response.body();
                listView.setAdapter(new jsonRepoformainAdapter(PostActivity2.this,repos));

            }

            @Override
            public void onFailure(Call<List<JsonRepoformain>> call, Throwable throwable) {
                Toast.makeText(PostActivity2.this, "Error: "+throwable.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}