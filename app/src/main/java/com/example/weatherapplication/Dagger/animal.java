package com.example.weatherapplication.Dagger;

import android.util.Log;

public class animal {
    dog dog;
    cat cat;

    public animal(com.example.weatherapplication.Dagger.dog dog, com.example.weatherapplication.Dagger.cat cat) {
        this.dog = dog;
        this.cat = cat;
    }

    public void showAnimal(){
        Log.d("BBB", "showAnimal: "+dog+"---"+cat);
    }
}
