package com.musica.android.reart.utils;


import java.sql.Timestamp;

public class Utils {

    public static String getNowByTimeStamp(){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return timestamp.toString();
    }
}
