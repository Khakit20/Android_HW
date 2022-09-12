package com.example.a109590037_hw10_2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, LoaderManager.LoaderCallbacks<String>{

    private EditText mUrlText;
    private TextView mResultView;
    private String mSpinner;
    private String postion;
    private int getItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUrlText = findViewById(R.id.url);
        mResultView = findViewById(R.id.resultview);

        Spinner spinner = findViewById(R.id.url_spinner);
        if (spinner != null) {
            spinner.setOnItemSelectedListener(this);
        }
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.url_title, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        if (spinner != null) {
            spinner.setAdapter(adapter);
        }

        if(LoaderManager.getInstance(this).getLoader(0)!=null){
            LoaderManager.getInstance(this).initLoader(0,null,this);
        }
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        mSpinner = adapterView.getItemAtPosition(i).toString();
        getItem = i;
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void getSource(View view) {
        String queryString = mSpinner;

        InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (inputManager != null ) {
            inputManager.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }

        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = null;
        if (connMgr != null) {
            networkInfo = connMgr.getActiveNetworkInfo();
        }

        if (networkInfo != null && networkInfo.isConnected() && mUrlText.getText().toString().length() != 0) {

            Bundle queryBundle = new Bundle();
            queryBundle.putString("queryString", queryString);
            getSupportLoaderManager().restartLoader(0, queryBundle, this);

            mResultView.setText("Please Wati....");
        } else {
            if (mUrlText.getText().toString().length() != 0) {
                mResultView.setText("Please enter a search term");
            } else {
                mResultView.setText("Please check your network connection and try again.");
            }
        }
    }

    @NonNull
    @Override
    public Loader<String> onCreateLoader(int id, @Nullable Bundle args) {
        String queryString = "";

        if (args != null) {
            queryString = args.getString("queryString");
        }

        return new WebLoader(this, queryString);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String data) {
        try {
            postion = "\""+mUrlText.getText().toString()+"\"";
            int youbike_data1 = data.indexOf(postion);
            data = data.substring(youbike_data1-40);
            int youbike_num = data.indexOf("\"station_no\"");
            int set = data.indexOf("\"name_tw\"");
            String station_num = data.substring(youbike_num+13,set-1);
            int num = station_num.length();
            if( (num <= 8 && getItem == 0) || (num >= 10 && getItem == 1) ) {
                youbike1(data, postion);
            }
            else{
                data = data.substring(set+100);
                youbike_data1 = data.indexOf(postion);
                data = data.substring(youbike_data1-40);
                youbike2(data, postion);
            }
        }
        catch (Exception e){
            mResultView.setText("請檢查並重新輸入站名");
        }
    }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {

    }

    public void youbike1(@NonNull String data , String postion) {
        int youbike_available_space_postion = data.indexOf("\"available_spaces\"");
        String available_space = data.substring(youbike_available_space_postion + 19, youbike_available_space_postion + 30);
        int dot1 = available_space.indexOf(",");
        available_space = available_space.substring(0, dot1);
        postion += " " + (available_space);
        int youbike_available_parking_postion = data.indexOf("\"empty_spaces\"");
        String available_parking = data.substring(youbike_available_parking_postion + 15, youbike_available_parking_postion + 30);
        int dot2 = available_parking.indexOf(",");
        available_parking = available_parking.substring(0, dot2);
        postion += " " + (available_parking);
        mResultView.setText(postion);
    }

    public void youbike2(@NonNull String data , String postion) {
        int youbike_available_space_postion = data.indexOf("\"available_spaces\"");
        String available_space = data.substring(youbike_available_space_postion + 19, youbike_available_space_postion + 30);
        int dot1 = available_space.indexOf(",");
        available_space = available_space.substring(0, dot1);
        postion += " " + (available_space);
        int youbike_available_parking_postion = data.indexOf("\"empty_spaces\"");
        String available_parking = data.substring(youbike_available_parking_postion + 15, youbike_available_parking_postion + 30);
        int dot2 = available_parking.indexOf(",");
        available_parking = available_parking.substring(0, dot2);
        postion += " " + (available_parking);
        mResultView.setText(postion);
    }
}