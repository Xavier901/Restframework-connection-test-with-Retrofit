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

public class CommentsActivity2 extends AppCompatActivity {
    ListView listCommentView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //       EdgeToEdge.enable(this);
        setContentView(R.layout.activity_comments2);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
    listCommentView=(ListView) findViewById(R.id.comment_ListView);
        Retrofit.Builder builder=new Retrofit.Builder()
                //.baseUrl("http://192.168.242.158:8000/")
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit=builder.build();

        rest_call client=retrofit.create(rest_call.class);

        Call<List<Comments>> call=client.jsonForComments("comments");

        call.enqueue(new Callback<List<Comments>>() {
            @Override
            public void onResponse(Call<List<Comments>> call, Response<List<Comments>> response) {
                List<Comments>commentsList=response.body();
                listCommentView.setAdapter(new CommentsAdapters(CommentsActivity2.this,commentsList));
            }

            @Override
            public void onFailure(Call<List<Comments>> call, Throwable throwable) {

            }
        });

    }
}