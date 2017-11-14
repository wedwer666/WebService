package com.example.pam.webservice;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private EditText delanume;
    private EditText catrenume;
    private EditText mesajtext;
    private ImageView captureimage;
    private Button sendButton;
    //    private DownloadManager.Request request;
    private String url = "https://www.orangetext.md/";
    private String sResponse;

    // Create a new HttpClient and Post Header
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        setContentView(R.layout.activity_main);

        delanume = (EditText) findViewById(R.id.delabutton);
        catrenume = (EditText) findViewById(R.id.catrebutton);
        mesajtext = (EditText) findViewById(R.id.mesajinput);
        captureimage = (ImageView) findViewById(R.id.captureimage);

        //BUTTON TO SEND A HTTP REQUSEST TO ORANGE.MD PAGE AND EXCTRACT INFORMATION FORM HERE
        sendButton = (Button) findViewById(R.id.sendbutton);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder sb = new StringBuilder("");

                try {
                    URL requestUrl = new URL(url);


                    HttpURLConnection connection = (HttpURLConnection) requestUrl.openConnection();

                    connection.setRequestMethod("GET");
                    connection.setRequestProperty("Accept", "application/xml");
                    connection.connect();

                    InputStream xml = connection.getInputStream();

                    BufferedReader rd = new BufferedReader(new InputStreamReader(xml));

//                    String line = "";

//                    System.out.println(connection.getResponseCode());

                    String sLine;
                    while ((sLine = rd.readLine()) != null) {
                        sb.append(sLine);
                        System.out.println(sLine);
                    }
                    sResponse = sb.toString();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                Document doc = null;
                try {
                    doc = Jsoup.parse(sResponse);
                    System.out.println(doc);
//                    Elements elements = doc.select("h1,h2,h3,h4,h5");
                     Elements elements = doc.select("h3.r > a");

                    for (Element element : elements) {
                        StringBuilder sb1 = new StringBuilder   (element.toString());

                        Element next = element.nextElementSibling();
                        while (next != null && !next.tagName().startsWith("h")) {
                            sb.append(next.toString()).append("\n");
                            next = next.nextElementSibling();
                        }
                        System.out.println(sb1);

                    }


//                    String title = doc.title();

//                Elements links = doc.select("a[href");
//
//                for (org.jsoup.nodes.Element link : links)
//                {
//                    System.out.println("\nLink : " + link.attr("href"));
//                    System.out.println("Text: " + link.text());
//                }
                } catch (Exception e) {
                    e.printStackTrace();
                }
//                StringBuilder sb = new StringBuilder("");
//
//                try {
//                    URL requestUrl = new URL(url);
//
//                    HttpURLConnection connection = (HttpURLConnection) requestUrl.openConnection();
//
//                    connection.setRequestMethod("GET");
//                    connection.connect();
//
//                    InputStream inputStream = connection.getInputStream();
//
//                    BufferedReader rd = new BufferedReader(new InputStreamReader(inputStream));
//
//                    String line = "";
//
//                    System.out.println(connection.getResponseCode());
//
//                    while ((line = rd.readLine()) != null) {
//                        sb.append(line);
//                    }
//
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//
//                Log.d("testest", sb.toString());
            }
        });

    }


}
