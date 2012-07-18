package com.mtr.webservice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.http.client.methods.HttpHead;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.mtr.business.entity.Station;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.TextView;

public class WebServiceActivity extends Activity {
	TextView textResult;
	TextView restResult;
	
	private void init() {
		textResult = (TextView) findViewById(R.id.message);
		restResult = (TextView) findViewById(R.id.RESTmessage);
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		init();
		
		textResult.setText("Network available? " + isNetworkAvailable());
		
		if (isNetworkAvailable()) {
			HttpHeaders requestHeaders = new HttpHeaders();
			List<MediaType> acceptableMedia = new ArrayList<MediaType>();
			acceptableMedia.add(MediaType.APPLICATION_JSON);
			
			requestHeaders.setAccept(acceptableMedia);
			
			HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);
			
			RestTemplate restTemplate = new RestTemplate();
			restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());
			
			ResponseEntity<Station[]> responseEntity = restTemplate.exchange("http://mtrappwebservice-alex.appspot.com/station/getAll.do", HttpMethod.GET, requestEntity, Station[].class);
	 		
			Station[] stations = responseEntity.getBody();
			restResult.setText("REST:" + Arrays.toString(stations));
		}
	}

	private boolean isNetworkAvailable() {
		ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo activeNetworkInfo = connectivityManager
				.getActiveNetworkInfo();
		return activeNetworkInfo != null;
	}
}