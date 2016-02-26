package com.ldd.volley.application;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class VolleyApplication extends Application {
	public static String TAG;
	private static VolleyApplication application;
	public static RequestQueue queues;
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		queues = Volley.newRequestQueue(getApplicationContext());
		 TAG = this.getClass().getSimpleName();
	        application = this;
	}
	
	public static RequestQueue getHttpQueues(){
		return queues;
	}

    public static VolleyApplication getInstance() {
        return application;
    }

}
