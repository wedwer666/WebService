package com.example.pam.webservice;

import android.support.v7.app.AppCompatActivity;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Maria on 03.11.2017.
 */

public class RequestAnalyze extends AppCompatActivity {

    private String url = "https://www.orangetext.md/";

    //rejex file to extract filess
    public Captcha extractCaptcha()
    {
        StringBuilder sb = new StringBuilder("");

        try {
            URL requestUrl = new URL(url);

            HttpURLConnection connection = (HttpURLConnection) requestUrl.openConnection();

            connection.setRequestMethod("GET");
    }
}
