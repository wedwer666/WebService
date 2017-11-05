package com.example.pam.webservice;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import android.util.Patterns;


/**
 * Created by Maria on 03.11.2017.
 */

public class RequestAnalyze extends AppCompatActivity {

    private String url = "https://www.orangetext.md/";

    //rejex file to extract filess
    public Captcha extractCaptcha() {
        StringBuilder sb = new StringBuilder("");

        try {
            URL requestUrl = new URL(url);

            HttpURLConnection connection = (HttpURLConnection) requestUrl.openConnection();

            connection.setRequestMethod("GET");
            connection.connect();

            InputStream inputStream = connection.getInputStream();

            BufferedReader rd = new BufferedReader(new InputStreamReader(inputStream));

            String line = "";

            System.out.println(connection.getResponseCode());

            while ((line = rd.readLine()) != null) {
                sb.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        Log.d("testest", sb.toString());
//        while ((strResponse = rd.readLine()) != null) {
//            sb.append(strResponse);
    }

        //JUST RANFOM EXAMPLE OF MYDATA
        String returnstring = "some string with 'the data i want' inside";

        Pattern captchaRegexId = Pattern.compile("<div[\\s]+class=[\'\"]captcha[\'\"]>[\\s]*<[\\s]*input.*value=[\'\"]([0-9]+)[^\\>]{1}");
        Pattern captchaRegexUrl = Pattern.compile("<div[\\s]+class=[\'\"]captcha[\'\"]>[\\s\r\n]*<input.*>[\\s\r\n]*<[\\s]*input.*>[\\s\r\n]*<[\\s]*img[\\s]src=[\'\"]*(\\S[^\'^\"]+)[^\"]");
        Pattern captchaRegexToken = Pattern.compile("<div[\\s]+class=[\'\"]captcha[\'\"]>[\\s\r\n]*<input.*>[\\s\r\n]*<[\\s]*input.*value=[\'\"](\\S[^\'^\"]+)[^\\>]");
        Pattern captchaRegexForm = Pattern.compile("<form.*id=[\'\"]websms-main-form[\\s\\S]*name=[\'\"]form_build_id.*value=[\'\"](\\S[^\'^\"]+)");
        Matcher m = captchaRegexId.matcher(returnstring);
        if (m.matches())
         {
            System.out.println(m.group(1));
          }
    }

