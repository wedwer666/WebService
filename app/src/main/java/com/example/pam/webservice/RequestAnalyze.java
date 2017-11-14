//package com.example.pam.webservice;
//
//import android.graphics.Bitmap;
//import android.support.v7.app.AppCompatActivity;
//import android.util.Log;
//
//import java.io.BufferedReader;
//import java.io.DataOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.net.URLEncoder;
//import java.util.regex.Pattern;
//import java.util.regex.Matcher;
//import android.util.Patterns;
//
//import org.apache.http.client.methods.HttpGetHC4;
//import org.apache.http.impl.DefaultBHttpClientConnection;
//import org.apache.http.impl.client.HttpClients;
//
//
///**
// * Created by Maria on 03.11.2017.
// */
//
//public class RequestAnalyze extends AppCompatActivity {
//
//    private final String User_Agent = "https://www.orangetext.md/";
//
//    public static void main(String[] args) throws Exception {
//
//        RequestAnalyze http = new RequestAnalyze();
//
//        System.out.println("Testing 1 - Send Http GET request");
//        http.sendGet();
//
//        System.out.println("\nTesting 2 - Send Http POST request");
////        http.sendPost();
//
//    }
//
//    private void sendGet() throws Exception {
//        StringBuilder sb = new StringBuilder("");
//        try {
//            URL requestUrl = new URL(User_Agent);
//
//            HttpURLConnection connection = (HttpURLConnection) requestUrl.openConnection();
//
//            connection.setRequestMethod("GET");
//            connection.connect();
//
//            InputStream inputStream = connection.getInputStream();
//
//            BufferedReader rd = new BufferedReader(new InputStreamReader(inputStream));
//
//            String line = "";
//
//            System.out.println(connection.getResponseCode());
//
//            while ((line = rd.readLine()) != null) {
//                sb.append(line);
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        Log.d("TestExampleforGET", sb.toString());
//    }
//
//    //HTTP POST REQUEST
//    private void sendPost(String catrenume, String delanume, String mesajtext, Captcha captureimage) throws Exception {
//        try {
//            String Query = createmessage(delanume, catrenume, mesajtext.replace(" ", "+"), captureimage);
//            URL url = new URL("https://www.orangetext.md/");
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setRequestMethod("POST");
//            conn.setRequestProperty("Content-Type", User_Agent);
//            conn.setRequestProperty("Accept", "Romanian Language");
//            conn.setDoOutput(true);
//            conn.setDoInput(true);
//            conn.connect();
//
//            DataOutputStream os = new DataOutputStream(conn.getOutputStream());
//            os.flush();
//            os.close();
//
//            Log.i("RequestStatus", String.valueOf(conn.getResponseCode()));
//            Log.i("MessageReceived", conn.getResponseMessage());
//
//            conn.disconnect();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    public String createmessage(String nume, String telefon, String mesaj, Captcha captcha)
//    {
//
//        //Extract information grom the html web page
//        return "nume = " + nume + "telefon =" + telefon+  "mesaj = "+ mesaj + "Captha = " + captcha;
//    }
//}
//
//////    public static boolean matches(String returnstring, CharSequence input) {
////        String returnstring = "some string with 'the data i want' inside";
////        Pattern captchaRegexId = Pattern.compile("<div[\\s]+class=[\'\"]captcha[\'\"]>[\\s]*<[\\s]*input.*value=[\'\"]([0-9]+)[^\\>]{1}");
////        Pattern captchaRegexUrl = Pattern.compile("<div[\\s]+class=[\'\"]captcha[\'\"]>[\\s\r\n]*<input.*>[\\s\r\n]*<[\\s]*input.*>[\\s\r\n]*<[\\s]*img[\\s]src=[\'\"]*(\\S[^\'^\"]+)[^\"]");
////        Pattern captchaRegexToken = Pattern.compile("<div[\\s]+class=[\'\"]captcha[\'\"]>[\\s\r\n]*<input.*>[\\s\r\n]*<[\\s]*input.*value=[\'\"](\\S[^\'^\"]+)[^\\>]");
////        Pattern captchaRegexForm = Pattern.compile("<form.*id=[\'\"]websms-main-form[\\s\\S]*name=[\'\"]form_build_id.*value=[\'\"](\\S[^\'^\"]+)");
////        Matcher m1 = captchaRegexId.matcher(returnstring);
////        Matcher m2 = captchaRegexUrl.matcher(returnstring);
////        Matcher m3 = captchaRegexToken.matcher(returnstring);
////        Matcher m4 = captchaRegexForm.matcher(returnstring);
////        String RegexId = m1.group(1);
////        String RegexUrl = m2.group(2);
////        String RegexToken = m3.group(3);
////        String RegexForm = m4.group(4);
////
////        return new  Captcha(RegexId, RegexUrl, RegexToken, RegexForm);
////    }
//
