package com.example.zhou1;

import java.net.MalformedURLException;
import java.net.URL;

import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.widget.ImageView;

public class MyTask extends AsyncTask<String, Integer, Drawable>{
	
	private ImageView it_tu;

	public MyTask(ImageView it_tu) {
		super();
		this.it_tu = it_tu;
	}

	@Override
	protected Drawable doInBackground(String... params) {
		
		try {
			URL url = new URL(params[0]);
			
			return Drawable.createFromStream(url.openStream(), "img");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	@Override
	protected void onPostExecute(Drawable result) {
		super.onPostExecute(result);
		
		it_tu.setImageDrawable(result);
	}

}
