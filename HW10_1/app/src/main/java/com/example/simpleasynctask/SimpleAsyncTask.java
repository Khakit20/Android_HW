package com.example.simpleasynctask;


import android.content.Context;
import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Random;

public class SimpleAsyncTask extends AsyncTask<Integer, Integer, String> {

    private WeakReference<TextView> mTextView;
    private ProgressBar progressBar;

    SimpleAsyncTask(TextView tv,ProgressBar progressBar) {
        this.mTextView = new WeakReference<>(tv);
        this.progressBar = progressBar;
    }

    @Override
    protected String doInBackground(Integer... integers) {

        // Generate a random number between 0 and 10
        Random r = new Random();
        int n = r.nextInt(11);

        // Make the task take long enough that we have
        // time to rotate the phone while it is running
        int s = n * 200;
        int i = 0;
        publishProgress(i);
        for (i = 0 ; i<=100 ; i++) {
            // Sleep for the random amount of time
            try {
                Thread.sleep(s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            publishProgress(i);
        }
        // Return a String result
        return "Awake at last after sleeping for " + s + " milliseconds!";
    }

    protected void onPostExecute(String result) {
        mTextView.get().setText(result);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        int value = values[0];
        progressBar.setProgress(value);
    }
}
