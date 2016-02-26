package com.ldd.volley.utils;

import com.android.volley.Request.Method;
import com.android.volley.toolbox.StringRequest;
import com.ldd.volley.application.VolleyApplication;

import android.content.Context;

public class VolleyRequest {
	public static StringRequest stringRequest;
	public static Context context;

	public static void RequestGet(Context mContext,String url,String tag){
		VolleyApplication.getHttpQueues().cancelAll(tag);
//		stringRequest = new StringRequest(Method.GET, url, listener, errorListener);
	}
}
