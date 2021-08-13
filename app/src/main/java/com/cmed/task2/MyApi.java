package com.cmed.task2;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyApi {
    @GET("api/characters")
    Call<ArrayList<MyList>> getartistdata();
}
