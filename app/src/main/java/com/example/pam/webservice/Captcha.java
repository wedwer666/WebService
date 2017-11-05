package com.example.pam.webservice;

import android.graphics.Bitmap;

/**
 * Created by Maria on 05.11.2017.
 */

public class Captcha {
    private String id;
    private Bitmap img;
    private String token;
    private String form;

    public Captcha (String one, Bitmap two, String three, String four )
    {
        this.id = one;
        this.img = two;
        this.token = three;
        this.form = four;
    }
    public String getId() {
        return id;
    }

    public Bitmap getImg()
    {
        return img;
    }
    public String getToken()
    {
        return token;
    }
    public String getForm(){
        return form;
    }
}


