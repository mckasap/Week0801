package org.kasapbasi.week0801;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by mcemkasapbasi on 10.04.2018.
 */

public class PowerConnectionReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
        boolean isCharging = status == BatteryManager.BATTERY_STATUS_CHARGING ||
                status == BatteryManager.BATTERY_STATUS_FULL;

        int chargePlug = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);
        boolean usbCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_USB;
        boolean acCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_AC;
        Log.i("test","GİRDİ");
        if(isCharging){
            Toast.makeText(context,"ÇARCİNG",Toast.LENGTH_LONG).show();
        }

        if(usbCharge){
            Toast.makeText(context,"ÇARCİNG USB",Toast.LENGTH_LONG).show();
        }

        if(acCharge){
            Toast.makeText(context,"ÇARCİNG AC",Toast.LENGTH_LONG).show();
        }
    }

}

