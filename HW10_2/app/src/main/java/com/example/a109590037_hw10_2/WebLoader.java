package com.example.a109590037_hw10_2;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import java.lang.ref.WeakReference;

public class WebLoader extends AsyncTaskLoader<String> {
    private String mQueryString;

    WebLoader(Context context, String queryString) {
        super(context);
        mQueryString = queryString;
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    @Nullable
    @Override
    public String loadInBackground() {
        return NetWorkUtils.getWebInfo(mQueryString);
    }
}
