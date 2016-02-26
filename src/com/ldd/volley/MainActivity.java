package com.ldd.volley;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request.Method;
import com.android.volley.Response;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageLoader.ImageListener;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.ldd.volley.adapter.ProductListAdapter;
import com.ldd.volley.adapter.PropertyNotificationAdapter;
import com.ldd.volley.application.VolleyApplication;
import com.ldd.volley.bean.FleaArray;
import com.ldd.volley.bean.Fleas;
import com.ldd.volley.utils.BitmapCache;

public class MainActivity extends ActionBarActivity {

	private TextView mTextView,mName;
	private ListView mListView;
	private ImageView mImage;
	private PropertyNotificationAdapter mAdapter;
	private ProductListAdapter mProductListAdapter;
	private int num=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mTextView = (TextView) findViewById(R.id.volleyTextView);
		mName = (TextView) findViewById(R.id.nameTextView);
		mListView = (ListView) findViewById(R.id.noteListview);
		mImage = (ImageView) findViewById(R.id.imageView);
		String urlBaidu= "https://www.baidu.com/img/bdlogo.png";
		
		
		ImageRequest requestImage = new ImageRequest(urlBaidu, new Listener<Bitmap>() {

			@Override
			public void onResponse(Bitmap response) {
				mImage.setImageBitmap(response);
				
			}
		}, 0, 0, Config.RGB_565, new Response.ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError error) {
				mImage.setImageResource(R.drawable.ic_launcher);
				
			}
		});
		VolleyApplication.getHttpQueues().add(requestImage);
		
		ImageLoader loader = new ImageLoader(VolleyApplication.getHttpQueues(), new BitmapCache());
		ImageListener listener = ImageLoader.getImageListener(mImage, R.drawable.ic_launcher, R.drawable.ic_launcher);
		loader.get(urlBaidu, listener);
//		Voley_Get();
		Volley_Post();
	}

	private void Volley_Post() {
//		String url = "http://service.mantoto.com//Json/GetWeather.aspx";
//		String url = "http://service.mantoto.com//Json/PromotionByBusiness.aspx";
//		String url = "http://service.exiudaojia.com//Json/Notes.aspx";
		String url = "http://service.exiudaojia.com//Json/FleaGetByProperty.aspx";
//		String url = "http://v.juhe.cn/weather/index?format=2&cityname=%E8%8B%8F%E5%B7%9E&key=44a581bd755b5c2b137d88c7ce9fc58c";
		Map<String, String> map = new HashMap<String, String>();
//		map.put("cityname", "北京市");
//		map.put("userid", "10416");
//		map.put("propertyid", "13");
		map.put("propertyid", "2658");
//		map.put("description", "wifi");\
		map.put("pageindex", "1");
		JSONObject object = new JSONObject(map);
		JsonObjectRequest request = new JsonObjectRequest(Method.POST, url, object, new Listener<JSONObject>() {

			@Override
			public void onResponse(JSONObject response) {
//				Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_LONG).show();
//				mTextView.setText(response.toString());
//				Log.i("MyLog", "获取的通知内容为"+response.toString());
				/*Gson gson = new Gson();
				Notearray notearray = gson.fromJson(response.toString(), Notearray.class);
				ArrayList<Notes> notearrays =notearray.getNotearray();*/
				
				Gson gson = new Gson();
				FleaArray fleaArray = gson.fromJson(response.toString(), FleaArray.class);
				ArrayList<Fleas> fleaArrays = fleaArray.getFleaarray();
				
				if (fleaArray.getCode()==200) {
					mListView.setVisibility(View.VISIBLE);
					View view = findViewById(R.id.nullData);
					view.setVisibility(View.GONE);
					mProductListAdapter = new ProductListAdapter(getApplicationContext(), fleaArrays);
					mListView.setAdapter(mProductListAdapter);
//					mProductListAdapter.notifyDataSetChanged();
//					mAdapter = new PropertyNotificationAdapter(getApplicationContext(), notearrays);
//					mListView.setAdapter(mAdapter);
//					mAdapter.notifyDataSetChanged();
//					mName.setText(""+notearrays.size()+notearray.getDesc()+notearrays.get(1).getSignature());
					mName.setText(""+fleaArrays.size());
					
				}else{
					/*if (notearray.getCode()==201) {
						mListView.setVisibility(View.GONE);
						View view = findViewById(R.id.nullData);
						view.setVisibility(View.VISIBLE);
						TextView mTextView = (TextView) view.findViewById(R.id.null_data_TextView);
						mTextView.setOnClickListener(new OnClickListener() {
							
							@Override
							public void onClick(View arg0) {
								Toast.makeText(getApplicationContext()," 刷新成功", Toast.LENGTH_SHORT).show();
								num=1;
								Volley_Post();
							}
						});
					}
					Toast.makeText(getApplicationContext(), notearray.getDesc(), Toast.LENGTH_LONG).show();*/
				}
				
				
			}
		}, new Response.ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError error) {
				Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_LONG).show();
				mTextView.setText(error.toString());
			}
		});
		/*StringRequest request = new StringRequest(Method.POST, url, new Listener<String>() {

			@Override
			public void onResponse(String response) {
				Toast.makeText(MainActivity.this, response, Toast.LENGTH_LONG).show();
				mTextView.setText(response);
			}
		}, new Response.ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError error) {
				Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_LONG).show();
				mTextView.setText(error.toString());
			}
		}){
		@Override
		protected Map<String, String> getParams() throws AuthFailureError {
			Map<String, String> hashMap = new HashMap<String, String>();
//			hashMap.put("cityname", "北京市");
//			hashMap.put("userid", "10416");
//			hashMap.put("propertyid", "0");
//			hashMap.put("description", "wifi");
			return hashMap;
		}};*/
		request.setTag("post");
		VolleyApplication.getHttpQueues().add(request);
	}

	private void Voley_Get() {
		String url = "http://v.juhe.cn/weather/index?format=2&cityname=%E8%8B%8F%E5%B7%9E&key=44a581bd755b5c2b137d88c7ce9fc58c";
		StringRequest request = new StringRequest(Method.GET, url,new Listener<String>() {

			@Override
			public void onResponse(String response) {
				Toast.makeText(getApplicationContext(), response, Toast.LENGTH_LONG).show();		
				mTextView.setText(response);
			}
		}, new Response.ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError error) {
				Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_LONG).show();	
				mTextView.setText(error.toString());
			}
		});
		request.setTag("get");
		VolleyApplication.getHttpQueues().add(request);
		
//		JsonObjectRequest requests = new JsonObjectRequest(Method.GET, url, null, listener, errorListener)
	}
}
