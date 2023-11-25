package com.example.ta_prakppb_ihsanh.api;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    // Singleton instance of ApiInterface
    private static ApiInterface service;

    private ApiClient() {
        // Private constructor to prevent instantiation
    }

    public static ApiInterface getService() {
        if (service == null) {
            synchronized (ApiClient.class) {
                if (service == null) {
                    // Use the provided baseUrl method
                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl("https://www.googleapis.com/books/v1/")
                            .addConverterFactory(GsonConverterFactory.create())
                            .client(new OkHttpClient.Builder().build())
                            .build();

                    service = retrofit.create(ApiInterface.class);
                }
            }
        }
        return service;
    }
}
