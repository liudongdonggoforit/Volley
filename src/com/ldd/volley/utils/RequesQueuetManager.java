package com.ldd.volley.utils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.ldd.volley.application.VolleyApplication;


/**
 * Created by saymagic on 15/1/27.
 */
public class RequesQueuetManager {
	public static RequestQueue mRequestQueue = Volley.newRequestQueue(VolleyApplication.getInstance());

	public static void addRequest(Request<?> request, Object object){
		if (object != null){
			request.setTag(object);
		}
		mRequestQueue.add(request);
	}

	public static void cancelAll(Object tag) {
		mRequestQueue.cancelAll(tag);
	}
}
