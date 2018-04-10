package org.kasapbasi.week0801;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MyPhoneSpy theSpy= new MyPhoneSpy();
  TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         tv=(TextView) findViewById(R.id.myResult);

        //this.registerReceiver(theSpy, new IntentFilter(TelephonyManager.ACTION_PHONE_STATE_CHANGED));

    }


    /**
     * Dispatch onResume() to fragments.  Note that for better inter-operation
     * with older versions of the platform, at the point of this call the
     * fragments attached to the activity are <em>not</em> resumed.  This means
     * that in some cases the previous state may still be saved, not allowing
     * fragment transactions that modify the state.  To correctly interact
     * with fragments in their proper state, you should instead override
     * {@link #onResumeFragments()}.
     */

    PowerConnectionReceiver pcr= new PowerConnectionReceiver();
    @Override
    protected void onResume() {



        super.onResume();

         IntentFilter if2= new IntentFilter(TelephonyManager.ACTION_PHONE_STATE_CHANGED);
         Intent ft=MainActivity.this.registerReceiver(theSpy,if2);

        IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        Intent batteryStatus = MainActivity.this.registerReceiver(pcr, ifilter);


        // Are we charging / charged?
        int status = batteryStatus.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
        boolean isCharging = status == BatteryManager.BATTERY_STATUS_CHARGING ||
                status == BatteryManager.BATTERY_STATUS_FULL;

// How are we charging?
        int chargePlug = batteryStatus.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);
        boolean usbCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_USB;
        boolean acCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_AC;
        if(isCharging){
            Toast.makeText(MainActivity.this
                    ,"ÇARCİNG",Toast.LENGTH_LONG).show();
            tv.setText("ÇARCİNG");
        }

        if(usbCharge){
            Toast.makeText(MainActivity.this,"ÇARCİNG USB",Toast.LENGTH_LONG).show();
            tv.setText("ÇARCİNG USB");
        }

        if(acCharge){
            Toast.makeText(MainActivity.this,"ÇARCİNG AC",Toast.LENGTH_LONG).show();
            tv.setText("ÇARCİNG AC");
        }

    }
}
