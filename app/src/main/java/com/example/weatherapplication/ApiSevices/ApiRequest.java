package com.example.weatherapplication.ApiSevices;

import com.example.weatherapplication.weather.WeatherModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiRequest {

    //?appid=2206d84c8189efe365465e3318f487aa&units=metric&q=hanoi

    //Dùng dạng query nối các key lên thanh địa chỉ
    @GET("data/2.5/weather?")
    Call<WeatherModel> getTempCity(@Query("appid") String appid,
                             @Query("units")String units,
                             @Query("q")String q);


    //Dùng dạng param để thay đổi giá trị
//    @GET("data/2.5/weather?appid=2206d84c8189efe365465e3318f487aa&units=metric")
//    Call<WeatherModel>  getTempCity(@Query("q") String cityName);
}
