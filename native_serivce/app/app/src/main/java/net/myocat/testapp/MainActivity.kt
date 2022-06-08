package net.myocat.testapp

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder

import net.myocat.ITestService;
import net.myocat.ITestServiceListener;

class MainActivity : AppCompatActivity() {

    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }

    private var mTestService : ITestService ?= null

    private var mServiceConnection = object: ServiceConnection {
        override fun onServiceConnected(compName: ComponentName?, binder: IBinder?) {
            mTestService = ITestService.Stub.asInterface(binder)

            android.util.Log.d("PRAZEN", "==== Service " + mTestService);
            mTestService?.echo("1111");
        }

        override fun onServiceDisconnected(p0: ComponentName?) {
            mTestService = null
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var intent = Intent().also {
            it.setClassName("net.myocat.ITestService", "net.myocat.ITestService")}

        android.util.Log.d("PRAZEN", "Try bind Service");
        bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE)
    }
}