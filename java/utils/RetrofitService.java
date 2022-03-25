package com.example.demoapp.utils;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {
    private static final String URL = "https://60370fce5435040017721858.mockapi.io/api/v1/";
    private static JSONApi jsonApi;

    public static JSONApi builder() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create()).build();
        jsonApi = retrofit.create(JSONApi.class);
        return jsonApi;
    }
}
