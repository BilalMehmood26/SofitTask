package com.example.sofittaskapp.retrofit;

import com.example.sofittaskapp.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    public static String BASE_URL = "https://jsonplaceholder.typicode.com/";
    @GET("posts")
    Call<List<Post>> getPost();
}
