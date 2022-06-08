package net.myocat.client;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import net.myocat.ITestService;

import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity
{
    private static final String TAG = MainActivity.class.getSimpleName();

    private IBinder getService(String serviceName)
    {
        IBinder binder = null;
        try{
            Object object = new Object();
            Method getService = Class.forName("android.os.ServiceManager").getMethod("getService", String.class);
            Object obj = getService.invoke(object, new Object[]{new String(serviceName)});
            binder = (IBinder)obj;
        } catch(Exception e) {
            Log.d(TAG, e.toString());
        }

        return binder;
    }

    private ITestService mService;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mService = ITestService.Stub.asInterface(getService("net.myocat.ITestService"));
        if (mService == null) {
            Log.d(TAG, "failed to getting service " + mService);
        }

        try {
            mService.echo("TTTTT");
        }
        catch (RemoteException e) {
            e.printStackTrace();
        }

    }
}