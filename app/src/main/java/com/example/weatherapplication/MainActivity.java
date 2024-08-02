package com.example.weatherapplication;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.weatherapplication.ApiSevices.RetrofitClient;
import com.example.weatherapplication.Dagger.animal;
import com.example.weatherapplication.Dagger.cat;
import com.example.weatherapplication.Dagger.dog;
import com.example.weatherapplication.weather.WeatherModel;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

//        animal animal=new animal(new dog("black"),new cat("white"));
//        animal.showAnimal();

        Call<WeatherModel>  repos = RetrofitClient.get_intance().getApiRequest().getTempCity("2206d84c8189efe365465e3318f487aa","metric","hanoi");

        repos.enqueue(new Callback<WeatherModel>() {
            @Override
            public void onResponse(Call<WeatherModel> call, Response<WeatherModel> response) {
                if(response.isSuccessful()){
                    WeatherModel weatherModel=response.body();
                    Log.d("huy", "onResponse: "+weatherModel.getName());
                }else {
                    try {
                        ResponseBody responseBody=response.errorBody();
                        Log.d("huy", "fail api: "+responseBody.string());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            @Override
            public void onFailure(Call<WeatherModel> call, Throwable throwable) {
                Log.d("huy", "onFailure: "+ throwable.getMessage());
            }
        });
    }
}