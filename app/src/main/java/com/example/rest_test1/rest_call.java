package com.example.rest_test1;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface rest_call {
    @GET("{posts}")
    Call<List<JsonRepoformain>> jsonreposForUser(@Path("posts") String user);

    @GET("{comments}")
    Call<List<Comments>> jsonForComments(@Path("comments") String user);

    @GET("{users}")
    Call<List<User>> jsonForusers(@Path("users") String user);

    @GET("{v1}")
    Call<List<restData>> jsonrest(@Path("v1") String user);
}
