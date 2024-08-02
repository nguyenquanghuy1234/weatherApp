package com.example.weatherapplication.ApiSevices;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private Retrofit retrofit =null;

    //tạo biến _intance
    private static RetrofitClient _intance=null;
    private ApiRequest apiRequest;

    //tạo contructer private rỗng
    private RetrofitClient () {
        retrofit = CreateRetrofit();
        apiRequest=retrofit.create(ApiRequest.class);
    }

    public ApiRequest getApiRequest() {
        return apiRequest;
    }


    //tạo hàm static get intance
    public static RetrofitClient get_intance(){
        if(_intance==null){
            _intance= new RetrofitClient();
        }
        return _intance;
    }

    public Retrofit CreateRetrofit(){
        OkHttpClient okHttpClient= new OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30,TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .protocols(Arrays.asList(Protocol.HTTP_1_1))
                .build();

        Gson gson=new GsonBuilder().setLenient().create();

        return new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }
}
