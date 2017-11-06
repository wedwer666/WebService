package com.example.pam.webservice;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import android.util.Patterns;


/**
 * Created by Maria on 03.11.2017.
 */

public class RequestAnalyze extends AppCompatActivity {

    public String url = "https://www.orangetext.md/";

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


        //JUST RANFOM EXAMPLE OF MYDATA
        String returnstring = "some string with 'the data i want' inside";

    public static boolean matches(String returnstring, CharSequence input) {
        Pattern captchaRegexId = Pattern.compile("<div[\\s]+class=[\'\"]captcha[\'\"]>[\\s]*<[\\s]*input.*value=[\'\"]([0-9]+)[^\\>]{1}");
        Pattern captchaRegexUrl = Pattern.compile("<div[\\s]+class=[\'\"]captcha[\'\"]>[\\s\r\n]*<input.*>[\\s\r\n]*<[\\s]*input.*>[\\s\r\n]*<[\\s]*img[\\s]src=[\'\"]*(\\S[^\'^\"]+)[^\"]");
        Pattern captchaRegexToken = Pattern.compile("<div[\\s]+class=[\'\"]captcha[\'\"]>[\\s\r\n]*<input.*>[\\s\r\n]*<[\\s]*input.*value=[\'\"](\\S[^\'^\"]+)[^\\>]");
        Pattern captchaRegexForm = Pattern.compile("<form.*id=[\'\"]websms-main-form[\\s\\S]*name=[\'\"]form_build_id.*value=[\'\"](\\S[^\'^\"]+)");
        Matcher m1 = captchaRegexId.matcher(input);
        Matcher m2 = captchaRegexUrl.matcher(input);
        Matcher m3 = captchaRegexToken.matcher(input);
        Matcher m4 = captchaRegexForm.matcher(input);
        return m1.matches();
//            return m2.matches();
//            return m3.matches();
//            return m4.matches();

    }

    //APPLY POST METHOD that submits data to be processed to a specified resource
    public String getReturnstring() {
        try {
            URL url = new URL("https://www.orangetext.md/"); //in the real code, there is an ip and a port
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Accept", "application/json");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.connect();

            DataOutputStream os = new DataOutputStream(conn.getOutputStream());
            os.flush();
            os.close();

            Log.i("STATUS", String.valueOf(conn.getResponseCode()));
            Log.i("MSG", conn.getResponseMessage());

            conn.disconnect();
        } catch (Exception e) {

        }
    }
}




          //receive variables using post methods
//        public Captcha postmethod() {
//        }

