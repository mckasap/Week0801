package org.kasapbasi.week0801;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by mcemkasapbasi on 10.04.2018.
 */

public class MyPhoneSpy extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();

        Toast.makeText(context,"TELEFON DURUMU",Toast.LENGTH_LONG).show();
        if (extras != null) {
         String state = extras.getString(TelephonyManager.EXTRA_STATE);
            Log.i("mc:", state);
            if (state.equals(TelephonyManager.EXTRA_STATE_RINGING))
            {
                String phoneNumber = extras
                        .getString(TelephonyManager.EXTRA_INCOMING_NUMBER);
                Log.i("mc:", phoneNumber);

            }

        }
    }
}
