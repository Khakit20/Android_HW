package com.example.powerreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class CustomReceiver extends BroadcastReceiver {

    private static final String ACTION_CUSTOM_BROADCAST =
            BuildConfig.APPLICATION_ID + ".ACTION_CUSTOM_BROADCAST";

    @Override
    public void onReceive(Context context, Intent intent) {
        String intentAction = intent.getAction();
        int intValue = intent.getIntExtra("intVariableName", 0);
        String toastMessage = null;
        if (intentAction != null) {
            toastMessage = "unknown intent action";
            switch (intentAction){
                case Intent.ACTION_POWER_CONNECTED:
                    toastMessage = "Power connected!";
                    break;
                case Intent.ACTION_POWER_DISCONNECTED:
                    toastMessage = "Power disconnected!";
                    break;
                case ACTION_CUSTOM_BROADCAST:
                    toastMessage = "Custom Broadcast Received";
                    toastMessage += "\nSquare of the Random number: ";
                    toastMessage += Integer.toString(intValue*intValue);
                    break;
            }

            //Display the toast.
        }

        Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show();
    }
}