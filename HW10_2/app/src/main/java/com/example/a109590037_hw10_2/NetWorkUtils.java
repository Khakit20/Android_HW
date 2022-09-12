package com.example.a109590037_hw10_2;


import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NetWorkUtils {
    private static final String LOG_TAG = NetWorkUtils.class.getSimpleName();

    static String getWebInfo(String queryString){
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String Websource = null;

        try {
            URL requestURL = new URL("https://www.youbike.com.tw/region/main/stations/");
            urlConnection = (HttpURLConnection) requestURL.openConnection();

            InputStream inputStream = urlConnection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder builder = new StringBuilder();

            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
                builder.append("\n");
            }
            if (builder.length() == 0) {
                return null;
            }
            Websource = builder.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return "Check your internet connection and try again.";
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        Log.d(LOG_TAG, Websource);
        return Websource;
    }
}
