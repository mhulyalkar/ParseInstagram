package com.codepath.parseinstagram;

import android.app.Application;

import com.parse.Parse;

public class ParseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("UjidpcrMmBJnpXNU1luXqvCAHZMSOZ5CkHTkOkfQ")
                .clientKey("XLMt4GuuY2j6eJUOOd7h24kWiq4SrwKxEkHt74f0")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
