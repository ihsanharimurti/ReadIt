package com.example.ta_prakppb_ihsanh.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("volumes")
    Call<ListUserResponse> getList(
            @Query("q") String query,
            @Query("orderBy") String orderBy,
            @Query("printType") String printType,
            @Query("filter") String filter,
            @Query("maxResults") int maxResult,
            @Query("startIndex") int startIndex,
            @Query("key") String apiKey
    );
}
